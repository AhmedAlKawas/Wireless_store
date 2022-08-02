package com.example.wirelessstore.domain.repository;

import com.example.wirelessstore.domain.model.Product;

import java.util.List;

import io.reactivex.Observable;

public interface ProductsRepository {

    Observable<List<Product>> getProducts();

    void insertProduct(Product product);

}
