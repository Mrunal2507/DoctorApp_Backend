package com.nv.doctorapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "appointmentId")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int appointmentId;
	private String date;
	private String status;
	private String remark;

	/*@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctorId")
	private Doctor doctor;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientId")
	private Patient patient;*/

	public Appointment(int appointmentId, String date, String status, String remark) {
		super();
		this.appointmentId = appointmentId;
		this.date = date;
		this.status = status;
		this.remark = remark;
	}

}
