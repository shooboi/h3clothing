package net.aptech.h3clothing.util;

import net.aptech.h3clothing.dto.*;
import net.aptech.h3clothing.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Utility {
    //User
    public UserDTO convertUserDTOFromUser(User user) {
        return new UserDTO(user.getEmail(), user.getPassword());
    }

    public List<UserDTO> convertUserDTOFromUsers(List<User> users) {
        return users.stream().map(this::convertUserDTOFromUser).collect(Collectors.toList());
    }

    public User convertUserFromUserDTO(UserDTO dto) {
        return new User(dto.getEmail(), dto.getPassword());
    }

    //Product
    public ProductDTO convertProductDTOFromProduct(Product product) {
        return new ProductDTO(product.getName(), product.getDescription(), product.getPrice());
    }

    public List<ProductDTO> convertProductDTOFromProducts(List<Product> products) {
        return products.stream().map(this::convertProductDTOFromProduct).collect(Collectors.toList());
    }

    public Product convertProductFromProductDTO(ProductDTO dto) {
        return new Product(dto.getName(), dto.getDescription(), dto.getPrice());
    }

    //Category

    public CategoryDTO convertCategoryDTOFromCategory(Category category) {
        return new CategoryDTO(category.getTitle(), category.getParentId());
    }

    public List<CategoryDTO> convertCategoryDTOFromCategories(List<Category> categories) {
        return categories.stream().map(this::convertCategoryDTOFromCategory).collect(Collectors.toList());
    }

    public Category convertCategoryFromCategoryDTO(CategoryDTO dto) {
        return new Category(dto.getTitle(), dto.getParentId());
    }

    //Role

    public RoleDTO convertRoleDTOFromRole(Role role) {
        return new RoleDTO(role.getRoleName());
    }

    public List<RoleDTO> convertRoleDTOFromRoles(List<Role> roles) {
        return roles.stream().map(this::convertRoleDTOFromRole).collect(Collectors.toList());
    }

    public Role convertRoleFromRoleDTO(RoleDTO dto) {
        return new Role(dto.getRoleName());
    }

    //Size

    public SizeDTO convertSizeDTOFromSize(Size size) {
        return new SizeDTO(size.getName(),size.getQuantity());
    }

    public List<SizeDTO> convertSizeDTOFromSizes(List<Size> sizes) {
        return sizes.stream().map(this::convertSizeDTOFromSize).collect(Collectors.toList());
    }

    public Size convertSizeFromSizeDTO(SizeDTO dto) {
        return new Size(dto.getName(),dto.getQuantity());
    }

    //UserInf

    public UserInfDTO convertUserInfDTOFromUserInf(User_Info userInfo) {
        return new UserInfDTO(userInfo.getFullName(), userInfo.getPhoneNumber(),userInfo.getAddress(),userInfo.isDeleted(),userInfo.getDob());
    }

    public List<UserInfDTO> convertUserInfDTOFromUserInfList(List<User_Info> userInfos) {
        return userInfos.stream().map(this::convertUserInfDTOFromUserInf).collect(Collectors.toList());
    }

    public User_Info convertUserInfFromUserInfDTO(UserInfDTO dto) {
        return new User_Info(dto.getFullName(),dto.getPhoneNumber(),dto.getAddress(),dto.isDeleted(),dto.getDob());
    }

    //Thumbnail_Image

    public ThumbnailDTO convertThumbnailDTOFromThumbnail(Thumbnail_Image thumbnailImage) {
        return new ThumbnailDTO(thumbnailImage.getImageUrl());
    }

    public List<ThumbnailDTO> convertThumbnailDTOFromThumbnails(List<Thumbnail_Image> thumbnailImages) {
        return thumbnailImages.stream().map(this::convertThumbnailDTOFromThumbnail).collect(Collectors.toList());
    }

    public Thumbnail_Image convertThumbnailFromThumbnailDTO(ThumbnailDTO dto) {
        return new Thumbnail_Image(dto.getImageUrl());
    }

    //Order

    public OrderDTO convertOrderDTOFromOrder(Order order) {
        return new OrderDTO(order.getOrderDate(),order.getTotalAmount(),order.getPaymentMethod(),order.getDeliveryAddress(),order.getStatus());
    }

    public List<OrderDTO> convertOrderDTOFromOrders(List<Order> orders) {
        return orders.stream().map(this::convertOrderDTOFromOrder).collect(Collectors.toList());
    }

    public Order convertOrderFromOrderDTO(OrderDTO dto) {
        return new Order(dto.getOrderDate(), dto.getTotalAmount(),dto.getPaymentMethod(),dto.getDeliveryAddress(),dto.getStatus());
    }


}
