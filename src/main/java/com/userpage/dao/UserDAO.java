package com.userpage.dao;

import com.userpage.entity.User;
public interface UserDAO {
    void addUser(User User);
    boolean userExists(String name);
}
 