/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chatserverassignment.dao.impl;

import com.chatserverassignment.hibernate.HibernateUtil;
import com.chatserverassignment.model.User;
import com.chatserverassignment.dao.UserDao;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

/**
 *
 * @author Marine Harutyunyan
 */
public class UserDaoImpl implements UserDao, Serializable{
    
    private SessionFactory sessionFactory;
    
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    public User getByID(int id) {
        final Session session = this.sessionFactory.openSession();
//    return getHibernateTemplate().get(User.class, id);
    
        final Query query = session.createSQLQuery(
                "SELECT * FROM user WHERE id = :id")
                .addEntity(User.class)
                .setParameter("id", id);
        return (User) query.list().get(0);
    }

    @Override
    public void add(User g) {
        final Session session = this.sessionFactory.openSession();
        session.save(g);
        logger.info("User saved " + g.toString());
    }

    @Override
    public User addWithReturn(User user) {
        final Session session = this.sessionFactory.openSession();
        try {
            final Transaction transaction = session.beginTransaction();
            try {

                session.save(user);
                transaction.commit();

            } catch (Exception ex) {
                // Log the exception here
                transaction.rollback();
                throw ex;
            }
        } finally {
//            HibernateUtil.shutdown();
        }
        return user;
    }

    public List<User> getAll() {
        final Session session = this.sessionFactory.openSession();
        List<User> users;
        try {
            final Transaction transaction = session.beginTransaction();
            try {
                Criteria c = session.createCriteria(User.class);
                users = c.list();
                transaction.commit();

            } catch (Exception ex) {
                // Log the exception here
                transaction.rollback();
                throw ex;
            }
        } finally {
//            HibernateUtil.shutdown();
        }
        return users;

    }

    @Override
    public void update(User g) {
         final Session session = this.sessionFactory.openSession();
        session.update(g);
    }

    @Override
    public void delete(User g) {
        final Session session = this.sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();
        try{
            
        session.delete(g);
        transaction.commit();
        }catch(Exception ex){
            transaction.rollback();
            throw ex;
        }
        
    }

    @Override
    public User login(String name, String password) {
        final Session session = this.sessionFactory.openSession();
        User user = null;
        try {
            final Transaction transaction = session.beginTransaction();
            try {
                Criteria c = session.createCriteria(User.class)
                        .add(Restrictions.eq("username", name))
                        .add(Restrictions.eq("password", password));
                user = (User)c.list().get(0);
                transaction.commit();

            } catch (Exception ex) {
                // Log the exception here
                transaction.rollback();
                throw ex;
            }
        } finally {
//            HibernateUtil.shutdown();
        }
//        List<User> u = (List<User>)query.list();
        return user;
    }

    @Override
    public List<User> getRegularUsers() {
        final Session session = this.sessionFactory.openSession();
        List<User> users;
        try {
            final Transaction transaction = session.beginTransaction();
            try {
                Criteria c = session.createCriteria(User.class)
                        .add(Restrictions.eq("type", "regular"));
                users = c.list();
                transaction.commit();

            } catch (Exception ex) {
                // Log the exception here
                transaction.rollback();
                throw ex;
            }
        } finally {
//            HibernateUtil.shutdown();
        }
        return users;
    }
    
}
