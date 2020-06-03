package com.product.service.product;

import com.product.entity.Product;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * Created by Islombek Karimov on 21.03.2020.
 */

@Service
public interface ProductService {
    List<Product> getProductList();
    void saveProduct(Product product) throws EntityNotFoundException;
    Product getProductById(int id) throws EntityNotFoundException;
    void delete(int id) throws EntityNotFoundException;
    List<Product> getProductListByUserId(int userId);



}
