package mediscreen.proxy;

import java.util.List;

import feign.RequestLine;

public interface PatientHistoryProxy {

	@RequestLine("GET /allPatientHistory")
	List<PatientsHistory> getAllPatientsHistories();
}
