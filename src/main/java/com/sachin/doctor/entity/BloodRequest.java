package com.sachin.doctor.entity;

import jakarta.persistence.*;

@Entity
public class BloodRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String requiredGroup;
    private String city;
    private String contact;
}
