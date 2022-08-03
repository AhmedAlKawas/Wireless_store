package com.example.wirelessstore.presentation.products;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wirelessstore.domain.model.CartItem;
import com.example.wirelessstore.domain.model.Product;
import com.example.wirelessstore.use_cases.CartUseCases;
import com.example.wirelessstore.use_cases.ChangeProductIsAddedToCart;
import com.example.wirelessstore.use_cases.GetProducts;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class ProductsViewModel extends ViewModel {

    private final GetProducts getProductsUseCase;
    private final ChangeProductIsAddedToCart changeProductIsAddedToCartUseCase;
    private final CartUseCases cartUseCases;
    private List<CartItem> carts;
    CartItem desiredRemoveCartItem;

    @Inject
    public ProductsViewModel(GetProducts getProductsUseCase,
                             ChangeProductIsAddedToCart changeProductIsAddedToCartUseCase,
                             CartUseCases cartUseCases) {
        this.getProductsUseCase = getProductsUseCase;
        this.changeProductIsAddedToCartUseCase = changeProductIsAddedToCartUseCase;
        this.cartUseCases = cartUseCases;
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

                        if (success){
                            product.setProductIsAddedToCart(!product.getProductIsAddedToCart());
                            if (product.getProductIsAddedToCart())
                                removeCartItem(product);
                            else
                                addCartItem(product);
                        }else
                            _changeProductIsAddedToCart.postValue(false);

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

    private void addCartItem(Product product) {
        cartUseCases.getInsertCartItem().insertItem(new CartItem(
                product, System.currentTimeMillis()
        )).subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Boolean success) {
                if (success) {
                    carts.add(desiredRemoveCartItem);
                    _changeProductIsAddedToCart.postValue(true);
                }else
                    _changeProductIsAddedToCart.postValue(false);
                desiredRemoveCartItem = null;

            }

            @Override
            public void onError(Throwable e) {
                _changeProductIsAddedToCart.postValue(false);
            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void removeCartItem(Product product) {

        if (carts != null && !carts.isEmpty()) {

            for (CartItem item : carts) {

                if (item.getProduct().getId() == product.getId()) {
                    desiredRemoveCartItem = item;
                    break;
                }

            }

            if (desiredRemoveCartItem != null) {

                cartUseCases.getRemoveCartItem().removeItem(desiredRemoveCartItem).subscribe(
                        new Observer<Boolean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Boolean success) {
                                if (success)
                                    carts.remove(desiredRemoveCartItem);
                                desiredRemoveCartItem = null;
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

            } else
                _changeProductIsAddedToCart.postValue(false);

        }

    }

    void getCartItems() {
        cartUseCases.getGetCartItems().getCartItems().subscribe(
                new Observer<List<CartItem>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<CartItem> cartItems) {
                        if (cartItems != null && !cartItems.isEmpty()) {

                            if (carts == null)
                                carts = new ArrayList<>();

                            carts.addAll(cartItems);

                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                }
        );
    }

}
