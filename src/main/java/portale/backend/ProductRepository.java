package portale.backend;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class ProductRepository {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("portale");
	private static ProductRepository instance = null;
	public static ProductRepository getInstance() {
		if(instance == null) {
			instance = new ProductRepository();
		}
		return instance;
	}

	private static Product toProduct(String name, int price) {
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		return product;
	}
	
	public Product get(int id) throws HibernateException {
		EntityManager em = emf.createEntityManager();
		Product p = em.find(Product.class, id);
		log.info(em.toString());
		em.close();
		return p;
	}
	
	public List<Product> getProducts() throws HibernateException {
		EntityManager em = emf.createEntityManager();
		List<Product> res = em.createQuery("select p from Product p", Product.class).getResultList();
		em.close();
		return res;
	}
	
	public Product add(String name, int price) throws HibernateException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Product p = toProduct(name, price);
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		return p;
	}
	
	public void update(Product p) throws HibernateException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Product product = em.find(Product.class, p.getId());
		product.setName(p.getName());
		product.setPrice(p.getPrice());
		em.flush();
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Product p) throws HibernateException {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		em.close();
	}
}
