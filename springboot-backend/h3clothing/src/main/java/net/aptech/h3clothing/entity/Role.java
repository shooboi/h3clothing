package net.aptech.h3clothing.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table(name = "role")
@Entity
public class Role extends Base {
    @Column(name = "roll_name")
    private String rollName;
}
