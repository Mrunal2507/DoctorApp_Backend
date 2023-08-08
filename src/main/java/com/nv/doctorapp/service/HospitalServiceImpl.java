package com.nv.doctorapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.doctorapp.entity.Hospital;
import com.nv.doctorapp.exception.InvalidInputException;
import com.nv.doctorapp.repository.IHospitalRepository;

@Service
public class HospitalServiceImpl implements IHospitalService {

	@Autowired
	IHospitalRepository ihospitalRepository;

	@Override
	public Hospital addHospital(Hospital hospital) throws Exception {

		if (hospital.getHospitalName().equals("")) {

			throw new InvalidInputException("Name cannot be null");
		}

		if (hospital.getCity().equals("")) {

			throw new InvalidInputException("Invalid City");
		}

		return ihospitalRepository.save(hospital);
	}

	@Override
	public List<Hospital> getallHospital() {

		return ihospitalRepository.findAll();
	}

	@Override
	public void deleteHospitalById(int hospitalId) {

		if (hospitalId == 0) {
			throw new NullPointerException("Invalid Id");
		}

		else
			ihospitalRepository.deleteById(hospitalId);
	}

	@Override
	public Hospital updateHospitalById(int hospitalId) {

		if (hospitalId == 0) {
			throw new NullPointerException("Invalid Id");
		}

		Hospital updatedHospital = ihospitalRepository.getReferenceById(hospitalId);
		ihospitalRepository.save(updatedHospital);
		return updatedHospital;
	}

	@Override
	public Hospital getHospitalById(int hospitalRating) {
		Hospital savedHospital = ihospitalRepository.getReferenceById(hospitalRating);
		return savedHospital;
	}

	@Override
	public List<Hospital> getHospitalByState(String state) {

		return ihospitalRepository.getHospitalByState(state);
	}

	@Override
	public List<Hospital> getHospitalByCity(String city) {

		return ihospitalRepository.getHospitalByCity(city);
	}
}
