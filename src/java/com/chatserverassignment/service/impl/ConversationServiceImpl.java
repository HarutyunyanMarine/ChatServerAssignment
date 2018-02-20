/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatserverassignment.service.impl;

import com.chatserverassignment.dao.ConversationDao;
import com.chatserverassignment.dao.MessageDao;
import com.chatserverassignment.model.Conversation;
import com.chatserverassignment.model.Message;
import com.chatserverassignment.service.ConversationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


/**
 *
 * @author Marine Harutyunyan
 */
public class ConversationServiceImpl implements ConversationService{

    ConversationDao dao;
    MessageDao messageDao;

    public void setDao(ConversationDao dao) {
        this.dao = dao;
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }
    
    @Override
    public List<Message> getUsersConversationMessages(Long c) {
//        Long c = dao.getUsersConversation(from_id, to_id);
        return messageDao.getByConversationId(c);
    }

    @Override
    public Conversation getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Conversation s) {
        dao.add(s);
    }

    @Override
    public List<Conversation> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Conversation s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Conversation s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long getUsersConversation(Long from_id, Long to_id) {
        return dao.getUsersConversation(from_id, to_id);
    }

    @Override
    public Conversation addNewConversation(Long from_id, Long to_id) {
        return dao.addNewConversation(from_id, to_id);
    }
    
}
