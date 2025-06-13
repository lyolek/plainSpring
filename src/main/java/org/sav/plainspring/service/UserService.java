package org.sav.plainspring.service;

import org.sav.plainspring.pojo.User;

import java.util.List;

public interface UserService {
	public String getName(int id);
	public List<User> getAll();
}
