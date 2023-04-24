package net.aptech.h3clothing.service.serviceImpl;

import net.aptech.h3clothing.dto.ProductDTO;
import net.aptech.h3clothing.entity.Product;
import net.aptech.h3clothing.repository.ProductRepository;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.ProductService;
import net.aptech.h3clothing.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements GenericService<ProductDTO>, ProductService {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  Utility utility;


  @Override
  public List<ProductDTO> getAll() {
    return utility.convertProductDTOFromProducts(productRepository.findAll());
  }

  @Override
  public ProductDTO save(ProductDTO productDTO) {
    Product p = utility.convertProductFromProductDTO(productDTO);
    productRepository.save(p);
    return new ProductDTO(p.getName(), p.getDescription(), p.getPrice(),
        utility.convertCategoryDTOFromCategory(p.getCategory()));
  }

  @Override
  public Optional<ProductDTO> getById(int id) {
    return Optional.of(utility.convertProductDTOFromProduct(productRepository.getById(id)));
  }

  @Override
  public void remove(int id) {
    productRepository.deleteById(id);
  }

  @Override
  public List<ProductDTO> findAllByPage(String name, int page) {
    Pageable pageable = PageRequest.of(page - 1, 5);
    return StringUtils.hasText(name) == false ? utility.convertProductDTOFromProducts(
        productRepository.findAll(pageable).getContent()) : utility.convertProductDTOFromProducts(
        productRepository.findAllByPage('%' + name + '%', pageable).getContent());
  }
}
