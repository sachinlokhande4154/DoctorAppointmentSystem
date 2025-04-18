package com.sachin.doctor.controller;

import com.sachin.doctor.entity.Doctor;
import com.sachin.doctor.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "*")  // enable frontend calls
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    // GET all doctors
    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // POST - Add a new doctor
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // GET - Find by ID
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorRepository.findById(id).orElse(null);
    }

    // DELETE a doctor
    @DeleteMapping("/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorRepository.deleteById(id);
        return "Doctor with ID " + id + " has been deleted";
    }
}
