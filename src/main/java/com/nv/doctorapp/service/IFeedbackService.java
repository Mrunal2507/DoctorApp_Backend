package com.nv.doctorapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nv.doctorapp.entity.Feedback;

@Service
public interface IFeedbackService {

	public Feedback addFeedback(Feedback feedback) throws Exception;

	public List<Feedback> listOfAllFeedbacks();

	// public List<Feedback> getFeedbackByPatientId(int patientId)throws NullPointerException;

	public List<Feedback> getFeedbackByDoctorName(String doctorName);

	// public Feedback updateFeedbackByPatientId(int feedbackId, int PatientId); 

	public Feedback getFeedbackId(int feedbackId);

	// public Feedback updateFeedback(int feedbackId);

	// public void removePatientDetailsByfeedbackComment(String feedbackComment);
}
