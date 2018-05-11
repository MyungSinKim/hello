package com.example.hello.domain;

import com.example.hello.domain.basic.AbstractMongoDomain;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/5/9 11:05
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
@Data
@ToString
@Document(collection = "user_info")
public class UserDomain extends AbstractMongoDomain {

    private static final long serialVersionUID = 4514785026144588722L;
    @Field("user_name")
    private String userName;
    @Field("pass_word")
    private String passWord;


}