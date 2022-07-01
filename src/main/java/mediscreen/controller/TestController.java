package mediscreen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import mediscreen.proxy.Patient;
import mediscreen.proxy.PatientsHistory;
import mediscreen.service.PatientHistoryService;
import mediscreen.service.PatientService;

@RestController
public class TestController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PatientHistoryService patientHistoryService;
	
	@GetMapping("/patients")
	public List<Patient> getAllPatients() {
		List<Patient> findAll = patientService.getAllPatients();
		return findAll;
	}
	
	@GetMapping("/patientHistoryList")
	public List<PatientsHistory> getAllPatientsHistories() {
		List<PatientsHistory> findAll = patientHistoryService.getAllPatientsHistories();
		return findAll;
	}

}
