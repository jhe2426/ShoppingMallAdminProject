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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Orders")
@Table(name = "Orders")
public class OrdersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_number")
    private int ordersNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_email", nullable = false)
    private UserEntity userEntity;

    @Column(nullable = false)
    private int productNumber;

    @Column(nullable = false, length = 512)
    private String productImageUrl;

    @Column(nullable = false)
    private int totalPrice;

    @Column(nullable = false)
    private int totalOrderCount;

    @Column(nullable = false, length = 19)
    private String ordersDate;


}
