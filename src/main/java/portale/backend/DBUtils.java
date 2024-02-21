package portale.backend;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class DBUtils {
	static {
		try {
			sf = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			log.error("errore durante la connessione al db", e);
		}
	}
	@Getter
	private static SessionFactory sf;
}
