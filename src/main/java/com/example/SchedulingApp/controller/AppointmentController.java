package com.example.SchedulingApp.controller;

import com.example.SchedulingApp.model.Appointment;
import com.example.SchedulingApp.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping("/schedule")
    public ResponseEntity<String> scheduleAppointment(@RequestBody Appointment appointment) {
        appointment.setAppointmentTime(LocalDateTime.parse(appointment.getAppointmentTime().toString()));
        appointmentRepository.save(appointment);
        return ResponseEntity.ok("Appointment scheduled successfully.");
    }
}
