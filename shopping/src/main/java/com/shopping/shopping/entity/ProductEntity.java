package com.shopping.shopping.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.shopping.shopping.dto.request.PostProductRequestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Product")
@Table(name = "Product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productNumber;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_detail_number", nullable = false)
    private CategoryDetailEntity categoryDetailEntity;

    @Column(nullable = false, length = 512)
    private String imageUrl;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false, length = 19)
    private String createDate;

    public ProductEntity(PostProductRequestDto dto, CategoryDetailEntity categoryDetailEntity, String imageUrl) {
        Date now = new Date(); 
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createDate = simpleDateFormat.format(now);

        this.categoryDetailEntity = categoryDetailEntity;
        this.imageUrl = imageUrl;
        this.price = dto.getPrice();
        this.createDate = createDate;
    }
}
