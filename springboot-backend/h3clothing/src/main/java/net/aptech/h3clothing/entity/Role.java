package net.aptech.h3clothing.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "role")
@Entity
public class Role extends Base {

    @Column(name = "roll_name")
    private String roleName;

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }


}
