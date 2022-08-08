package mediscreen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mediscreen.constants.Constants;
import mediscreen.proxy.Notes;

@Service
public class RiskFactorsService {
	
	public int getRiskFactorsCount(List<Notes> patientNotes) {
		int count = 0;
		for(Notes note : patientNotes) {
			String text = note.getNote().toLowerCase();
			count += Constants.riskFactors.stream().filter(riskFactors -> text.contains(riskFactors.toLowerCase())).count();
		}
		
		return count;
	}

}
