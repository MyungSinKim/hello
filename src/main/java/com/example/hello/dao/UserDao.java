package com.example.hello.dao;

import com.example.hello.common.MongoDao;
import com.example.hello.common.PageResultBean;
import com.example.hello.domain.UserDomain;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

@Component
public class UserDao extends MongoDao<UserDomain> {

    @Override
    protected Class<UserDomain> getEntityClass() {
        return UserDomain.class;
    }

    /**
     * 根据用户名查询对象
     *
     * @param userName
     * @return
     */
    public UserDomain findUserByUserName(String userName) {
        Query query = new Query(Criteria.where("userName").is(userName));
        UserDomain user = this.findOne(query);
        return user;
    }


    /**
     * 更新对象
     *
     * @param user
     */
    public void updateUser(UserDomain user) {
        Query query = new Query(Criteria.where("id").is(user.getId()));
        Update update = new Update().set("userName", user.getUserName())
                .set("passWord", user.getPassWord());
        //更新查询返回结果集的第一条
        this.updateFirst(query, update);
        //更新查询返回结果集的所有
        //this.updateMulti(query,update );
    }

    /**
     * 删除对象
     *
     * @param id
     */
    public void deleteUserById(String id) {
        this.removeById(id);
    }

    public PageResultBean<UserDomain> pageQuery(Integer page, Integer size) {
        Criteria criteria = Criteria.where("delFlag").is(Boolean.FALSE);
        Query query = new Query(criteria);
        query.with(new Sort(Sort.Direction.DESC, "createAt"));
        return this.pageQuery(query, page, size);
    }
}