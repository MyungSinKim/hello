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
package com.example.hello.controller;

import com.example.hello.cache.ScoreCache;
import com.example.hello.util.IPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/4/17 20:02
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
@RestController
public class Hello {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    @Autowired
    private RedisTemplate redisTemplate;


    @RequestMapping(value = "/save_score", method = RequestMethod.POST)
    public void saveScore(@RequestBody ScoreCache scoreCache, HttpServletRequest request) {
        long timestamp = System.currentTimeMillis();
        scoreCache.setTimestamp(timestamp);
        scoreCache.setIpAddress(IPUtil.getIpAddr(request));
        redisTemplate.opsForList().leftPush("SCORE", scoreCache);
    }


    @RequestMapping(value = "/get_score", method = RequestMethod.GET)
    public List<ScoreCache> getScore() {
        return redisTemplate.opsForList().range("SCORE", 0, 19);
    }
}
