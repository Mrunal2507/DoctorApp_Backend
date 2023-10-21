package com.nv.doctorapp.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nv.doctorapp.entity.Auth;
import com.nv.doctorapp.entity.Role;
import com.nv.doctorapp.repository.AuthRepository;
import com.nv.doctorapp.repository.RoleRepository;

@Service
public class AuthService {
    @Autowired
    private AuthRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    
    public void initRoleAndUser() {

    	Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepository.save(userRole);
        
        Role doctorRole = new Role();
        doctorRole.setRoleName("Doctor");
        doctorRole.setRoleDescription("Doctor Role");
        roleRepository.save(doctorRole);

        Auth adminUser = new Auth();
        adminUser.setEmailId("admin@gmail.com");
        adminUser.setUserPassword("Admin@1234");
        adminUser.setUserName("Admin");
        adminUser.setMobileNo("7544366332");
        adminUser.setActive(true);
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminRoles.add(userRole);
        adminUser.setRole(adminRoles);
        userRepository.save(adminUser);
    }

    public Auth registerNewUser(Auth user) {
        Role role = roleRepository.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setActive(true);
        user.setRole(userRoles);
        Auth auth= userRepository.save(user);
        auth.setUserPassword(null);
        return auth;
    }
    
    public Auth registerNewDoctor(Auth doctor) {
        Role role = roleRepository.findById("Doctor").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        doctor.setActive(true);
        doctor.setRole(userRoles);
        Auth auth= userRepository.save(doctor);
        auth.setUserPassword(null);
        return auth;
    }

    public Auth authenticateuser(Auth auth){
        if(userRepository.existsById(auth.getEmailId())){
            Auth existauth=userRepository.findById(auth.getEmailId()).get();
            if(existauth.isActive() && existauth.getUserPassword().equals(auth.getUserPassword())){
                existauth.setUserPassword(null);
                return existauth;
            }else return null;
        }
        else return null;
    }
    
    public Optional<Auth> getUserByEmailId(String emailId) {
        Optional<Auth> authOptional = userRepository.findById(emailId);
        if (authOptional.isPresent()) {
            return authOptional;
        }
		return authOptional;
    }
    
    public List<Auth> getAllUsers(){
    	return userRepository.findAll();
    }
    
    public void deactivateUser(String emailId) {
        Auth auth = userRepository.findById(emailId).get();
        if (auth != null) {
            auth.setActive(false);
            userRepository.save(auth);
        }
    }
    
    public void activateUser(String emailId) {
        Auth auth = userRepository.findById(emailId).get();
        if (auth != null) {
            auth.setActive(true);
            userRepository.save(auth);
        }
    }
    
    public boolean getUserStatusByEmail(String emailId) {
        Optional<Auth> authOptional = userRepository.findById(emailId);
        if (authOptional.isPresent()) {
            Auth auth = authOptional.get();
            return auth.isActive();
        } else {
            return false;
        }
    }
    
    public Auth updateAuthByEmail(String emailId, Auth updatedAuth) {
        Optional<Auth> existingAuthOptional = userRepository.findById(emailId);
        if (existingAuthOptional.isEmpty()) {
            return null;
        }

        Auth existingAuth = existingAuthOptional.get();
        BeanUtils.copyProperties(updatedAuth, existingAuth, "emailId");
        return userRepository.save(existingAuth);
    }
}
