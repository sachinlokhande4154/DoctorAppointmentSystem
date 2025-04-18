package com.sachin.doctor.controller;

import com.sachin.doctor.entity.BloodRequest;
import com.sachin.doctor.entity.Donor;
import com.sachin.doctor.repository.BloodRequestRepository;
import com.sachin.doctor.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blood")
@CrossOrigin(origins = "*")
public class BloodController {

    @Autowired
    private DonorRepository donorRepo;

    @Autowired
    private BloodRequestRepository bloodRequestRepo;

    // POST: Register new blood donor
    @PostMapping("/donor")
    public Donor registerDonor(@RequestBody Donor donor) {
        return donorRepo.save(donor);
    }

    // GET: Find donors by city + blood group
    @GetMapping("/search")
    public List<Donor> searchDonors(@RequestParam String city, @RequestParam String group) {
        return donorRepo.findByCityAndBloodGroup(city, group);
    }

    // POST: Log blood request (optional)
    @PostMapping("/request")
    public BloodRequest logBloodRequest(@RequestBody BloodRequest request) {
        return bloodRequestRepo.save(request);
    }
}
