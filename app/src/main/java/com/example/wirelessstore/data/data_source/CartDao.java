package com.example.wirelessstore.data.data_source;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.wirelessstore.domain.model.CartItem;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface CartDao {

    @Query("SELECT * from carts_table")
    Observable<List<CartItem>> getCartItems();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertItem(CartItem cartItem);

    @Delete
    void removeItem(CartItem cartItem);

}
