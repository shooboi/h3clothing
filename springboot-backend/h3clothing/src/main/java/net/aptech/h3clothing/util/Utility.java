package net.aptech.h3clothing.util;

import net.aptech.h3clothing.dto.*;
import net.aptech.h3clothing.entity.*;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

    //Blog
    public BlogDTO convertBlogDTOFromBlog(Blog blog){
        return new BlogDTO(blog.getTitle(), blog.getDescription(), convertUserInfDTOFromUserInf(blog.getUser()), blog.isPublished(), blog.getCreatedAt(), blog.getUpdatedAt());
    }

    public List<BlogDTO> convertBlogDTOFromBlogs(List<Blog> blogs){
        return blogs.stream().map(this::convertBlogDTOFromBlog).collect(Collectors.toList());
    }

    public Blog convertBlogFromBlogDTO(BlogDTO dto){
        return new Blog(dto.getTitle(), dto.getDescription(), convertUserInfFromUserInfDTO(dto.getUser()), dto.isPublished(), dto.getCreatedAt(), dto.getUpdatedAt());
    }

    //Product
    public ProductDTO convertProductDTOFromProduct(Product product) {
        return new ProductDTO(product.getName(), product.getDescription(), product.getPrice(), convertCategoryDTOFromCategory(product.getCategory()));
    }

    public List<ProductDTO> convertProductDTOFromProducts(List<Product> products) {
        return products.stream().map(this::convertProductDTOFromProduct).collect(Collectors.toList());
    }

    public Product convertProductFromProductDTO(ProductDTO dto) {
        return new Product(dto.getName(), dto.getDescription(), dto.getPrice(), convertCategoryFromCategoryDTO(dto.getCategory()));
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
        return new ThumbnailDTO(thumbnailImage.getImageUrl(), convertProductDTOFromProduct(thumbnailImage.getProduct()));
    }

    public List<ThumbnailDTO> convertThumbnailDTOFromThumbnails(List<Thumbnail_Image> thumbnailImages) {
        return thumbnailImages.stream().map(this::convertThumbnailDTOFromThumbnail).collect(Collectors.toList());
    }

    public Thumbnail_Image convertThumbnailFromThumbnailDTO(ThumbnailDTO dto) {
        return new Thumbnail_Image(dto.getImageUrl(), convertProductFromProductDTO(dto.getProduct()));
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

    public static void saveFile(String uploadDir, String fileName,
                                MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {
            throw new IOException("Could not save image file: " + fileName, ioe);
        }
    }



}
