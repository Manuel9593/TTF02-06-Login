package portale.backend;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String login;
	@ToString.Exclude private String password;
	private String name;
	private String surname;
	
	public String getFullName() {
		return getName() + " " + getSurname();
	}

}
