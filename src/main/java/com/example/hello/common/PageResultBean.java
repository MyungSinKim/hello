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
package com.example.hello.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/5/10 10:39
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
@Data
public class PageResultBean<T> implements Serializable {
    private static final long serialVersionUID = 3836384492363948079L;

    public static final int SUCCESS = 0;
    public static final int FAIL = 1;
    public static final int NO_PERMISSION = 2;

    private String msg = "success";
    private int code = SUCCESS;
    private T data;

    public PageResultBean() {
        super();
    }

    public PageResultBean(T data) {
        super();
        this.data = data;
    }

    public PageResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = FAIL;
    }
}
