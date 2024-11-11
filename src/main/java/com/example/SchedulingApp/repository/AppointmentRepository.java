package com.example.SchedulingApp.repository;

import com.example.SchedulingApp.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
