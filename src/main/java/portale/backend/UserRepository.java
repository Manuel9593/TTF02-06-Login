package portale.backend;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
	private Map<String, User> users = new HashMap<>();
	private static UserRepository instance = null;
	
	private UserRepository() {
		// Empty
	}
	
	public static UserRepository getInstance() {
		if(instance == null) {
			instance = new UserRepository();
			instance.add(new User("test", "password", "Mario", "Rossi"));
			instance.add(new User("admin", "admin", "Dario", "Bronzo"));
		}
		return instance;
	}
	
	public void add(User u) {
		users.put(u.getLogin(), u);
	}
	
	public User get(String login) {
		return users.get(login);
	}
	
	public User get(String login, String password) {
		User u = users.get(login);
		if (u != null)
			if(u.getPassword().equals(password))
				return u;
		return null;
	}
	
	public void remove(String login) {
		users.remove(login);
	}
}
