package org.sav.plainspring.service;

import lombok.extern.slf4j.Slf4j;
import org.sav.plainspring.pojo.User;
import org.sav.plainspring.service.dao.UserDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service(value = "userService")
@Transactional
public class UserServiceImpl implements UserService {

	UserDAO userDAO;

	public UserServiceImpl(UserDAO userDAOHibernate){
		this.userDAO = userDAOHibernate;
	}

	@Override
	public String getName(int id) {
		return "User = " + id;
	}

	@Override
	public List<User> getAll() {
		return userDAO.getAll();
	}
}
