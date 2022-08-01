package com.example.wirelessstore.domain.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.wirelessstore.domain.model.Product;

import java.util.List;

public interface ProductsRepository {

    MutableLiveData<List<Product>> getProducts();

    void insertProductsList();

}
