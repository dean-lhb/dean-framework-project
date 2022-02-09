package org.deanframework.component.pagination;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Dean
 */
@Data
public class PaginationResponse<T> {

    @ApiModelProperty(value = "当前页")
    private Integer pageNum;

    @ApiModelProperty(value = "每页数量")
    private Integer pageSize;

    @ApiModelProperty(value = "总页数")
    private Integer pages;

    @ApiModelProperty(value = "总记录数")
    private Long total;

    @ApiModelProperty(value = "结果集")
    private List<T> list = new ArrayList();
}