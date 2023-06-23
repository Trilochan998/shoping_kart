package org.shoping_kart.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.shoping_kart.dto.User;

public class UserDao {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();

	public User saveUser(User user) {
		manager.persist(user);
		manager.getTransaction().begin();
		manager.getTransaction().commit();

		return user;
	}

	public User updataUser(User user) {
		manager.merge(user);
		manager.getTransaction().begin();
		manager.getTransaction().commit();

		return user;
	}

	public User verifyUser(long phone, String password) {
		Query q = manager.createQuery("from User u where u.phone=?1 and u.password=?2");
		q.setParameter(1, phone);
		q.setParameter(2, password);
		try {
			return (User) q.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

	public User findById(int id) {
		return manager.find(User.class, id);
	}

	public boolean deleteUser(int id) {
		User u = findById(id);
		if (u != null) {
			 manager.remove(u);
			manager.getTransaction().begin();
			manager.getTransaction().commit();
			return true;
		}
		return false;
	}
}
