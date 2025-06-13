package org.sav.plainspring.service.dao;

import lombok.extern.slf4j.Slf4j;
import org.sav.plainspring.pojo.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Slf4j
//@Repository
//@Transactional
public class UserDAOJpa implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	public User findById(int id) {
		return em.find(User.class, id);
	}

	@Override
	public List<User> getAll() {
		List<User> lu = em.createQuery("FROM User", User.class).getResultList();
		log.info("List<User>={}", lu);
		return lu;
	}
}
