package com.product.service.product.impl;

import com.product.entity.Product;
import com.product.repository.ProductRepository;
import com.product.service.product.ProductService;
import com.product.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Islombek Karimov on 08.05.2020.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;


    @Override
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) throws EntityNotFoundException {
        productRepository.save(product);
    }

    @Override
    public Product getProductById(int id) throws EntityNotFoundException {
        return productRepository.findById(id).get();
    }

    @Override
    public void delete(int id) throws EntityNotFoundException {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProductListByUserId(int userId) {
        Session session = HibernateUtil.session();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(" From Product where userId=:userId", Product.class);
        query.setParameter("userId", userId);
        return query.list();
    }
}
