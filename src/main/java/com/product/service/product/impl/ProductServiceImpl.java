package com.product.service.product.impl;

import com.product.dto.ProductDTO;
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

/** Created by Islombek Karimov on 08.05.2020. */
@Service
public class ProductServiceImpl implements ProductService {
  private ProductRepository productRepository;

  @Autowired
  public void setProductRepository(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }


  @Override
  public ProductDTO create(ProductDTO dto) {
    return null;
  }

  @Override
  public ProductDTO get(Long id) {
    return null;
  }

  @Override
  public ProductDTO update(ProductDTO dto)  {
    return null;
  }

  @Override
  public void delete(Long id) {

  }

  @Override
  public List<Product> getProductListByUserId(Long userId) {
    return null;
  }

//  @Override
//  public List<Product> getProductListByUserId(int userId) {
//    Session session = HibernateUtil.session();
//    Transaction transaction = session.beginTransaction();
//    Query query = session.createQuery(" From Product where userId=:userId", Product.class);
//    query.setParameter("userId", userId);
//    return query.list();
//  }
}
