package com.example.cloudbillmodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billuser")
public class BillController {
    @Autowired
    BillDao billDao;
    @RequestMapping("/{billuserid}")
    public Bill getBill(@PathVariable("billuserid") Long billUserId){
        return billDao.getBillByUserId(billUserId);
    }
}
