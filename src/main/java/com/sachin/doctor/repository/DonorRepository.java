package com.sachin.doctor.repository;

import com.sachin.doctor.entity.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonorRepository extends JpaRepository<Donor, Long> {
    List<Donor> findByCityAndBloodGroup(String city, String bloodGroup);
}
