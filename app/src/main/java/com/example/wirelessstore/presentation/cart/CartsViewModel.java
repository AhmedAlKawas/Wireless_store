package com.example.wirelessstore.presentation.cart;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wirelessstore.domain.model.CartItem;
import com.example.wirelessstore.use_cases.CartUseCases;
import com.example.wirelessstore.use_cases.ChangeProductIsAddedToCart;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class CartsViewModel extends ViewModel {

    private final ChangeProductIsAddedToCart changeProductIsAddedToCartUseCase;
    private final CartUseCases cartUseCases;

    private final MutableLiveData<List<CartItem>> _cartItems = new MutableLiveData<>();

    MutableLiveData<List<CartItem>> cartItems() {
        return _cartItems;
    }

    private final MutableLiveData<Boolean> _removeCartItemResponse = new MutableLiveData<>();

    MutableLiveData<Boolean> getRemoveCartItemResponse() {
        return _removeCartItemResponse;
    }

    private final MutableLiveData<Boolean> _changeProductAddedToCartResponse = new MutableLiveData<>();

    MutableLiveData<Boolean> getChangeProductAddedToCartResponse() {
        return _changeProductAddedToCartResponse;
    }

    @Inject
    public CartsViewModel(ChangeProductIsAddedToCart changeProductIsAddedToCartUseCase,
                          CartUseCases cartUseCases) {
        this.changeProductIsAddedToCartUseCase = changeProductIsAddedToCartUseCase;
        this.cartUseCases = cartUseCases;
    }

    void getCartItems() {
        cartUseCases.getGetCartItems().getCartItems().subscribe(
                new Observer<List<CartItem>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<CartItem> cartItems) {
                        _cartItems.postValue(cartItems);
                    }

                    @Override
                    public void onError(Throwable e) {
                        _cartItems.postValue(null);
                    }

                    @Override
                    public void onComplete() {

                    }
                }
        );
    }

    void removeCartItem(CartItem item) {

        cartUseCases.getRemoveCartItem().removeItem(item).subscribe(
                new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean success) {
                        _removeCartItemResponse.postValue(success);
                    }

                    @Override
                    public void onError(Throwable e) {
                        _removeCartItemResponse.postValue(false);
                    }

                    @Override
                    public void onComplete() {

                    }
                }
        );

    }

    void changeProductAddedToCart(CartItem item){

        changeProductIsAddedToCartUseCase.changeProductIsAddedToCart(item.getProduct()).subscribe(
                new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean status) {
                        _changeProductAddedToCartResponse.postValue(status);
                    }

                    @Override
                    public void onError(Throwable e) {
                        _changeProductAddedToCartResponse.postValue(false);
                    }

                    @Override
                    public void onComplete() {

                    }
                }
        );

    }

}
