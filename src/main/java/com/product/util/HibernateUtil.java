package com.product.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Created by Islombek Karimov on 30.05.2020.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;
    public static Session session() {
         sessionFactory = new Configuration().configure().buildSessionFactory();
         session = sessionFactory.openSession();
         Transaction transaction = session.beginTransaction();
         return session;
    }


}
