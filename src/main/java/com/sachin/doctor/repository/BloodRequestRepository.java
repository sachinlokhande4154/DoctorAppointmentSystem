package com.sachin.doctor.repository;

import com.sachin.doctor.entity.BloodRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodRequestRepository extends JpaRepository<BloodRequest, Long> {
}
