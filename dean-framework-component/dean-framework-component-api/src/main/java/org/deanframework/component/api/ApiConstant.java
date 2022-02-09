package org.deanframework.component.api;

/**
 * @auther Dean
 */
public class ApiConstant {

    /**
     * 配置前缀
     */
    public static final String CONFIG_PREFIX = "dean.framework.api";

    /**
     * 内部请求前缀
     */
    public static final String INTERNAL_REQUEST_MAPPING = "${" + CONFIG_PREFIX + ".route.internal-prefix:/internal}";

    /**
     * 外部请求前缀
     */
    public static final String EXTERNAL_REQUEST_MAPPING = "${" + CONFIG_PREFIX + ".route.external-prefix:/api}";

    /**
     * 公共请求前缀
     */
    public static final String PUBLIC_REQUEST_MAPPING = "${" + CONFIG_PREFIX + ".route.public-prefix:/public}";

    /**
     * 外部请求转发
     */
    public static final String EXTERNAL_FORWARD = "EXTERNAL_FORWARD";
}
