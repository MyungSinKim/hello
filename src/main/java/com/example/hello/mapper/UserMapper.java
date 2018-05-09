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
package com.example.hello.mapper;

import com.example.hello.domain.UserDomain;
import com.example.hello.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/5/9 15:23
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toUserDTO(UserDomain userDomain);

    List<UserDTO> toUserDTOs(List<UserDomain> userDomains);

    UserDomain toUserDomain(UserDTO userDTO);

    List<UserDomain> toUserDomains(List<UserDTO> userDTOs);
}
