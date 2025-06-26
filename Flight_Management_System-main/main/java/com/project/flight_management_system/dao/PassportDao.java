package com.project.flight_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.flight_management_system.dto.Passport;
import com.project.flight_management_system.repo.PassportRepo;

@Repository
public class PassportDao {

	@Autowired
	PassportRepo passportRepo;
	
	
	public Passport savePassport(Passport passport) {
		return passportRepo.save(passport);
	}
	
	public Passport fetchPassportById(int passportId) {
		Optional<Passport> passport=passportRepo.findById(passportId);
		if(passport.isPresent()) {
			return passport.get();
		}else {
			return null;
		}
	}
	
	public Passport deletePassportById(int passportId) {
		Optional<Passport> passport=passportRepo.findById(passportId);
		if(passport.isPresent()) {
			passportRepo.delete(passport.get());
			return passport.get();
		}else {
			return null;
		}
	}
	
	public Passport updatePassportById(int oldPassportId,Passport newPassport) {
		Optional<Passport> passport=passportRepo.findById(oldPassportId);
		if(passport.isPresent()) {
			newPassport.setPassportId(oldPassportId);
			return savePassport(newPassport);
		}else {
			return null;
		}
	}
	
	public List<Passport> fetchAllPassport(){
		return passportRepo.findAll();
	}
}
