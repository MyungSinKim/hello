package com.example.hello.test;

import com.example.hello.dao.UserDao;
import com.example.hello.domain.UserDomain;
import com.example.hello.dto.UserDTO;
import com.example.hello.mapper.UserMapper;
import com.example.hello.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

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

    }

    @Test
    public void updateUser() {

    }

    @Test
    public void deleteUserById() {
        userRepository.deleteById("");
    }

}