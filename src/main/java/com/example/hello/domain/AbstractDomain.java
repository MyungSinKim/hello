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
package com.example.hello.domain;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.Map;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/5/9 16:38
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
public abstract class AbstractDomain implements Serializable {

    private static final long serialVersionUID = -7820129293679956382L;

    public AbstractDomain() {
    }

    public String toJSON() {
        return JSON.toJSONString(this);
    }

    public String toJSONFormat() {
        return JSON.toJSONString(this, true);
    }

    public Map<String, Object> toMap() {
        return (Map) JSON.parseObject(this.toJSON(), Map.class);
    }
}
