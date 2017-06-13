package com.userpage.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userpage.dao.UserDAO;
import com.userpage.entity.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO UserDAO;
	@Override
	public synchronized boolean addUser(User User){
       if (UserDAO.userExists(User.getName())) {
    	   return false;
       } else {
    	   UserDAO.addUser(User);
    	   return true;
       }
	}
}
