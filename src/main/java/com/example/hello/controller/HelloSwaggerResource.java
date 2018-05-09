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

import com.example.hello.domain.UserDomain;
import com.example.hello.dto.UserDTO;
import com.example.hello.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/5/9 17:33
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
@RestController
public class HelloSwaggerResource implements HelloSwaggerClient {

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDTO get(String id) {
        return null;
    }

    @Override
    public String create(String userId, @RequestBody @Valid UserDTO userDTO) {
        UserDomain userDomain = mapper.toUserDomain(userDTO);
        return userDomain.getUserName();
    }

    @Override
    public String modify(String userId, @RequestBody @Valid UserDTO userDTO) {
        return null;
    }

    @Override
    public String remove(String userId, String id) {
        return null;
    }
}
