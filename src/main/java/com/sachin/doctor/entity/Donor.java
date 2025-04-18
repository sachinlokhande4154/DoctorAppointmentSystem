package com.sachin.doctor.entity;

import jakarta.persistence.*;

@Entity
public class Donor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String bloodGroup;
    private String city;
    private String contact;
}
