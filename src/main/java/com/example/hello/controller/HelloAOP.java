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

import com.example.hello.common.ResultBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/5/10 11:43
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
@RestController
public class HelloAOP {

    @RequestMapping(value = "/aop", method = RequestMethod.GET)
    public ResultBean<String> aop(@RequestParam(value = "data") String data) {
        System.out.println("aop");
        return new ResultBean<String>(data);
    }
}
