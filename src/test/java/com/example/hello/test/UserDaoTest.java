package com.example.hello.test;

import com.example.hello.dao.UserDao;
import com.example.hello.domain.UserDomain;
import com.example.hello.dto.UserDTO;
import com.example.hello.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper mapper;

    @Test
    public void testSaveUser() throws Exception {
        UserDomain user = new UserDomain();
        user.init("u_001");
        user.setUserName("小明");
        user.setPassWord("fffooo123");
        userDao.saveUser(user);
    }

    @Test
    public void findUserByUserName() {
        UserDomain user = userDao.findUserByUserName("小明");
        System.out.println("user is " + user + "," + user.getId());
    }

    @Test
    public void updateUser() {
        UserDomain user = new UserDomain();
        user.setId("5af29a99f445d8257877167d");
        user.setUserName("天空");
        user.setPassWord("fffxxxx");
        userDao.updateUser(user);
    }

    @Test
    public void deleteUserById() {
        userDao.deleteUserById("5af29a99f445d8257877167d");
    }


    @Test
    public void mapstruct() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName("测试");
        userDTO.setPassWord("密码");

        UserDomain userDomain = mapper.toUserDomain(userDTO);
        System.out.println("userDomain is " + userDomain);
    }
}