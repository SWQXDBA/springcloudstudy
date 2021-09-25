package com.example.cloudbillmodel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class CloudbillmodelApplicationTests {
    @Autowired
    BillDao billDao;

    @Test
    @Transactional
    @Rollback(value = false)
    void contextLoads() {
        Bill bill = new Bill();
        bill.setId(1L);
        bill.setUserId(1L);
        billDao.save(bill);
    }

}
