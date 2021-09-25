package com.example.springcloudstudy;

import com.example.springcloudstudy.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    User getUserById(Long id);
}
