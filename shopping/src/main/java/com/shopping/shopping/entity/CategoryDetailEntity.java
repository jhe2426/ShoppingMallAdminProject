package com.shopping.shopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Categorydetail")
@Table(name = "Categorydetail")
public class CategoryDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryDetailNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_type_number", nullable = false)
    private CategoryTypeEntity categoryTypeEntity;

    @Column(nullable = false, length = 30)
    private String categoryDetail;

}
