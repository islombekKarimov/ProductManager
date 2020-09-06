package com.product.service.product;

import com.product.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by Islombek Karimov on 21.03.2020.
 */
public interface ProductService {
    ProductDTO create(ProductDTO dto);

    ProductDTO get(Long id);

    ProductDTO update(ProductDTO dto);

    void delete(Long id);

    Page<ProductDTO> findAll(Pageable pageable);
}
