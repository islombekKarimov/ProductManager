package com.product.test;

import com.product.entity.Product;
import com.product.entity.User;
import com.product.repository.UserRepository;
import com.product.service.user.UserService;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;


/**
 * Created by Islombek Karimov on 27.05.2020.
 */
public class Demo {


    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
//        Query query=session.createQuery("from Product", Product.class);
//        List list=query.list();
//        for (Iterator iterator = list.iterator(); iterator.hasNext();){
//            Product product = (Product) iterator.next();
//            System.out.println("=============== " + product.getName());
//        }

//        Query query = session.createQuery(" UPDATE User u SET u.name=:name, u.password=:password where u.id=:id");
//        query.setParameter("name", "Admin");
//        query.setParameter("password", "321");
//        query.setParameter("id", 6);
//        int res = query.executeUpdate();
//        System.out.println("===================== " + res);
//        session.getTransaction().commit();


        Criteria criteria = session.createCriteria(Product.class);
        Criterion name = Restrictions.ilike("name", "%");
        criteria.add(name);
        List<Product> productList = criteria.list();
        productList.stream().forEach(System.out::println);

//        Query query = session.createQuery(" From Product where userId=:userId", Product.class);
//        query.setParameter("userId", 1);
//        List<Product> productList = query.list();
//        productList.stream().forEach(System.out::println);


    }

}
