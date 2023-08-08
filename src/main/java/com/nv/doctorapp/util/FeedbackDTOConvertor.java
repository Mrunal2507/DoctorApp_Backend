package com.nv.doctorapp.util;

import org.springframework.stereotype.Component;

import com.nv.doctorapp.dto.FeedbackResponseDTO;
import com.nv.doctorapp.entity.Feedback;

@Component
public class FeedbackDTOConvertor {

	public FeedbackResponseDTO convertTo(Feedback feedback) {

		return new FeedbackResponseDTO(feedback.getFeedbackId(), feedback.getDoctorName(), feedback.getRating(),
				feedback.getFeedbackComment());

	}
}
