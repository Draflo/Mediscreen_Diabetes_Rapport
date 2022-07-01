package mediscreen.proxy;

import java.util.List;

import feign.RequestLine;

public interface PatientProxy {
	
	@RequestLine("GET /patient")
	Patient getPatient();
	
	@RequestLine("GET /patients")
	List<Patient> getAllPatients();

}
