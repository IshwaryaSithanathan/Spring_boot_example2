package com.userpage.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.userpage.entity.User;
@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public void addUser(User User) {
		entityManager.persist(User);
	}
	@Override
	public boolean userExists(String name) {
		String hql = "FROM User as user WHERE user.name = ? ";
		int count = entityManager.createQuery(hql).setParameter(1, name).getResultList().size();
		return count > 0 ? true : false;
	}
}
