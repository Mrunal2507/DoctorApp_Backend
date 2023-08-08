package com.nv.doctorapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nv.doctorapp.entity.Feedback;

@Repository
public interface IFeedbackRepository extends JpaRepository<Feedback, Integer> {

	List<Feedback> getFeedbackByDoctorName(String doctorName);

	// public List<Feedback> getFeedbackByPatientId(int patientId);

	// public List<Feedback> getFeedbackByDoctorName(String doctorName);
}
