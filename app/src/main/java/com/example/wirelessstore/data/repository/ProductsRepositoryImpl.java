package com.example.wirelessstore.data.repository;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.wirelessstore.data.data_source.ProductsDao;
import com.example.wirelessstore.domain.model.Product;
import com.example.wirelessstore.domain.repository.ProductsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ProductsRepositoryImpl implements ProductsRepository {

    ProductsDao productsDao;

    @Inject
    public ProductsRepositoryImpl(ProductsDao productsDao) {
        this.productsDao = productsDao;
    }

    @Override
    public Observable<List<Product>> getProducts() {
        return productsDao.getProducts();
    }

    @Override
    public void insertProduct(Product product) {
        new ProductsRepositoryImpl.insertAsyncTask(productsDao).execute(product);
    }

    private static class insertAsyncTask extends AsyncTask<Product, Void, Void> {

        ProductsDao asyncDao;

        insertAsyncTask(ProductsDao dao) {
            asyncDao = dao;
        }

        @Override
        protected Void doInBackground(Product... products) {
            asyncDao.insertProduct(products[0]);
            return null;
        }
    }

}
