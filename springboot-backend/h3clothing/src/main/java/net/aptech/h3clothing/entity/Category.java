package net.aptech.h3clothing.entity;

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
}