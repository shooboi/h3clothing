package net.aptech.h3clothing.service.serviceImpl;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import net.aptech.h3clothing.dto.ProductDTO;
import net.aptech.h3clothing.entity.Product;
import net.aptech.h3clothing.repository.ProductRepository;
import net.aptech.h3clothing.service.GenericService;
import net.aptech.h3clothing.service.ProductService;
import net.aptech.h3clothing.service.mapper.ProductMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements GenericService<ProductDTO>, ProductService {

  final ProductRepository productRepository;

  final ProductMapper productMapper;


  @Override
  public List<ProductDTO> getAll() {
    return productRepository.findAll().stream().map(productMapper::getProductDTOFromProduct)
        .collect(
            Collectors.toList());
  }

  @Override
  public ProductDTO add(ProductDTO productDTO) {
    Product product = productRepository.save(productMapper.getProductFromProductDTO(productDTO));
    return productMapper.getProductDTOFromProduct(product);
  }

  @Override
  public ProductDTO update(int id, ProductDTO productDTO) {
    Product product = productRepository.getById(id);
    productMapper.updateProduct(productDTO, product);
    productRepository.save(product);
    return productMapper.getProductDTOFromProduct(product);
  }


  @Override
  public Optional<ProductDTO> getById(int id) {
    return Optional.ofNullable(
        productMapper.getProductDTOFromProduct(productRepository.getById(id)));
  }


  @Override
  public void remove(int id) {
    productRepository.deleteById(id);
  }

  @Override
  public List<ProductDTO> findAllByPage(ProductDTO dto, int page) {
    Pageable pageable = PageRequest.of(page - 1, 5);
    List<Product> products = productRepository.findAllByPage(dto.getName(),
        Optional.ofNullable(dto.getId()),
        dto.getDescription(), Optional.ofNullable(dto.getPrice()), pageable).getContent();
    return products.stream().map(productMapper::getProductDTOFromProduct)
        .collect(Collectors.toList());
  }
}
