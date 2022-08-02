package com.example.wirelessstore.domain.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "products_table")
public class Product {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "product_id")
    private int id;

    @ColumnInfo(name = "product_name")
    private String productName;

    @ColumnInfo(name = "product_image_url")
    private String productImageUrl;

    @ColumnInfo(name = "product_is_added_to_cart")
    private boolean productIsAddedToCart;

    public Product(String productName, String productImageUrl, boolean productIsAddedToCart) {
        this.productName = productName;
        this.productImageUrl = productImageUrl;
        this.productIsAddedToCart = productIsAddedToCart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public boolean getProductIsAddedToCart() {
        return productIsAddedToCart;
    }

    public void setProductIsAddedToCart(boolean productIsAddedToCart) {
        this.productIsAddedToCart = productIsAddedToCart;
    }
}
