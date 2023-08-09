package com.nv.doctorapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nv.doctorapp.entity.Auth;

@Repository
public interface AuthRepository extends JpaRepository<Auth, String>{

	Auth save(Optional<Auth> existingAuth);

}
