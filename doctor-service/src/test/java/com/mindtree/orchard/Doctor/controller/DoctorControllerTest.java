package com.mindtree.orchard.Doctor.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.orchard.Doctor.Controller.DoctorController;
import com.mindtree.orchard.Doctor.Entity.Doctor;
import com.mindtree.orchard.Doctor.Service.DoctorService;
import com.mindtree.orchard.Doctor.Service.DoctorServiceImpl;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = { DoctorControllerTest.class })
public class DoctorControllerTest {

	@Mock
	DoctorServiceImpl doctorServiceImpl;

	@InjectMocks
	DoctorController doctorController;

	List<Doctor> doctors;

	@Test
	@Order(1)
	public void getAllDoctors() {
		doctors = new ArrayList<>();
		doctors.add(new Doctor(1, "Deepthi", "female", 23, "dentist", 0));
		doctors.add(new Doctor(2, "Deepthi", "female", 23, "dentist", 0));

		when(doctorServiceImpl.getAllDoctors()).thenReturn(doctors);

		assertEquals(doctors, doctorController.getAllDoctors());
	}

	@Test
	@Order(2)
	public void getDoctor() {

		Doctor doctor = new Doctor(1, "Deepthi", "female", 23, "dentist", 0);

		int id = 1;

		when(doctorServiceImpl.getDoctor(1)).thenReturn(doctor);

		assertEquals(doctor, doctorController.getDoctor(id));
	}

	@Test
	@Order(3)
	public void addCollege() {
		Doctor doctor = new Doctor(3, "random", "female", 23, "eye", 0);

		when(doctorServiceImpl.addDoctor(doctor)).thenReturn(doctor);

		assertEquals(doctor, doctorController.addDoctor(doctor));
	}
	
	@Test
	@Order(4)
	public void updateDoctor() {
		Doctor doctor = new Doctor(3, "bebo", "female", 23, "teeth", 2);
        int id = 3;
		when(doctorServiceImpl.updateDoctor(id,doctor)).thenReturn(doctor);

		assertEquals(doctor, doctorController.updateDoctor(id,doctor));
	}

}
