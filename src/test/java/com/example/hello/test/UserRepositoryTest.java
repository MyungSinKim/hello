package com.example.hello.test;

import com.example.hello.domain.UserDomain;
import com.example.hello.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() throws Exception {
        UserDomain user = new UserDomain();
        user.init("u_001");
        user.setUserName("小明");
        user.setPassWord("fffooo123");
        userRepository.save(user);
    }

    @Test
    public void findUserByUserName() {
        List<UserDomain> list = userRepository.findAllByName("小明");
        System.out.println(list.size());
    }

    @Test
    public void findByUserId() {
        UserDomain userDomain = userRepository.findByUserId("5af508b8f445d80c5420d78a");
        System.out.println(userDomain.getUserName());
    }

    @Test
    public void updateUser() {

    }

    @Test
    public void deleteUserById() {
        userRepository.deleteById("");
    }


}