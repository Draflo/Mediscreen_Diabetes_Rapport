package mediscreen.proxy;

import java.util.List;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface PatientProxy {
	
	@RequestLine("GET /patient?firstName={firstName}&lastName={lastName}")
	@Headers("Content-Type: application/json")
	Patient getPatientByName(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
	@RequestLine("GET /patients")
	List<Patient> getAllPatients();

}
