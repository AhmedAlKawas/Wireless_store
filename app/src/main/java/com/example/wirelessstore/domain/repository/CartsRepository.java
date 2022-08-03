package com.example.wirelessstore.domain.repository;

import com.example.wirelessstore.domain.model.CartItem;

import java.util.List;

import io.reactivex.Observable;

public interface CartsRepository {

    Observable<List<CartItem>> getCartItems();
    void insertItem(CartItem cartItem);
    void removeItem(CartItem cartItem);

}
