package org.deanframework.component.api;

import lombok.Data;

/**
 * @auther Dean
 */
@Data
public class ApiProperties {

    /**
     * 响应体不处理的包
     */
    private String[] responseBodyAdviceNotIncludePackages = {"springfox."};

    /**
     * 路由
     */
    private Route route = new Route();

    @Data
    public static class Route {

        /**
         * 内部请求前缀
         */
        private String internalPrefix = "internal";

        /**
         * 外部请求前缀
         */
        private String externalPrefix = "api";

        /**
         * 公共请求前缀
         */
        private String publicPrefix = "public";
    }
}
