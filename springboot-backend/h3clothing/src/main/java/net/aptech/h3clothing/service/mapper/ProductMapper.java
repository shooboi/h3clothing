package net.aptech.h3clothing.service.mapper;

import net.aptech.h3clothing.dto.ProductDTO;
import net.aptech.h3clothing.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {

  ProductDTO getProductDTOFromProduct(Product product);

  Product getProductFromProductDTO(ProductDTO productDTO);

  void updateProduct(ProductDTO productDTO, @MappingTarget Product product);

}
