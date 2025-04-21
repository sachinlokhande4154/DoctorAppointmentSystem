# 🏥 Doctor's Appointment & Blood Donor Search System

This is a **Java Full Stack Web Application** that allows users to book appointments with doctors and search for **blood donors based on location**. It provides features for patients, doctors, and admins. Built using **Spring Boot, Thymeleaf, Java, and MySQL**, this application is optimized for real-world healthcare use.

---

## 📌 Features

### 👤 Patient/General User:
- Register and login securely
- View list of doctors by specialization
- Book an appointment with available time slots
- View appointment history
- Search blood donors by blood group and city

### 🩺 Doctor:
- Login with verified credentials
- View scheduled appointments
- Update availability and appointment status
- Manage patient interaction

### 🔧 Admin:
- Dashboard to manage doctors, patients, and appointments
- Approve/reject doctor profiles
- Add or remove specializations and locations

---

## 💻 Tech Stack

| Layer         | Technology Used                          |
|---------------|-------------------------------------------|
| Frontend      | HTML, CSS, Bootstrap, Thymeleaf (Spring) |
| Backend       | Java, Spring Boot, Spring MVC             |
| Database      | MySQL                                     |
| Notifications | JavaMail (Email), Twilio API (SMS)        |
| Tools         | Eclipse/STS, MySQL Workbench, GitHub      |

---

## 🗂️ Project Structure

```bash
DoctorAppointmentSystem/
│
├── src/
│   ├── main/
│   │   ├── java/com/appointment/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── repository/
│   │   │   ├── service/
│   │   │   └── DoctorAppointmentApplication.java
│   │   └── resources/
│   │       ├── templates/
│   │       │   ├── index.html
│   │       │   ├── login.html
│   │       │   ├── register.html
│   │       │   ├── dashboard.html
│   │       └── application.properties
│   └── test/
│       └── java/...
├── static/
│   ├── css/
│   └── js/
├── pom.xml
└── README.md
