package com.nv.doctorapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.doctorapp.entity.Feedback;
import com.nv.doctorapp.exception.InvalidDataException;
import com.nv.doctorapp.repository.IFeedbackRepository;
import com.nv.doctorapp.repository.IPatientRepository;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

	@Autowired
	IFeedbackRepository feedbackRepository;

	@Autowired
	IPatientRepository patientRepository;

	@Override
	public Feedback addFeedback(Feedback feedback) throws Exception {

		if (feedback.getDoctorName().equals("")) {
			throw new InvalidDataException("Doctor Name cannot be null");
		} else
			return feedbackRepository.save(feedback);
	}

	@Override
	public List<Feedback> listOfAllFeedbacks() {

		return feedbackRepository.findAll();
	}

	@Override
	public List<Feedback> getFeedbackByDoctorName(String doctorName) {

		return feedbackRepository.getFeedbackByDoctorName(doctorName);
	}

	@Override
	public Feedback getFeedbackId(int feedbackId) {

		if (feedbackId >= 1) {
			feedbackRepository.getReferenceById(feedbackId);
		}

		return null;
	}

}
