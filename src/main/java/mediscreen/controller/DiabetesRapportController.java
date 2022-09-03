package mediscreen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mediscreen.DTO.Assess;
import mediscreen.proxy.Patient;
import mediscreen.proxy.PatientsHistory;
import mediscreen.service.DiabetesRapportService;
import mediscreen.service.PatientHistoryService;
import mediscreen.service.PatientService;
import mediscreen.service.RiskFactorsService;
import mediscreen.utils.AgeCalculator;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DiabetesRapportController {
	
	@Autowired
	RiskFactorsService riskFactorsService;
	
	@Autowired
	DiabetesRapportService diabetesRapportService;
	
	@Autowired
	PatientHistoryService patientHistoryService;
	
	@Autowired
	PatientService patientService;

	AgeCalculator ageCalculator;
	
	public DiabetesRapportController(PatientHistoryService patientHistoryService, PatientService patientService) {
		this.patientHistoryService = patientHistoryService;
		this.patientService = patientService;
	}
	
	@GetMapping("/assess")
	public Assess getPatientAssess(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
		PatientsHistory patientsHistory = patientHistoryService.getPatientsHistoryByName(firstName, lastName);
		Patient patient = patientService.getPatientByName(firstName, lastName);
		int age = AgeCalculator.calculateAge(patient.getBirthdate());
		String diabetesRapport = diabetesRapportService.diabetesRapport(age, riskFactorsService.getRiskFactorsCount(patientsHistory.getNotes()), patient.getSex());
		
		return new Assess(firstName, lastName, age, diabetesRapport);
	}
	
	@GetMapping("/assess/{id}")
	public Assess getPatientAssess(@PathVariable("id") Long id) {
		PatientsHistory patientsHistory = patientHistoryService.getPatientsHistoryById(id);
		String firstName = patientsHistory.getFirstName();
		String lastName = patientsHistory.getLastName();
		Patient patient = patientService.getPatientByName(firstName, lastName);
		int age = AgeCalculator.calculateAge(patient.getBirthdate());
		String diabetesRapport = diabetesRapportService.diabetesRapport(age, riskFactorsService.getRiskFactorsCount(patientsHistory.getNotes()), patient.getSex());
		
		return new Assess(firstName, lastName, age, diabetesRapport);
	}

}
