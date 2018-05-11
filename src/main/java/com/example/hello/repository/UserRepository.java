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
package com.example.hello.repository;

import com.example.hello.domain.UserDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/5/9 19:04
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
@Repository
public interface UserRepository extends MongoRepository<UserDomain, String> {
    @Query("{'user_name':?0}")
    List<UserDomain> findAllByName(String name);

    @Query("{'id':?0}")
    UserDomain findByUserId(String id);
}
