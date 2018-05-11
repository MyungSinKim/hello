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

import com.example.hello.common.PageResultBean;
import com.example.hello.common.ResultBean;
import com.example.hello.dao.UserDao;
import com.example.hello.domain.UserDomain;
import com.example.hello.dto.PageDTO;
import com.example.hello.exception.CheckException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/5/10 11:43
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
@RestController
public class HelloAOP {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public PageResultBean<UserDomain> page(@RequestBody @Valid PageDTO pageDTO) {
        return userDao.pageQuery(pageDTO.getPage(), pageDTO.getSize());
    }

    @RequestMapping(value = "/aop", method = RequestMethod.GET)
    public ResultBean<Boolean> aop(@RequestParam(value = "data") String data) {
        System.out.println("aop");
        return new ResultBean<Boolean>(test(data));
    }

    @RequestMapping(value = "/aop2/{data}", method = RequestMethod.GET)
    public ResultBean<Boolean> aop2(@PathVariable("data") String data) {
        System.out.println("aop2");
        return new ResultBean<Boolean>(test(data));
    }

    boolean test(String data) {
        if ("1".equals(data)) {
            return true;
        }
        if ("0".equals(data)) {
            return false;
        }
        if ("2".equals(data)) {
            throw new CheckException("错误2");
        }

        return false;
    }
}
