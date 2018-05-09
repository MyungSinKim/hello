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

import com.example.hello.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/4/17 20:02
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
@Api(value = "用户 Client Restful API", description = "用户测试 (测试用户)", protocols = "application/json")
public interface HelloSwaggerClient {

    @ApiOperation(value = "按ID查询 (用户) #2018-05-09#", notes = "按ID查询单条记录信息")
    @ApiImplicitParam(name = "id", value = "唯一ID", paramType = "path", dataType = "string", required = true)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    UserDTO get(@PathVariable("id") String id);

    @ApiOperation(value = "创建用户 (用户) #2018-05-09#", notes = "创建用户对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", paramType = "path", dataType = "string", required = true),
            @ApiImplicitParam(name = "userDTO", value = "UserDTO", paramType = "body", dataType = "UserDTO", required = true)
    })
    @RequestMapping(value = "/create/{userId}", method = RequestMethod.POST)
    String create(@PathVariable("userId") String userId, @RequestBody @Valid UserDTO userDTO);


    @ApiOperation(value = "更新用户 (用户) #2018-05-09#", notes = "更新用户对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", paramType = "path", dataType = "string", required = true),
            @ApiImplicitParam(name = "userDTO", value = "UserDTO", paramType = "body", dataType = "UserDTO", required = true)
    })
    @RequestMapping(value = "/modify/{userId}", method = RequestMethod.PUT)
    String modify(@PathVariable("userId") String userId, @RequestBody @Valid UserDTO userDTO);

    @ApiOperation(value = "删除用户 (用户) #2018-05-09#", notes = "删除用户对象")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "操作用户ID", paramType = "query", dataType = "string", required = true),
            @ApiImplicitParam(name = "id", value = "唯一ID", paramType = "query", dataType = "string", required = true)
    })
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    String remove(@RequestParam(value = "userId") String userId, @RequestParam(value = "id") String id);
}
