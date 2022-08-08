package mediscreen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mediscreen.proxy.Patient;
import mediscreen.proxy.PatientProxy;

@Service
public class PatientService {
	
	PatientProxy proxy;
	
	@Autowired
	public PatientService(PatientProxy patientProxy) {
		proxy = patientProxy;
	}

	public List<Patient> getAllPatients() {
		return proxy.getAllPatients();
	}
	
	public Patient getPatientByName(String firstName, String lastName) {
		return proxy.getPatientByName(firstName, lastName);
	}
}
