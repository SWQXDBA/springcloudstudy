package com.example.cloudbillmodel;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Bill {
    @Id
    Long id;
    Long userId;
}
