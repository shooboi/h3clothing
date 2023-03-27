package net.aptech.h3clothing.entity;

import lombok.Data;
import org.hibernate.annotations.NaturalId;
import net.aptech.h3clothing.entity.enums.Rolename;

import javax.persistence.*;

@Data
@Table(name = "roles")
@Entity
public class Role extends Base {

    @Enumerated(EnumType.STRING)
//    @NaturalId
    @Column(name = "Rolename")
    private Rolename Rolename;

    public Role() {
    }

    public Role(Rolename rolename) {
        this.Rolename = rolename;
    }

    public Rolename getRoleName() {
        return Rolename;
    }

    public void setRollName(Rolename rolename) {
        this.Rolename = rolename;
    }
}
