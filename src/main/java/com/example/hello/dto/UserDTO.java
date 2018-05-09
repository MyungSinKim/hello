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
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/5/9 15:22
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
@ApiModel(description = "用户")
@Data
public class UserDTO extends AbstractMongoDTO {
    private static final long serialVersionUID = -5670903940473485061L;

    @NotNull
    @Size(max = 256)
    @ApiModelProperty(value = "用户名", required = true)
    private String userName;
    @NotNull
    @Size(max = 256)
    @ApiModelProperty(value = "密码", required = true)
    private String passWord;
}
