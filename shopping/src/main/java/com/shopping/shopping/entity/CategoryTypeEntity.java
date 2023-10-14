package com.shopping.shopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Categorytype")
@Table(name = "Categorytype")
public class CategoryTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryTypeNumber;

    @Column(nullable = false, length = 30, unique = true)
    private String categoryType;
}
