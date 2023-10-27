package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dao.UserDao;
import com.ssafy.board.model.dto.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getUserList() {
		return userDao.selectAll();
	}

	@Override
	public void signup(User user) {
		User newUser = userDao.selectOne(user.getId());
		if (newUser == null) userDao.insertUser(user);
	}

	@Override
	public User login(User user) {
		User loginUser = userDao.selectOne(user.getId());
		if (loginUser != null && loginUser.getPassword().equals(user.getPassword())){
			return loginUser;
		}
		
		return null;
	}

}
