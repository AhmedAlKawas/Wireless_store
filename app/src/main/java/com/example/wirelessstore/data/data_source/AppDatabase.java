package com.example.wirelessstore.data.data_source;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.wirelessstore.domain.model.Product;

@Database(entities = {Product.class}, exportSchema = false, version = 1)
abstract public class AppDatabase extends RoomDatabase {

    public abstract ProductsDao productsDao();

}
