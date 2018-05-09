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
package com.example.hello.dao;

import com.example.hello.domain.UserDomain;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/5/9 11:09
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
public interface UserDao {

    /**
     * 创建对象
     *
     * @param user
     */
    public void saveUser(UserDomain user);

    /**
     * 根据用户名查询对象
     *
     * @param userName
     * @return
     */
    public UserDomain findUserByUserName(String userName);

    /**
     * 更新对象
     *
     * @param user
     */
    public void updateUser(UserDomain user);

    /**
     * 删除对象
     *
     * @param id
     */
    public void deleteUserById(String id);
}
