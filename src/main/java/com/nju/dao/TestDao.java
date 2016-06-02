package com.nju.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 传旺 on 2016/6/2.
 */
public class TestDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void test(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createSQLQuery("SELECT * FROM student");
        query.list();
    }
}
