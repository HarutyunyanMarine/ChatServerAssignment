/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatserverassignment.service.impl;

import com.chatserverassignment.model.User;
import com.chatserverassignment.dao.UserDao;
import com.chatserverassignment.service.UserService;
import java.util.List;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author Marine Harutyunyan
 */
@SessionScoped
public class UserServiceImpl implements UserService{
//    @Autowired
//    @Qualifier("userDaoImpl")
    private UserDao userDao;
    
    public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
    @Override
    public List<User> getRegularUsers() {
        return userDao.getRegularUsers();
    }

    @Override
    public User login(String name, String password) {
        return userDao.login(name, password);
    }

    @Override
    public User addWithReturn(User user) {
        return userDao.addWithReturn(user);
    }

    @Override
    public User getByID(int id) {
        return userDao.getByID(id);
    }

    @Override
    public void add(User s) {
        userDao.add(s);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void update(User s) {
        userDao.update(s);
    }

    @Override
    public void delete(User s) {
        userDao.delete(s);
    }
    
}
