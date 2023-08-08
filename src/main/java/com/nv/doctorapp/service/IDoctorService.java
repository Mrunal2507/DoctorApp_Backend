package com.nv.doctorapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nv.doctorapp.entity.Doctor;

@Service
public interface IDoctorService {

	public Doctor addDoctor(Doctor doctor)throws Exception;
	
	public List<Doctor> getAllDoctors();

	public Doctor updateDoctor(int doctorId);
	
	public void removeDoctorById(int doctorId);

	public Doctor getDoctorById(int doctorId);
	
	public List<Doctor> getDoctorByAvailability(String fromDay, String toDay);
	
	public List<Doctor> getDoctorByLocation(String location);
	
	public List<Doctor> getDoctorBySpeciality(String speciality);

	public Doctor updateHospitalByDoctorId(int doctorId, int hospitalId);
	
}
