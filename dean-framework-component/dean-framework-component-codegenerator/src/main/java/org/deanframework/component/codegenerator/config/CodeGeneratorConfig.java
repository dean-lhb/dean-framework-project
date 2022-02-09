package org.deanframework.component.codegenerator.config;

import lombok.Data;

/**
 * @author Dean
 */
@Data
public class CodeGeneratorConfig {

    private String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8";
    private String driverName = "com.mysql.jdbc.Driver";
    private String username = "root";
    private String password = "123456";
    private String author = "Dean";
    private String modelPackage = "com.sample.test.datasource.test.model";
    private String repositoryPackage = "com.sample.test.datasource.test.repository";
    private String tableNames = "test,test2";
    private final String projectPath = System.getProperty("user.dir");
    private final String outputBasePath = projectPath + "/codegenerator/src/main";
    private final String templatePath = "templates";
}
