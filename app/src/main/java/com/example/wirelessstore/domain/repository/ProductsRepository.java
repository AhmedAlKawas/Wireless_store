package com.example.wirelessstore.domain.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.wirelessstore.domain.model.Product;

import java.util.List;

public interface ProductsRepository {

    LiveData<List<Product>> getProducts();

    void insertProduct(Product product);

}
