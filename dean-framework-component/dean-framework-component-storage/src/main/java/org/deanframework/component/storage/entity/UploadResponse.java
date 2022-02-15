package org.deanframework.component.storage.entity;

import lombok.Data;

/**
 * @auther Dean
 */
@Data
public class UploadResponse {

    /** 文件路径 */
    private String url;
    /** 原始文件名 */
    private String originalName;
    /** 缩略图路径 */
    private String thumb;
}
