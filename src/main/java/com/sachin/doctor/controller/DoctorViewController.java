
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sachin.doctor.entity.Appointment;
import com.sachin.doctor.entity.Donor;
import com.sachin.doctor.entity.Patient;
import com.sachin.doctor.repository.DoctorRepository;
import com.sachin.doctor.repository.DonorRepository;

@Controller
public class DoctorViewController {

    @Autowired
    private DoctorRepository doctorRepo;

    @GetMapping("/home")
    public String showHomePage(Model model) {
        model.addAttribute("doctors", doctorRepo.findAll());
        return "home"; // points to templates/home.html
    }
}

@Autowired
private PatientRepository patientRepo;

@GetMapping("/register-patient")
public String showRegisterPage() {
    return "register-patient";
}

@PostMapping("/register-patient")
public String savePatient(@RequestParam String name,
                          @RequestParam String email,
                          @RequestParam String phone) {
    Patient patient = new Patient();
    patient.setName(name);
    patient.setEmail(email);
    patient.setPhone(phone);
    patientRepo.save(patient);
    return "redirect:/home";
}

@GetMapping("/book-appointment")
public String showAppointmentForm(Model model) {
    model.addAttribute("doctors", doctorRepo.findAll());
    model.addAttribute("patients", patientRepo.findAll());
    return "book-appointment";
}

@PostMapping("/book-appointment")
public String processAppointment(@RequestParam Long doctorId,
                                 @RequestParam Long patientId,
                                 @RequestParam String appointmentTime) {

    Doctor doc = doctorRepo.findById(doctorId).orElse(null);
    Patient pat = patientRepo.findById(patientId).orElse(null);

    if (doc == null || pat == null) return "redirect:/home";

    Appointment a = new Appointment();
    a.setDoctor(doc);
    a.setPatient(pat);
    a.setAppointmentTime(LocalDateTime.parse(appointmentTime));
    a.setStatus("Booked");

    appointmentRepo.save(a);

    // Send email
    String msg = "Hi " + pat.getName() + ", your appointment with Dr. " + doc.getName() +
                 " is confirmed for " + appointmentTime;
    emailService.sendEmail(pat.getEmail(), "Appointment Confirmed", msg);

    return "redirect:/home";
}

@Autowired
private DonorRepository donorRepo;

@GetMapping("/search-donor")
public String showSearchDonor(@RequestParam(required = false) String city,
                              @RequestParam(required = false) String group,
                              Model model) {
    if (city != null && group != null) {
        List<Donor> result = donorRepo.findByCityAndBloodGroup(city, group);
        model.addAttribute("donors", result);
    }
    return "search-donor";
}
