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

public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;

	private String doctorName;
	// private int patientId;
	private String feedbackComment;
	private int rating;

	public Feedback(String doctorName, String feedbackComment, int rating) {
		super();
		this.doctorName = doctorName;
		// this.patientId = patientId;
		this.feedbackComment = feedbackComment;
		this.rating = rating;
	}

}
