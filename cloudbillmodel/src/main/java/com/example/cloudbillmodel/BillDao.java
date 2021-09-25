package com.example.cloudbillmodel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillDao extends CrudRepository<Bill,Long> {
    Bill getBillByUserId(Long userId);
}
