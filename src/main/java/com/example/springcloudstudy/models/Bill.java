package com.example.springcloudstudy.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
public class Bill {

    Long id;
    Long userId;
}
