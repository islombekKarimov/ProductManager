package com.product.service.product.impl;

import com.product.converter.ProductConverter;
import com.product.dto.ProductDTO;
import com.product.entity.Product;
import com.product.repository.ProductRepository;
import com.product.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

/**
 * Created by Islombek Karimov on 08.05.2020.
 */
@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ProductDTO create(ProductDTO dto) {
        Product entity = ProductConverter.toEntity(dto);
        return ProductConverter.toDTO(entity);
    }

    @Override
    public ProductDTO get(Long id) {
        Optional<Product> optional = findById(id);
        if (optional.isPresent()) {
            return ProductConverter.toDTO(optional.get());

        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public ProductDTO update(ProductDTO dto) {
        Optional<Product> optional = findById(dto.getId());
        if (optional.isPresent()) {
            Product entity = ProductConverter.toEntity(dto);
            return ProductConverter.toDTO(productRepository.save(entity));
        } else {
            throw new EntityNotFoundException();
        }
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> getProductListByUserId(Pageable pageable, Long userId) {
        return null;
    }

    private Optional<Product> findById(Long id) {
        return productRepository.findById(id);
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
