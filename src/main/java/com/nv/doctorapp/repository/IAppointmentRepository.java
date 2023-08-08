package com.nv.doctorapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nv.doctorapp.entity.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {

	public List<Appointment> getAppointmentByDate(String date);

	public List<Appointment> getAppointmentByStatus(String status);

}
