package com.example.wirelessstore.data.data_source;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.wirelessstore.domain.model.Product;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface ProductsDao {

    @Query("SELECT * from products_table")
    Observable<List<Product>> getProducts();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProduct(Product product);

}
