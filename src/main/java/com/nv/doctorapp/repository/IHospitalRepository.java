package com.nv.doctorapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nv.doctorapp.entity.Hospital;

@Repository
public interface IHospitalRepository extends JpaRepository<Hospital, Integer> {

	public List<Hospital> getHospitalByCity(String city);

	public List<Hospital> getHospitalByState(String state);

}
