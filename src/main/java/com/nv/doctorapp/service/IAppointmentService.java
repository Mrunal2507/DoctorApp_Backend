package com.nv.doctorapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nv.doctorapp.entity.Appointment;

@Service
public interface IAppointmentService {

	public List<Appointment> getAllAppointments();

	public Appointment getAppointmentById(int appointmentId);

	public Appointment addAppointment(Appointment appointment);

	public void removeAppointmentById(int appointmentId);

	public Appointment updateAppointmentById(int appointmentId);

	public List<Appointment> getAppointmentByStatus(String status);

	public List<Appointment> getAppointmentByDate(String date);

}
