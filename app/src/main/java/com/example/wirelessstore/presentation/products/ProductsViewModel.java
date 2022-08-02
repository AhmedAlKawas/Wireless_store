package com.example.wirelessstore.presentation.products;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wirelessstore.domain.model.Product;
import com.example.wirelessstore.use_cases.ChangeProductIsAddedToCart;
import com.example.wirelessstore.use_cases.GetProducts;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class ProductsViewModel extends ViewModel {

    private final GetProducts getProductsUseCase;
    private final ChangeProductIsAddedToCart changeProductIsAddedToCartUseCase;

    @Inject
    public ProductsViewModel(GetProducts getProductsUseCase,
                             ChangeProductIsAddedToCart changeProductIsAddedToCartUseCase) {
        this.getProductsUseCase = getProductsUseCase;
        this.changeProductIsAddedToCartUseCase = changeProductIsAddedToCartUseCase;
    }

    private final MutableLiveData<List<Product>> _products = new MutableLiveData<>();

    MutableLiveData<List<Product>> products() {
        return _products;
    }

    private final MutableLiveData<Boolean> _changeProductIsAddedToCart = new MutableLiveData<>();

    MutableLiveData<Boolean> getChangeProductIsAddedToCartResponse() {
        return _changeProductIsAddedToCart;
    }

    void getProducts() {
        getProductsUseCase.getProducts().subscribe(
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

    void changeProductIsAddedToCart(Product product) {
        changeProductIsAddedToCartUseCase.changeProductIsAddedToCart(product).subscribe(
                new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean success) {
                        _changeProductIsAddedToCart.postValue(success);
                    }

                    @Override
                    public void onError(Throwable e) {
                        _changeProductIsAddedToCart.postValue(false);
                    }

                    @Override
                    public void onComplete() {

                    }
                }
        );
    }

}
