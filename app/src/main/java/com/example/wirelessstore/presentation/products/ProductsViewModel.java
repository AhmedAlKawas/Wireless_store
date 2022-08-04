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
    CartItem cartItem;

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

    private final MutableLiveData<Boolean> _addOrRemoveItemFromCartResponse = new MutableLiveData<>();

    MutableLiveData<Boolean> getAddOrRemoveItemFromCartResponse() {
        return _addOrRemoveItemFromCartResponse;
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

    void addOrRemoveItemFromCart(Product product) {
        if (!product.getProductIsAddedToCart())
            removeCartItem(product);
        else
            addCartItem(product);
    }

    private void addCartItem(Product product) {

        cartItem = new CartItem(product, System.currentTimeMillis());
        cartUseCases.getInsertCartItem().insertItem(cartItem)
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean success) {
                        if (success) {
                            if (carts == null)
                                carts = new ArrayList<>();
                            carts.add(cartItem);
                            cartItem = null;
                            _addOrRemoveItemFromCartResponse.postValue(true);
                        } else
                            _addOrRemoveItemFromCartResponse.postValue(false);

                    }

                    @Override
                    public void onError(Throwable e) {
                        _addOrRemoveItemFromCartResponse.postValue(false);
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
                    cartItem = item;
                    break;
                }

            }

            if (cartItem != null) {

                cartUseCases.getRemoveCartItem().removeItem(cartItem).subscribe(
                        new Observer<Boolean>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(Boolean success) {
                                if (success)
                                    carts.remove(cartItem);
                                cartItem = null;
                                _addOrRemoveItemFromCartResponse.postValue(success);
                            }

                            @Override
                            public void onError(Throwable e) {
                                _addOrRemoveItemFromCartResponse.postValue(false);
                            }

                            @Override
                            public void onComplete() {

                            }
                        }
                );

            } else
                _addOrRemoveItemFromCartResponse.postValue(false);

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
