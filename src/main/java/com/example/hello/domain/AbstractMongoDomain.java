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
package com.example.hello.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/5/9 14:16
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
public abstract class AbstractMongoDomain extends AbstractDomain {

    private static final long serialVersionUID = -5672212600553783999L;
    @Id
    String id;
    @Field("create_at")
    LocalDateTime createAt;
    @Field("update_at")
    LocalDateTime updateAt;
    @Field("create_by")
    String createBy;
    @Field("update_by")
    String updateBy;
    @Field("del_flag")
    Boolean delFlag;

    public AbstractMongoDomain() {
    }

    public AbstractMongoDomain init(String userId) {
        this.createAt = LocalDateTime.now();
        this.createBy = userId;
        this.updateAt = LocalDateTime.now();
        this.updateBy = userId;
        this.delFlag = Boolean.valueOf(false);
        return this;
    }

    public AbstractMongoDomain(String userId) {
        this.createAt = LocalDateTime.now();
        this.createBy = userId;
        this.updateAt = LocalDateTime.now();
        this.updateBy = userId;
        this.delFlag = Boolean.valueOf(false);
    }

    public AbstractMongoDomain(String id, LocalDateTime createAt, LocalDateTime updateAt, String createBy, String updateBy, Boolean delFlag) {
        this.id = id;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.createBy = createBy;
        this.updateBy = updateBy;
        this.delFlag = delFlag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Boolean getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Boolean delFlag) {
        this.delFlag = delFlag;
    }

}
