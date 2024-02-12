package portale.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserRepository {
	private Map<String, User> users = new HashMap<>();
	private static UserRepository instance = null;
	private Connection con = null;
	
	private UserRepository() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "");
	}
	
	public static UserRepository getInstance() {
		if (instance == null) {
			try {
				instance = new UserRepository();
			} catch (SQLException e) {
				log.error("Errore di connessione al DB");
			}
		}
		return instance;
	}
	
	public void add(User u) {
		users.put(u.getLogin(), u);
	}
	
	public User get(String login) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from users where login = ?");
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			if(!rs.next())
				return null;
			return new User(login, rs.getString("password"), rs.getString("nome"), rs.getString("cognome"));
		} catch(SQLException sql) {
			log.error("Errore all'esecuzione della query");
		}
		return users.get(login);
	}
	
	public User get(String login, String password) {
		User u = users.get(login);
		if (u != null)
			if(u.getPassword().equals(password))
				return u;
		return null;
	}
	
	public List<User> getAll(){
		ArrayList<User> list = new ArrayList<>();
		users.forEach((key, user) -> list.add(user));
		return list;
	}
	public void remove(String login) {
		users.remove(login);
	}
}
