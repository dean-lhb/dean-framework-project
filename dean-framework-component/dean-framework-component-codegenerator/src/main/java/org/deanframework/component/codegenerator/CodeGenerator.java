package org.deanframework.component.codegenerator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.deanframework.component.codegenerator.config.CodeGeneratorConfig;
import org.deanframework.component.codegenerator.util.CodeGeneratorUtil;

/**
 * @author Dean
 */
public class CodeGenerator {

    public CodeGenerator(CodeGeneratorConfig codeGeneratorConfig) {
        this(codeGeneratorConfig, new MySqlTypeConvert());
    }

    public CodeGenerator(CodeGeneratorConfig codeGeneratorConfig, MySqlTypeConvert mySqlTypeConvert) {
        AutoGenerator autoGenerator = new AutoGenerator();
        CodeGeneratorUtil.buildGlobalConfig(codeGeneratorConfig, autoGenerator);
        CodeGeneratorUtil.buildDataSourceConfig(codeGeneratorConfig, mySqlTypeConvert, autoGenerator);
        CodeGeneratorUtil.buildPackageConfig(codeGeneratorConfig, autoGenerator);
        CodeGeneratorUtil.buildInjectionConfig(codeGeneratorConfig, autoGenerator);
        CodeGeneratorUtil.buildTemplateConfig(codeGeneratorConfig, autoGenerator);
        CodeGeneratorUtil.buildStrategyConfig(codeGeneratorConfig, autoGenerator);
        autoGenerator.setTemplateEngine(new FreemarkerTemplateEngine());
        autoGenerator.execute();
    }
}
