package portale.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductRepository {
	private Map<Integer, Product> products = new HashMap<>();
	private static ProductRepository instance = null;
	
	public static ProductRepository getInstance() {
		if(instance == null) {
			instance = new ProductRepository();
			instance.add(new Product(0, "scarpe", 50));
			instance.add(new Product(1, "giubbotto", 120));
			instance.add(new Product(2, "PC", 900));
			instance.add(new Product(3, "maglione", 45));
		}
		return instance;
	}
	
	public void add(Product p) {
		products.put(p.getId(), p);
	}
	
	public void remove(Product p) {
		products.remove(p.getId());
	}
	
	public Product get(int id) {
		return products.get(id);
	}
	
	public List<Product> getProducts() {
		List<Product> res = new ArrayList<>();
		products.values().forEach(p->res.add(p));
		return res;
	}
}
