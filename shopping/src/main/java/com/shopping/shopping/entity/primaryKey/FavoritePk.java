package com.shopping.shopping.entity.primaryKey;

import java.io.Serializable;

import javax.persistence.JoinColumn;


import com.shopping.shopping.entity.ProductEntity;
import com.shopping.shopping.entity.UserEntity;

public class FavoritePk implements Serializable {

    @JoinColumn(name = "user_email")
    private UserEntity userEntity;

    @JoinColumn(name = "product_number")
    private ProductEntity productEntity;
}

