package mediscreen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mediscreen.proxy.PatientHistoryProxy;
import mediscreen.proxy.PatientsHistory;

@Service
public class PatientHistoryService {
	
	PatientHistoryProxy proxy;
	
	@Autowired
	private PatientHistoryService(PatientHistoryProxy patientHistoryProxy) {
		proxy = patientHistoryProxy;
	}
	
	public List<PatientsHistory> getAllPatientsHistories() {
		return proxy.getAllPatientsHistories();
		
	}
	
	public PatientsHistory getPatientsHistoryByName(String firstName, String lastName) {
		return proxy.getPatientHistoryByName(firstName, lastName);
	}
	
	public PatientsHistory getPatientsHistoryById(Long id) {
		return proxy.getPatientHistoryById(id);
	}

}
