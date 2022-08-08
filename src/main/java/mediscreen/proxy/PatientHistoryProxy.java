package mediscreen.proxy;

import java.util.List;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface PatientHistoryProxy {

	@RequestLine("GET /allPatientHistory")
	List<PatientsHistory> getAllPatientsHistories();
	
	@RequestLine("GET /patientHistory?firstName={firstName}&lastName={lastName}")
	@Headers("Content-Type: application/json")
	PatientsHistory getPatientHistoryByName(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
	@RequestLine("GET /patientHistory/{id}")
	@Headers("Content-Type: application/json")
	PatientsHistory getPatientHistoryById(@Param("id") Long id);
}
