/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatserverassignment.service.impl;

import com.chatserverassignment.dao.MessageDao;
import com.chatserverassignment.model.Message;
import com.chatserverassignment.service.MessageService;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Marine Harutyunyan
 */
public class MessageServiceImpl implements MessageService, Serializable{
    private MessageDao messageDao;

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }
    
    

    @Override
    public List<Message> getConversationMessages(int conId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Message s) {
        messageDao.add(s);
    }

    @Override
    public List<Message> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Message s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Message s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
