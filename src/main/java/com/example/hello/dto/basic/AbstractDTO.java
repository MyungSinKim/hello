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
package com.example.hello.dto.basic;


import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/5/9 16:32
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
public abstract class AbstractDTO implements Serializable {

    private static final long serialVersionUID = -4077279236469656216L;

    public AbstractDTO() {
    }

    public String toJSON() {
        return JSON.toJSONString(this);
    }

    public String toJSONFormat() {
        return JSON.toJSONString(this, true);
    }
}
