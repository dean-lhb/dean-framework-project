package org.deanframework.component.storage.service;

import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnails;
import org.deanframework.component.storage.config.StorageConfig;
import org.deanframework.component.storage.constant.CharacterConstant;
import org.deanframework.component.storage.constant.FileTypeConstant;
import org.deanframework.component.storage.entity.UploadResponse;
import org.deanframework.component.storage.exception.StorageException;
import org.deanframework.component.storage.exception.StorageMaxLimitException;
import org.deanframework.component.storage.exception.StorageNotAllowException;
import org.deanframework.component.storage.util.StorageUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @auther Dean
 */
@Slf4j
public class UploadService {

    private StorageConfig storageConfig;

    private Map<String, String> type = new HashMap<>();

    public UploadService(StorageConfig storageConfig) {
        this.storageConfig = storageConfig;
        if (StringUtils.isEmpty(storageConfig.getBasePath())) {
            throw new StorageException("文件存储路径basePath不能为空");
        }
        if (StringUtils.isEmpty(storageConfig.getDirDateFormat())) {
            throw new StorageException("文件存储路径dirDateFormat不能为空");
        }
        Map<String, List<String>> originalType = storageConfig.getType();
        for (Map.Entry<String, List<String>> fileTypes : originalType.entrySet()) {
            for (String fileType : fileTypes.getValue()) {
                type.put(fileType, fileTypes.getKey());
            }
        }
        log.info("\n ***上传配置信息初始化完成*** \n");
    }

    /**
     * 处理文件上传
     * @param files
     * @param isThumb
     * @param width
     * @return
     */
    public List<UploadResponse> handle(List<MultipartFile> files, String isThumb, String width) {
        String date = StorageUtil.getDir(storageConfig.getDirDateFormat());
        List<UploadResponse> responseList = new ArrayList<>();
        for (MultipartFile file : files) {
            log.debug("\n ***UploadService***getContentType***{}", file.getContentType());
            String fileType = storageConfig.getAllowMime().get(file.getContentType().replace(CharacterConstant.PATH_SEPARATOR, CharacterConstant.EMPTY_CHARACTER));
            if (Objects.isNull(fileType)) {
                throw new StorageNotAllowException("不允许上传的文件类型");
            }
            Long fileTypeMaxSize = storageConfig.getTypeMaxSize().get(type.get(fileType));
            fileTypeMaxSize = Objects.isNull(fileTypeMaxSize) ? storageConfig.getGlobalMaxSize() : fileTypeMaxSize;
            if (file.getSize() > fileTypeMaxSize) {
                throw new StorageMaxLimitException("文件大小超过最大限制");
            }
            String dirName = type.get(fileType);
            String dirPath =  dirName + CharacterConstant.PATH_SEPARATOR + date + CharacterConstant.PATH_SEPARATOR;
            //获取文件名
            String originalFileName = file.getOriginalFilename();
            //获取文件的后缀
            String fileExt = originalFileName.substring(originalFileName.lastIndexOf(CharacterConstant.SPOT) + 1).toLowerCase();
            String mediaId = StorageUtil.uuid();
            String fileName = mediaId + CharacterConstant.SPOT + fileExt;
            String filePath = storageConfig.getBasePath() + dirPath + fileName;
            File dest = new File(filePath);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
                UploadResponse uploadResponse = new UploadResponse();
                uploadResponse.setOriginalName(originalFileName);
                uploadResponse.setUrl(dirPath + fileName);
                //图片类型
                if (FileTypeConstant.IMAGE.equals(dirName)) {
                    if (storageConfig.getBigImageOpen() == 1) {
                        //生成大图
                        String bigImageName = fileName + CharacterConstant.UNDERLINE + storageConfig.getBigImageWidth() + CharacterConstant.SPOT + fileExt;
                        Thumbnails.of(filePath)
                                .width(storageConfig.getBigImageWidth())
                                .toFile(storageConfig.getBasePath() + dirPath + bigImageName);
                        uploadResponse.setUrl(dirPath + bigImageName);
                    }
                    if (storageConfig.getThumbOpen() == 1 && !"0".equals(isThumb) || "1".equals(isThumb)) {
                        //生成缩略图
                        int toWidth = Objects.nonNull(width) ? Integer.parseInt(width) : storageConfig.getThumbWidth();
                        String thumbFileName = fileName + CharacterConstant.UNDERLINE + toWidth + CharacterConstant.SPOT + fileExt;
                        Thumbnails.of(filePath)
                                .width(toWidth)
                                .toFile(storageConfig.getBasePath() + dirPath + thumbFileName);
                        uploadResponse.setThumb(dirPath + thumbFileName);
                    }
                }
                responseList.add(uploadResponse);
            } catch (IOException e) {
                throw new StorageException(e);
            }
        }
        return responseList;
    }
}
