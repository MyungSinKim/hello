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
package com.example.hello.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * @author LarryKoo (larrykoo@126.com)
 * @description TODO
 * @date 2018/5/11 15:47
 * @slogon 站在巨人的肩膀上
 * @since 1.0.0
 */
public abstract class MongoDao<T> {
    private static final Logger logger = LoggerFactory.getLogger(MongoDao.class);

    @Autowired
    protected MongoTemplate mongoTemplate;

    /**
     * 钩子方法,由子类实现返回反射对象的类型
     *
     * @return
     */
    protected abstract Class<T> getEntityClass();

    /**
     * 保存一个对象
     *
     * @param t
     */
    public void save(T t) {
        logger.info("[Mongo Dao ] save:" + t);
        this.mongoTemplate.save(t);
    }

    /**
     * 根据Id从Collection中查询对象
     *
     * @param id
     * @return T
     */
    public T findById(String id) {
        Query query = new Query();
        Criteria criteria = Criteria.where("_id").is(id);
        query.addCriteria(criteria);
        logger.info("[Mongo Dao ] findById:" + query);
        return this.mongoTemplate.findOne(query, this.getEntityClass());
    }

    /**
     * 根据条件查询集合
     *
     * @param query
     * @return List<T>
     */
    public List<T> findByList(Query query) {
        logger.info("[Mongo Dao ] findByList:" + query);
        return this.mongoTemplate.find(query, this.getEntityClass());
    }

    /**
     * 通过条件查询单个实体
     *
     * @param query
     * @return
     */
    public T findOne(Query query) {
        logger.info("[Mongo Dao ] findOne:" + query);
        return this.mongoTemplate.findOne(query, this.getEntityClass());
    }

    /**
     * 通过条件进行分页查询
     *
     * @param query
     * @param start
     * @param size
     * @return List<T>
     */
    public List<T> getPage(Query query, int start, int size) {
        query.skip(start);
        query.limit(size);
        logger.info("[Mongo Dao ] getPage:" + query + "(" + start + "," + size + ")");
        List<T> lists = this.mongoTemplate.find(query, this.getEntityClass());
        return lists;
    }

    /**
     * 根据条件查询库中符合记录的总数,为分页查询服务
     *
     * @param query
     * @return Long
     */
    public Long getPageCount(Query query) {
        logger.info("[Mongo Dao ] getPageCount:" + query);
        return this.mongoTemplate.count(query, this.getEntityClass());
    }

    /**
     * 根据Id删除对象
     *
     * @param id
     */
    public void removeById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, this.getEntityClass());
    }

    /**
     * 删除对象
     *
     * @param query
     */
    public void remove(Query query) {
        mongoTemplate.remove(query, this.getEntityClass());
    }

    /**
     * 删除对象
     *
     * @param t
     */
    public void remove(T t) {
        logger.info("[Mongo Dao ] remove:" + t);
        this.mongoTemplate.remove(t);
    }

    /**
     * 更新满足条件的第一个记录
     *
     * @param query
     * @param update
     */
    public void updateFirst(Query query, Update update) {
        logger.info("[Mongo Dao ] updateFirst:query(" + query + "),update(" + update + ")");
        this.mongoTemplate.updateFirst(query, update, this.getEntityClass());
    }

    /**
     * 更新满足条件的所有记录
     *
     * @param query
     * @param update
     */
    public void updateMulti(Query query, Update update) {
        logger.info("[Mongo Dao ] updateMulti:query(" + query + "),update(" + update + ")");
        this.mongoTemplate.updateMulti(query, update, this.getEntityClass());
    }

    /**
     * 查找更新,如果没有找到符合的记录,则将更新的记录插入库中
     *
     * @param query
     * @param update
     */
    public void updateInser(Query query, Update update) {
        logger.info("[Mongo Dao ]updateInser:query(" + query + "),update(" + update + ")");
        this.mongoTemplate.upsert(query, update, this.getEntityClass());
    }

}
