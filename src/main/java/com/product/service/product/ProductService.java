package com.product.service.product;

import com.product.dto.ProductDTO;
import com.product.entity.Product;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/** Created by Islombek Karimov on 21.03.2020. */
@Service
public interface ProductService {
  ProductDTO create(ProductDTO dto) throws EntityNotFoundException;

  ProductDTO get(Integer id) throws EntityNotFoundException;

  ProductDTO update(ProductDTO dto) throws EntityNotFoundException;

  void delete(int id) throws EntityNotFoundException;

  List<Product> getProductListByUserId(int userId);
}
