package com.mindtree.orchard.Doctor.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.orchard.Doctor.Entity.Doctor;
import com.mindtree.orchard.Doctor.Repository.DoctorRepository;

@Service
public class DoctorServiceImpl {
	
	@Autowired
	private DoctorRepository doctorRepository;

	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return this.doctorRepository.findAll();
	}

	public Doctor getDoctor(int id) {
		// TODO Auto-generated method stub
		return this.doctorRepository.findByDoctId(id);
	}

	public Doctor addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return this.doctorRepository.saveAndFlush(doctor);
	}

	public Doctor updateDoctor(int id, Doctor doct) {
		// TODO Auto-generated method stub
		doct.setDoctId(id);
		return this.doctorRepository.save(doct);
	}

	public void deleteDoctor(int id) {
		// TODO Auto-generated method stub
		this.doctorRepository.deleteById(id);
	}
	
	public Doctor updateTotal(int id,int noOfPat) {
		Doctor doctor = this.getDoctor(id);
		doctor.setTotalPatientAttended(noOfPat);
		return this.doctorRepository.saveAndFlush(doctor);
	}

//	public List<Doctor> getDoctorOfPatient(int patId) {
//		// TODO Auto-generated method stub
//		return this.doctorRepository.findAllByPatientId(patId);
//	}

}
