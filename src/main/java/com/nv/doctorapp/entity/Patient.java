package com.nv.doctorapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	private String patientName;
	private String patientCity;
	private int patientAge;
	private String patientGender;
	private String patientDisease;

	public Patient(int patientId, String patientName, String patientCity, int patientAge, String patientGender,
			String patientDisease) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientCity = patientCity;
		this.patientAge = patientAge;
		this.patientGender = patientGender;
		this.patientDisease = patientDisease;
	}

}
