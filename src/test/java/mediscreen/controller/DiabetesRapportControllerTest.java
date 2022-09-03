package mediscreen.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import mediscreen.proxy.Notes;
import mediscreen.proxy.Patient;
import mediscreen.proxy.PatientsHistory;
import mediscreen.service.DiabetesRapportService;
import mediscreen.service.PatientHistoryService;
import mediscreen.service.PatientService;
import mediscreen.service.RiskFactorsService;
import mediscreen.utils.AgeCalculator;

@WebMvcTest(controllers = DiabetesRapportController.class)
class DiabetesRapportControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	RiskFactorsService riskFactorsService;
	
	@MockBean
	DiabetesRapportService diabetesRapportService;
	
	@MockBean
	PatientHistoryService patientHistoryService;
	
	@MockBean
	PatientService patientService;

	AgeCalculator ageCalculator;
	
	private static Notes testNotes;
	private static List<Notes> testListNotes;
	private static PatientsHistory patientsHistory;
	private static Patient patient;
	private static String diabetesRapport = "None";

	@BeforeAll
	public static void setUpPatientInfo() {
		LocalDate creationDate = LocalDate.of(2022, 8, 15);
		String notes = "Test Notes";
		
		testNotes = new Notes(creationDate, notes);
		
		testListNotes = new ArrayList<>();
		testListNotes.add(testNotes);
		
		patientsHistory = new PatientsHistory(0L, "Test", "TestNone", testListNotes);
		
		LocalDate birtDate = LocalDate.of(1994, 5, 29);
		String firstName = "Jean";
		String lastName = "Michel";
		String phone = "0606060606";
		String sex = "M";
		String address = "666 Place de l'église";
		String city = "Hell";
		
		patient = new Patient(0, firstName, lastName, birtDate, sex, phone, address, city);
		
	}
	
	@Test
	final void testGetPatientAssessShouldReturnPatientAssess() throws Exception {
		when(patientHistoryService.getPatientsHistoryByName(Mockito.anyString(), Mockito.anyString())).thenReturn(patientsHistory);
		when(patientService.getPatientByName(Mockito.anyString(), Mockito.anyString())).thenReturn(patient);
		when(diabetesRapportService.diabetesRapport(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString())).thenReturn(diabetesRapport);
		mockMvc.perform(get("/assess").param("firstName", "Test").param("lastName", "TestNone")).andExpect(status().isOk());
	}

	@Test
	final void testGetPatientAssessLongShouldReturnPatientAssess() throws Exception {
		when(patientHistoryService.getPatientsHistoryById(Mockito.anyLong())).thenReturn(patientsHistory);
		when(patientService.getPatientByName(Mockito.anyString(), Mockito.anyString())).thenReturn(patient);
		when(diabetesRapportService.diabetesRapport(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString())).thenReturn(diabetesRapport);
		mockMvc.perform(get("/assess/{id}", 0L)).andExpect(status().isOk());
	}

}
