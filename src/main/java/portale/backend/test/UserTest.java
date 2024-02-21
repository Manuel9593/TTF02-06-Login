/**
 * 
 */
package portale.backend.test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.Exception;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import portale.backend.User;
import portale.backend.UserRepository;


class UserTest {

	private UserRepository repo = UserRepository.getInstance();

	@Test
	void cercaAdmin() {
		User admin;
		try {
			admin = repo.get("admin");
			assertNotNull(admin);
			assertEquals("admin", admin.getLogin());
			assertEquals("admin", admin.getPassword());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void aggiungiUtente() {
		User u = new User("test", "test", "test", "test", false);
		try {
			repo.add(u);
			assertSame(u, repo.get("test"));
			repo.remove(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void rimuoviUtente() {
		try {
			repo.remove(repo.get("test"));
			assertNull(repo.get("test"));
			repo.add(new User("test", "password", "Mario", "Rossi", false));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void utenteNonPresente() {
		try {
			assertNull(repo.get("manuel"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("inizio");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("fine");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("inizio il singolo test");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("dopo ogni singolo test");
	}

}
