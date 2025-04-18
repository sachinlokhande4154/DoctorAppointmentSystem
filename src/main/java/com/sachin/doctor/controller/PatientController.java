package com.sachin.doctor.controller;

import com.sachin.doctor.entity.Patient;
import com.sachin.doctor.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    // GET all patients
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // POST - Register new patient
    @PostMapping
    public Patient registerPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    // GET - Fetch single patient by ID
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id).orElse(null);
    }
}
