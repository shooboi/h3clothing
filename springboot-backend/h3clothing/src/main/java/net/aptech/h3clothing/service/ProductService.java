package net.aptech.h3clothing.service;

import net.aptech.h3clothing.dto.ProductDTO;
import net.aptech.h3clothing.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAllByPage(ProductDTO dto, int page);
}
