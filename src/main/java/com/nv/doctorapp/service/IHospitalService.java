package com.nv.doctorapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nv.doctorapp.entity.Hospital;

@Service
public interface IHospitalService {

	public Hospital addHospital(Hospital hospital) throws Exception;

	public Hospital updateHospitalById(int hospitalId);

	public Hospital getHospitalById(int hospitalRating);

	public void deleteHospitalById(int hospitalId);

	public List<Hospital> getallHospital();

	public List<Hospital> getHospitalByCity(String city);

	public List<Hospital> getHospitalByState(String state);

}
