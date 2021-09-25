package com.example.springcloudstudy.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
public class User {
    @Id
    Long id;
    String name;
}
