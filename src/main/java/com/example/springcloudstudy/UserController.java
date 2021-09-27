package com.example.springcloudstudy;

import com.example.springcloudstudy.models.Bill;
import com.example.springcloudstudy.models.User;
import com.example.springcloudstudy.models.UserAndBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserDao userDao;
    @Autowired
    RestTemplate restTemplate;
    /***
     * http://localhost:8081/user/1
     * @param userid
     * @return http://localhost:8082/billuser/1
     */
    @RequestMapping("/{userid}")
    public UserAndBill getUser(@PathVariable("userid") Long userid){
        User user = userDao.getUserById(userid);
        Bill bill = restTemplate.getForObject("http://billService/billuser/" + user.getId(), Bill.class);
        UserAndBill userAndBill = new UserAndBill();
        userAndBill.setUser(user);
        userAndBill.setBill(bill);

        return userAndBill ;
    }
}
