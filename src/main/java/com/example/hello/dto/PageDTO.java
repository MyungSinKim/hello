/*
 * 四川生学教育科技有限公司
 * Copyright (c) 2015-2025 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 *
 */
package com.example.hello.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/5/11 17:38
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
@ApiModel(description = "分页")
@Data
public class PageDTO {
    @NotNull
    @ApiModelProperty(value = "当前页码", required = true)
    private Integer page;
    @NotNull
    @ApiModelProperty(value = "每页记录数", required = true)
    private Integer size;
}
