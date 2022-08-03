package com.example.wirelessstore.domain.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.wirelessstore.utils.ProductTypeConverter;

@Entity(tableName = "carts_table")
public class CartItem {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cart_item_id")
    private int id;

    @ColumnInfo(name = "product")
    @TypeConverters(ProductTypeConverter.class)
    private Product product;

    @ColumnInfo(name = "created_time_in_milli_second")
    private long createdTimeInMilliSecond;

    public CartItem(Product product, long createdTimeInMilliSecond) {
        this.product = product;
        this.createdTimeInMilliSecond = createdTimeInMilliSecond;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public long getCreatedTimeInMilliSecond() {
        return createdTimeInMilliSecond;
    }

    public void setCreatedTimeInMilliSecond(long createdTimeInMilliSecond) {
        this.createdTimeInMilliSecond = createdTimeInMilliSecond;
    }
}
