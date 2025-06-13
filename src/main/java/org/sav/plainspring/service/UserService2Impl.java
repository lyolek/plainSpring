package org.sav.plainspring.service;

import lombok.extern.slf4j.Slf4j;
import org.sav.plainspring.pojo.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service(value = "userService2")
public class UserService2Impl implements UserService {


	@Override
	public String getName(int id) {
		return "User2 = " + id;
	}

	@Override
	public List<User> getAll() {
		return List.of();
	}
}
