package mediscreen.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DiabetesRapport {
	
	private String firstName;
	private String lastName;
	private int age;
	private String rapport;

}
