package com.shopping.shopping.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Product")
@Table(name = "Product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productNumber;

    @Column(nullable = false, length = 512)
    private String imageUrl;

    private int price;

    @Column(nullable = false, length = 30)
    private String categoryType;

    @Column(nullable = false, length = 30)
    private String categoryDetail;
    
    @Column(nullable = false, length = 19)
    private String createDate;
}
