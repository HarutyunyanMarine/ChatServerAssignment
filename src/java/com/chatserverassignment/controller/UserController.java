/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatserverassignment.controller;

import com.chatserverassignment.model.User;
import com.chatserverassignment.service.UserService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 *
 * @author Marine Harutyunyan
 */
@ManagedBean
@SessionScoped
public class UserController implements Serializable {
    
    private UserService userService;
    
    private User logedUser;
    private User chatUser;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getLogedUser() {
        return logedUser;
    }

    public User getChatUser() {
        return chatUser;
    }

    public String reg(User user) {
        logedUser = userService.addWithReturn(user);
        return "admin";
    }
    public void delete(User user){
        userService.delete(user);
    }
    
    public String update(User user){
        userService.update(user);
        return "update";
    }

    public String login(User user) {
        logedUser = userService.login(user.getUsername(), user.getPassword());
        if (logedUser == null) {
            return "reg";
        }else{
            if("admin".equals(logedUser.getType())){
                return "admin";
            }
        }
        return "user";
    }

    public List<User> allRegulars() {
        return userService.getRegularUsers();
    }
    public List<User> all() {
        return userService.getAll();
    }
    
    public List<User> regularUserList(){
        return userService.getRegularUsers();
    }

    public String startChating(User user) {
        chatUser = user;
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute("userId1", logedUser);
        httpSession.setAttribute("userId2", chatUser);

        return "start_chat";
    }
}
