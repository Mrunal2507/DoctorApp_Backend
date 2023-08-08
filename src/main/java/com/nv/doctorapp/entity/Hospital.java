package com.nv.doctorapp.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hospitalId;

	private String hospitalName;
	private String city;
	private String state;
	private String address;
	private int hospitalRating;
	// private list<doctor>

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "HospitalId")
	private List<Doctor> doctors;

	public Hospital(int hospitalId, String hospitalName, String city, String state, String address,
			int hospitalRating) {
		super();
		this.hospitalId = hospitalId;
		this.hospitalName = hospitalName;
		this.city = city;
		this.state = state;
		this.address = address;
		this.hospitalRating = hospitalRating;
	}

}
