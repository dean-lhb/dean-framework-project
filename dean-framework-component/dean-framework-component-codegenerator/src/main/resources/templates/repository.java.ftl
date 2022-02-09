package ${package.Mapper};

import ${package.Entity}.${entity};
import org.deanframework.component.autocoding.entity.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ${author}
 * @date ${date}
 */
@Repository
public interface ${table.mapperName} extends BaseRepository<${entity},<#list table.fields as field><#if field.keyFlag>${field.propertyType}</#if></#list>> {
}