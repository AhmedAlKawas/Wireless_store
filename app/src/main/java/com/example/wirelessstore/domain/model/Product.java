package com.example.wirelessstore.domain.model;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.wirelessstore.R;

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

    @BindingAdapter("loadImage")
    public static void loadImageByGlide(ImageView imageView, String imgUrl) {
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(R.drawable.ic_baseline_phone_android_24)
                .error(R.drawable.ic_baseline_phone_android_24)
                .centerCrop();

        Glide.with(imageView.getContext()).setDefaultRequestOptions(requestOptions)
                .load(imgUrl)
                .into(imageView);
    }

    @BindingAdapter("applyCartBtnDrawable")
    public static void loadImageByGlide(ImageView imageView, boolean isProductAddedToCart) {
        imageView.setImageResource(isProductAddedToCart ?
                R.drawable.ic_baseline_shopping_cart_24 :
                R.drawable.ic_baseline_add_shopping_cart_24);
    }

}
