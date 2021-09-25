package com.example.springcloudstudy;

import com.example.springcloudstudy.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;


@SpringBootTest
class SpringcloudstudyApplicationTests {
    @Autowired
    UserDao userDao;
    @Test
    @Transactional
    @Rollback(value = false)
    void contextLoads() {
        User user = new User();
        user.setId(1L);
        user.setName("name");
        userDao.save(user);

    }

}
