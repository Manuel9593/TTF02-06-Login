package portale.backend;

import java.util.List;
import java.lang.Exception;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserRepository {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("portale");
	private static UserRepository instance = null;
	
	public static UserRepository getInstance() {
		if (instance == null) {
			instance = new UserRepository();
		}
		return instance;
	}
	
	public User get(String login) throws Exception {
		EntityManager em = emf.createEntityManager();
		User u = em.find(User.class, login);
		em.close();
		return u;

	}
	
	public User get(String login, String password) throws Exception {
		EntityManager em = emf.createEntityManager();
		User u = em.find(User.class, login);
		if (u != null)
			if(u.getPassword().equals(password))
				return u;
		em.close();
		return null;
	}
	
	public List<User> getAll() throws Exception {
		EntityManager em = emf.createEntityManager();
		List<User> res = em.createQuery("select u from User u", User.class).getResultList();
		em.close();
		return res;
	}
	
	public User add(User u) throws Exception {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		em.close();
		return u;
	}
	
	public void update(User u) throws Exception {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		User user = em.find(User.class, u.getLogin());
		user.setLogin(u.getLogin());
		user.setPassword(u.getPassword());
		user.setName(u.getName());
		user.setSurname(u.getSurname());
		user.setAdmin(u.isAdmin());
		em.flush();
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(User u) throws Exception {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		em.close();
	}
}
