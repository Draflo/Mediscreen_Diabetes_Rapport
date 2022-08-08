package mediscreen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import mediscreen.proxy.PatientHistoryProxy;
import mediscreen.proxy.PatientProxy;

@Configuration
public class MediscreenDiabetesRapportModule {
	
	@Bean
	public PatientProxy getPatientProxy() {
		return Feign.builder().decoder(new JacksonDecoder()).target(PatientProxy.class, "http://localhost:8081");
	}
	
	@Bean
	public PatientHistoryProxy getPatientHistoryProxy() {
		return Feign.builder().decoder(new JacksonDecoder()).target(PatientHistoryProxy.class, "http://localhost:8082");
	}

}
