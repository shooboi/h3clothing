package net.aptech.h3clothing.entity;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "category")
public class Category extends Base{
    @Column(name = "title")
    private String title;

    @Column(name = "parent_id")
    private int parentId;

    public Category() {
    }

    public Category(String title, int parentId) {
        this.title = title;
        this.parentId = parentId;
    }
}
