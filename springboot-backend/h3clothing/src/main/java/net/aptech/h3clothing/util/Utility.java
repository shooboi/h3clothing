package net.aptech.h3clothing.util;

import net.aptech.h3clothing.dto.ProductDTO;
import net.aptech.h3clothing.dto.UserDTO;
import net.aptech.h3clothing.entity.Product;
import net.aptech.h3clothing.entity.User;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Utility {
    public UserDTO convertUserDTOFromUser(User user){
        return new UserDTO(user.getEmail(), user.getPassword());
    }
    public List<UserDTO> convertUserDTOFromUsers(List<User> users){
        return users.stream().map(this::convertUserDTOFromUser).collect(Collectors.toList());
    }
    public User convertUserFromUserDTO(UserDTO dto){
        return new User(dto.getEmail(),dto.getPassword());
    }
    public ProductDTO convertProductDTOFromProduct(Product product){
        return new ProductDTO(product.getName(), product.getDescription(), product.getPrice());
    }
    public List<ProductDTO> convertProductDTOFromProducts(List<Product> products){
        return products.stream().map(this::convertProductDTOFromProduct).collect(Collectors.toList());
    }
    public Product convertProductFromProductDTO(ProductDTO dto){
        return new Product(dto.getName(),dto.getDescription(),dto.getPrice());
    }

}
