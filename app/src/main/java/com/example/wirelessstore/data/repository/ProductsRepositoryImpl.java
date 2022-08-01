package com.example.wirelessstore.data.repository;

import androidx.lifecycle.LiveData;

import com.example.wirelessstore.data.data_source.ProductsDao;
import com.example.wirelessstore.domain.model.Product;
import com.example.wirelessstore.domain.repository.ProductsRepository;

import java.util.List;

import javax.inject.Inject;

public class ProductsRepositoryImpl implements ProductsRepository {

    ProductsDao productsDao;

    @Inject
    public ProductsRepositoryImpl(ProductsDao productsDao) {
        this.productsDao = productsDao;
    }

    @Override
    public LiveData<List<Product>> getProducts() {
        return productsDao.getProducts();
    }

    @Override
    public void insertProduct(Product product) {
        productsDao.insertProduct(product);
    }
}
