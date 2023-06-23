package org.shoping_kart.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.shoping_kart.dto.Product;
import org.shoping_kart.dto.User;

public class ProductDao {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

	public Product saveProduct(Product product, int user_id) {

		User u = manager.find(User.class, user_id);
		if (u != null) {
			u.getProducts().add(product);
			product.setUser(u);
			manager.persist(product);
			manager.getTransaction().begin();
			manager.getTransaction().commit();

			return product;
		} else {
			return null;
		}
	}

	public Product updateProduct(Product product, int user_id) {
		User u = manager.find(User.class, user_id);
		if (u != null) {
			u.getProducts().add(product);
			product.setUser(u);
			manager.merge(product);
			manager.getTransaction().begin();
			manager.getTransaction().commit();

			return product;

		} else {
			return null;
		}
	}

	public Product findProductById(int pid) {
		Product product = manager.find(Product.class, pid);
		return product;
	}

	public boolean deleteProduct(int pid) {
		Product p = findProductById(pid);
		if (p != null) {
			manager.remove(p);
			manager.getTransaction().begin();
			manager.getTransaction().commit();

			return true;
		} else {
			return false;
		}
	}

	public List<Product> findProductByUserId(int user_id) {

		Query q = manager.createQuery("select u.products from User u where u.id=?1");
		q.setParameter(1, user_id);

		return q.getResultList();
	}
}
