/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatserverassignment.dao;

import com.chatserverassignment.model.User;
import java.util.List;


/**
 *
 * @author Marine Harutyunyan
 */
public interface UserDao extends DaoCreator<User>{
    public User login(String name, String password);
    public User addWithReturn(User user);
    public List<User> getRegularUsers();
}
