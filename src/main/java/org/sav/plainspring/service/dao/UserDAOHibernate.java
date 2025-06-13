package org.sav.plainspring.service.dao;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.sav.plainspring.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class UserDAOHibernate implements UserDAO {

	private final SessionFactory sessionFactory;

	public UserDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<User> getAll() {
		List<User> lu = sessionFactory.getCurrentSession().createQuery("from User", User.class).getResultList();
		log.info("List<User>={}", lu);
		return lu;
//		sessionFactory.getCurrentSession().g
	}
}
