package dao.impl;

import dao.UserDAO;
import entity.User;
import jakarta.persistence.EntityManager;
import util.XJPA;

public class UserDAOImpl implements UserDAO {

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		EntityManager em = XJPA.getEntityManager();
		try {
			return em.find(User.class, id);
		} finally {
			// TODO: handle finally clause
			em.close();
		}
	}

}
