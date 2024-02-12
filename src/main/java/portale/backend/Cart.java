package portale.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
	private Map<Product, Integer> products = new HashMap<>();
	
	public List<Product> getProducts() {
		List<Product> res = new ArrayList<>();
		products.keySet().forEach(p->res.add(p));
		return res;
	}
	
	public int getQuantity(Product p) {
		Integer res = products.get(p);
		return res==null?0:res;
	}
	
	public void add(Product p, int quantity) {
		products.put(p, quantity + getQuantity(p));
	}
	
	public void remove(Product p) {
		products.remove(p);
	}
	
	public int getTotal() {
		int total = 0;
		for(Product p : getProducts()) {
			total += getQuantity(p)*p.getPrice();
		}
		return total;
	}
}
