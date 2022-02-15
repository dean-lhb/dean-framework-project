package org.deanframework.component.storage.config;

import lombok.Data;
import org.deanframework.component.storage.constant.CharacterConstant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther Dean
 */
@Data
public class StorageConfig {

    private String basePath = System.getProperty("user.dir") + CharacterConstant.PATH_SEPARATOR + "file" + CharacterConstant.PATH_SEPARATOR;
    private long globalMaxSize = 5 * 1024 * 1024;
    private Map<String, List<String>> type = new HashMap<>();
    private Map<String, String> allowMime = new HashMap<>();
    private Map<String, Long> typeMaxSize = new HashMap<>();
    private String dirDateFormat = "yyyy/MM/dd";
    private int thumbOpen = 1;
    private int thumbWidth = 300;
    private int bigImageOpen = 1;
    private int bigImageWidth = 800;
}
