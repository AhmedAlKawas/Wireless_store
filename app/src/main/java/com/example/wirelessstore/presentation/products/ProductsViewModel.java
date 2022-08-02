package com.example.wirelessstore.presentation.products;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wirelessstore.domain.model.Product;
import com.example.wirelessstore.domain.repository.ProductsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class ProductsViewModel extends ViewModel {

    private final ProductsRepository repository;

    @Inject
    public ProductsViewModel(ProductsRepository repository) {
        this.repository = repository;
    }

    private final MutableLiveData<List<Product>> _products = new MutableLiveData<>();

    MutableLiveData<List<Product>> products() {
        return _products;
    }

    void getProducts() {
        repository.getProducts().subscribe(
                new Observer<List<Product>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Product> products) {
                        _products.postValue(products);
                    }

                    @Override
                    public void onError(Throwable e) {
                        _products.postValue(null);
                    }

                    @Override
                    public void onComplete() {

                    }
                }
        );
    }

}
