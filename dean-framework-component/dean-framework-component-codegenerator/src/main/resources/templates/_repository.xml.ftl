<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">

    <sql id="Base_Column_List">
        <#list table.fields as field>${field.name}<#if field_has_next>,</#if></#list>
    </sql>

    <insert id="insert"<#list table.fields as field><#if field.keyIdentityFlag> useGeneratedKeys="true" keyProperty="${field.propertyName}"</#if></#list>>
        INSERT INTO ${table.name}(<#list table.fields as field><#if !field.keyIdentityFlag>${field.name}<#if field_has_next>,</#if></#if></#list>)
        VALUES(<#list table.fields as field><#if !field.keyIdentityFlag><#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse><#if field_has_next>,</#if></#if></#list>)
    </insert>

    <insert id="insertSelective"<#list table.fields as field><#if field.keyIdentityFlag> useGeneratedKeys="true" keyProperty="${field.propertyName}"</#if></#list>>
        INSERT INTO ${table.name}
        <trim prefix="(" suffix=")" suffixOverrides=",">
        <#list table.fields as field>
            <#if !field.keyIdentityFlag>
            <if test="${field.propertyName} != null">
                ${field.name},
            </if>
            </#if>
        </#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
        <#list table.fields as field>
            <#if !field.keyIdentityFlag>
            <if test="${field.propertyName} != null">
                <#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>,
            </if>
            </#if>
        </#list>
        </trim>
    </insert>

    <insert id="insertBatch"<#list table.fields as field><#if field.keyIdentityFlag> useGeneratedKeys="true" keyProperty="${field.propertyName}"</#if></#list>>
        INSERT INTO ${table.name} (<#list table.fields as field><#if !field.keyIdentityFlag>${field.name}<#if field_has_next>,</#if></#if></#list>)
        VALUES
        <foreach collection="list" item="item" separator=",">
            (
            <#list table.fields as field>
                <#if !field.keyIdentityFlag>
                <#noparse>#{item.</#noparse>${field.propertyName}<#noparse>}</#noparse><#if field_has_next>,</#if>
                </#if>
            </#list>
            )
        </foreach>
    </insert>

    <update id="updateByPrimaryKey">
        UPDATE ${table.name}
        <set>
    <#list table.fields as field>
        <#if !field.keyFlag>
            ${field.name}=<#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse><#if field_has_next>,</#if>
        </#if>
    </#list>
        </set>
        WHERE <#list table.fields as field><#if field.keyFlag>${field.name}=<#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse></#if></#list>
    </update>

    <update id="updateByPrimaryKeySelective">
        UPDATE ${table.name}
        <set>
    <#list table.fields as field>
        <#if !field.keyFlag>
            <if test="${field.propertyName} != null">
                ${field.name}=<#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse><#if field_has_next>,</#if>
            </if>
        </#if>
    </#list>
        </set>
        WHERE <#list table.fields as field><#if field.keyFlag>${field.name}=<#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse></#if></#list>
    </update>

    <update id="updateBatch">
        <foreach close="" collection="list" item="item" open="" separator=";">
            UPDATE ${table.name}
            <set>
        <#list table.fields as field>
            <#if !field.keyFlag>
                <if test="item.${field.propertyName} != null">
                    ${field.name}=<#noparse>#{</#noparse>item.${field.propertyName}<#noparse>}</#noparse><#if field_has_next>,</#if>
                </if>
            </#if>
        </#list>
            </set>
            WHERE <#list table.fields as field><#if field.keyFlag>${field.name}=<#noparse>#{</#noparse>item.${field.propertyName}<#noparse>}</#noparse></#if></#list>
        </foreach>
    </update>

    <select id="findByPrimaryKey" resultType="${package.Entity}.${table.entityName}">
        SELECT
        <include refid="Base_Column_List"/>
        FROM ${table.name}
        WHERE <#list table.fields as field><#if field.keyFlag>${field.name}=<#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse></#if></#list>
    </select>

    <select id="findByPrimaryKeys" resultType="${package.Entity}.${table.entityName}">
        SELECT
        <include refid="Base_Column_List"/>
        FROM ${table.name}
        WHERE <#list table.fields as field><#if field.keyFlag>${field.name}</#if></#list> IN
        <foreach collection="list" item="item" open="(" separator="," close=")">
            <#noparse>#{item}</#noparse>
        </foreach>
    </select>

    <select id="findByEntity" resultType="${package.Entity}.${table.entityName}">
        SELECT
        <include refid="Base_Column_List"/>
        FROM ${table.name}
        <where>
    <#list table.fields as field>
            <if test="${field.propertyName} != null">
                <#if field_index != 0>AND </#if>${field.name}=<#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>
            </if>
    </#list>
        </where>
    </select>

    <select id="findOneByEntity" resultType="${package.Entity}.${table.entityName}">
        SELECT
        <include refid="Base_Column_List"/>
        FROM ${table.name}
        <where>
    <#list table.fields as field>
            <if test="${field.propertyName} != null">
                <#if field_index != 0>AND </#if>${field.name}=<#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse>
            </if>
    </#list>
        </where>
        LIMIT 1
    </select>

    <delete id="deleteByPrimaryKey">
        DELETE FROM ${table.name}
        WHERE <#list table.fields as field><#if field.keyFlag>${field.name}=<#noparse>#{</#noparse>${field.propertyName}<#noparse>}</#noparse></#if></#list>
    </delete>

    <delete id="deleteByPrimaryKeys">
        DELETE FROM ${table.name} WHERE <#list table.fields as field><#if field.keyFlag>${field.name}</#if></#list> IN
        <foreach collection="list" item="item" open="(" separator="," close=")">
            <#noparse>#{item}</#noparse>
        </foreach>
    </delete>

</mapper>