package net.aptech.h3clothing.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "users")
public class User extends Base {

    @Id
    @Column(name = "user_id")
    private String userId;
    @Email
    @NotBlank
    @Column(name = "email")
    private String email;
    //Pattern(regexp = "/^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=.*\\d).*$")
    @Size(min=8, max=16)
    @Column(name = "password")
    private String password;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet = new HashSet<>();
}
