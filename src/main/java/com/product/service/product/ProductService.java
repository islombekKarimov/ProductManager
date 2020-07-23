package com.product.service.product;

import com.product.dto.ProductDTO;
import com.product.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/** Created by Islombek Karimov on 21.03.2020. */
@Service
public interface ProductService {
  ProductDTO create(ProductDTO dto) ;

  ProductDTO get(Long id);

  ProductDTO update(ProductDTO dto);

  void delete(Long id);

  List<Product> getProductListByUserId(Long userId);
}
