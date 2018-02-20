/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatserverassignment.dao.impl;

import com.chatserverassignment.dao.ConversationDao;
import com.chatserverassignment.dao.MessageDao;
import com.chatserverassignment.model.Conversation;
import com.chatserverassignment.model.Message;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Marine Harutyunyan
 */
public class ConversationDaoImpl implements ConversationDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;
//    private MessageDao messageDao;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    public void setMessageDao(MessageDao messageDao) {
//        this.messageDao = messageDao;
//    }
    @Override
    public Long getUsersConversation(Long u1Id, Long u2Id) {
        Session session = sessionFactory.openSession();
        Criteria c = session.createCriteria(Conversation.class, "conversation");
        c.createAlias("conversation.user1", "user1");
        c.add(Restrictions.eq("user1.id", u1Id));
        
        c.createAlias("conversation.user2", "user2");
        c.add(Restrictions.eq("user2.id", u2Id));
        c.setProjection(Projections.property("id"));

        
//        c.createAlias("conversation.messages", "message");
//        c.add(Restrictions.eq("message.conv_id", "conversation.id"));
        
        
        
        return (Long) c.list().get(0);
    }

    @Override
    public void add(Conversation g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Conversation> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conversation getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Conversation g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Conversation g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Conversation addNewConversation(Long from_id, Long to_id) {
        Session session = sessionFactory.openSession();
        return (Conversation)session.createSQLQuery("INSERT INTO conversation(user_1_id, user_2_id) VALUES (:u1, :u2)")
                .addEntity(Conversation.class)
                .setParameter("u1", from_id)
                .setParameter("u2", to_id).list().get(0);
    }

}
