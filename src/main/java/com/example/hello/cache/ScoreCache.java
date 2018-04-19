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
package com.example.hello.cache;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/4/17 10:34
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
@Data
public class ScoreCache implements Serializable {

    /**
     * 得分IP地址
     */
    private String ipAddress;
    /**
     * 用时秒
     */
    private int second;
    /**
     * 得分
     */
    private int score;
    /**
     * 得分时间
     */
    private long timestamp;
}
