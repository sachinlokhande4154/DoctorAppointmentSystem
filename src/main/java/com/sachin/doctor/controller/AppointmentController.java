package com.sachin.doctor.controller;

import com.sachin.doctor.entity.Appointment;
import com.sachin.doctor.entity.Doctor;
import com.sachin.doctor.entity.Patient;
import com.sachin.doctor.repository.AppointmentRepository;
import com.sachin.doctor.repository.DoctorRepository;
import com.sachin.doctor.repository.PatientRepository;
import com.sachin.doctor.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private EmailService emailService;

    @PostMapping
    public String bookAppointment(@RequestParam Long doctorId,
                                   @RequestParam Long patientId,
                                   @RequestParam String time) {
        Doctor doctor = doctorRepo.findById(doctorId).orElse(null);
        Patient patient = patientRepo.findById(patientId).orElse(null);

        if (doctor == null || patient == null) return "Doctor or patient not found!";

        Appointment appt = new Appointment();
        appt.setDoctor(doctor);
        appt.setPatient(patient);
        appt.setAppointmentTime(LocalDateTime.parse(time));
        appt.setStatus("Booked");

        appointmentRepo.save(appt);

        // Send email
        String msg = "Hi " + patient.getName() + ",\n\nYour appointment with Dr. " + doctor.getName() + " has been booked for " + time;
        emailService.sendEmail(patient.getEmail(), "Appointment Confirmation", msg);

        return "✅ Appointment booked & email sent!";
    }

    @GetMapping
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }
}
