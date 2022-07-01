package mediscreen.proxy;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
	
	private long id;
	private String firstName;
	private String lastName;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	private LocalDate birthdate;
	
	private String sex;
	private String phone;
	private String address;
	private String city;

	//Setter for curl request
	
	public void setFamily(String family) {
			lastName = family;
	}
		
	public void setGiven(String given) {
			firstName = given;
	}
		
	public void setDob(LocalDate dob) {
			birthdate = dob;
	}
	

}
