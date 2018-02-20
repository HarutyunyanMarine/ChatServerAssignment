/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatserverassignment.dao.impl;

import com.chatserverassignment.dao.MessageDao;
import com.chatserverassignment.model.Message;
import com.chatserverassignment.model.User;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Marine Harutyunyan
 */
public class MessageDaoImpl implements MessageDao, Serializable {

    private SessionFactory sessionFactory;

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Message g) {
        final Session session = this.sessionFactory.openSession();
        session.save(g);
    }

    @Override
    public List<Message> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Message g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Message g) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Message> getByConversationId(Long id) {
        final Session session = this.sessionFactory.openSession();
//        Criteria cc = session.createCriteria(Message.class, "message");
//        cc.createAlias("message.conversation", "conv")
//                .add(Restrictions.eq("conv.id", id));

        Criteria c = session.createCriteria(Message.class, "message");
        c.createAlias("message.conversation", "cat");
        c.add(Restrictions.eq("cat.id", id));
        c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        
        c.setProjection(Projections.projectionList()
                .add(Projections.property("text"))
                .add(Projections.property("date")));
        Iterator it = c.list().iterator();
 List<Message> messages = new ArrayList<>();
 Message m;
    while(it.hasNext()) {
      Object[] obj = (Object[])it.next();
      m = new Message();
      m.setText(String.valueOf(obj[0]));
            
                m.setDate((Date)obj[1]);
            
      messages.add(m);
    }
        return messages;
    }

}
