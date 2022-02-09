package org.deanframework.component.codegenerator.util;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.deanframework.component.codegenerator.config.CodeGeneratorConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dean
 */
public class CodeGeneratorUtil {

    /**
     * 全局配置
     * @param codeGeneratorConfig
     * @param autoGenerator
     */
    public static void buildGlobalConfig(CodeGeneratorConfig codeGeneratorConfig, AutoGenerator autoGenerator) {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(codeGeneratorConfig.getOutputBasePath());
        globalConfig.setAuthor(codeGeneratorConfig.getAuthor());
        globalConfig.setOpen(false);
        autoGenerator.setGlobalConfig(globalConfig);
    }

    /**
     * 数据源配置
     * @param codeGeneratorConfig
     * @param autoGenerator
     */
    public static void buildDataSourceConfig(CodeGeneratorConfig codeGeneratorConfig, MySqlTypeConvert mySqlTypeConvert, AutoGenerator autoGenerator) {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(codeGeneratorConfig.getUrl());
        dataSourceConfig.setDriverName(codeGeneratorConfig.getDriverName());
        dataSourceConfig.setUsername(codeGeneratorConfig.getUsername());
        dataSourceConfig.setPassword(codeGeneratorConfig.getPassword());
        //自定义数据库表字段类型转换
        dataSourceConfig.setTypeConvert(mySqlTypeConvert);
        autoGenerator.setDataSource(dataSourceConfig);
    }

    /**
     * 包配置
     * @param codeGeneratorConfig
     * @param autoGenerator
     */
    public static void buildPackageConfig(CodeGeneratorConfig codeGeneratorConfig, AutoGenerator autoGenerator) {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("");
        packageConfig.setMapper(codeGeneratorConfig.getRepositoryPackage());
        packageConfig.setEntity(codeGeneratorConfig.getModelPackage());
        autoGenerator.setPackageInfo(packageConfig);
    }

    /**
     * 自定义配置
     * @param codeGeneratorConfig
     * @param autoGenerator
     */
    public static void buildInjectionConfig(CodeGeneratorConfig codeGeneratorConfig, AutoGenerator autoGenerator) {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {}
        };
        //自定义输出配置
        List<FileOutConfig> fileOutConfigList = new ArrayList<>();
        //添加生成xml文件
        fileOutConfigList.add(new FileOutConfig(codeGeneratorConfig.getTemplatePath() + "/_repository.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                tableInfo.setMapperName(tableInfo.getEntityName() + "Repository");
                return codeGeneratorConfig.getOutputBasePath() + "/resources/" + codeGeneratorConfig.getRepositoryPackage().replace(".", "/") + "/auto/_" + tableInfo.getEntityName() + "Repository" + StringPool.DOT_XML;
            }
        });
        fileOutConfigList.add(new FileOutConfig(codeGeneratorConfig.getTemplatePath() + "/repository.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                tableInfo.setMapperName(tableInfo.getEntityName() + "Repository");
                return codeGeneratorConfig.getOutputBasePath() + "/resources/" + codeGeneratorConfig.getRepositoryPackage().replace(".", "/") + "/" + tableInfo.getEntityName() + "Repository" + StringPool.DOT_XML;
            }
        });
        //添加生成java文件
        fileOutConfigList.add(new FileOutConfig(codeGeneratorConfig.getTemplatePath() + "/repository.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return codeGeneratorConfig.getOutputBasePath() + "/java/" + codeGeneratorConfig.getRepositoryPackage().replace(".", "/") + "/" + tableInfo.getEntityName() + "Repository" + StringPool.DOT_JAVA;
            }
        });
        fileOutConfigList.add(new FileOutConfig(codeGeneratorConfig.getTemplatePath() + "/model.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return codeGeneratorConfig.getOutputBasePath() + "/java/" + codeGeneratorConfig.getModelPackage().replace(".", "/") + "/" + tableInfo.getEntityName() + StringPool.DOT_JAVA;
            }
        });
        injectionConfig.setFileOutConfigList(fileOutConfigList);
        autoGenerator.setCfg(injectionConfig);
    }

    /**
     * 配置模板
     * @param autoGenerator
     */
    public static void buildTemplateConfig(CodeGeneratorConfig codeGeneratorConfig, AutoGenerator autoGenerator) {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity(null);
        templateConfig.setMapper(null);
        templateConfig.setService(null);
        templateConfig.setServiceImpl(null);
        templateConfig.setController(null);
        templateConfig.setXml(null);
        autoGenerator.setTemplate(templateConfig);
    }

    /**
     * 策略配置
     * @param codeGeneratorConfig
     * @param autoGenerator
     */
    public static void buildStrategyConfig(CodeGeneratorConfig codeGeneratorConfig, AutoGenerator autoGenerator) {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setInclude(codeGeneratorConfig.getTableNames().split(","));
        autoGenerator.setStrategy(strategyConfig);
    }
}
