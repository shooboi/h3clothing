package net.aptech.h3clothing.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Data
@Table(name = "role")
@Entity
public class Role extends Base {
    @Pattern(regexp = "([A-Za-z\\d]+( [A-Za-z\\d]+)+)")
    @Column(name = "roll_name")
    private String rollName;
}
