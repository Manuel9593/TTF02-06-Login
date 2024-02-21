package portale.backend;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.ToString;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
public class User {
	@Id
	private String login;
	@ToString.Exclude private String password;
	private String name;
	private String surname;
	@Column(nullable=false, columnDefinition="BIT(1)")
	private boolean admin;
	
	public String getFullName() {
		return getName() + " " + getSurname();
	}

}
