package com.mindtree.orchard.Doctor.Controller;
import java.util.List;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.orchard.Doctor.Entity.Doctor;
import com.mindtree.orchard.Doctor.Service.DoctorServiceImpl;

@RequestMapping("/doctor")
@RestController
public class DoctorController {
	
	@Autowired
	private DoctorServiceImpl impl;
	
	@GetMapping("/all")
	public List<Doctor> getAllDoctors(){
		return this.impl.getAllDoctors();
	}
	
	@GetMapping("/{id}")
	public Doctor getDoctor(@PathVariable("id") int id) {
		return this.impl.getDoctor(id);
	}
	
	@GetMapping("update/{id}/total/{total}")
	public Doctor updateTotal(@PathVariable("id") int id,@PathVariable("total") int total) {
		return this.impl.updateTotal(id, total);
	}
	
//	@GetMapping("/patient/{patId}")
//	public List<Doctor> getDoctorOfPatient(@PathVariable("patId") int patId){
//		return this.impl.getDoctorOfPatient(patId);
//	}
	
	@PostMapping("/add")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return this.impl.addDoctor(doctor);
	}
	
	@PutMapping("/update/{id}")
	public Doctor updateDoctor(@PathVariable("id") int id,@RequestBody Doctor doct) {
		return this.impl.updateDoctor(id,doct);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteDoctor(@PathVariable("id") int id) {
		this.impl.deleteDoctor(id);
	}
}
