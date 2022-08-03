package com.example.wirelessstore.data.repository;

import android.os.AsyncTask;

import com.example.wirelessstore.data.data_source.CartDao;
import com.example.wirelessstore.domain.model.CartItem;
import com.example.wirelessstore.domain.repository.CartsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CartRepositoryImpl implements CartsRepository {

    CartDao cartDao;

    @Inject
    public CartRepositoryImpl(CartDao cartDao) {
        this.cartDao = cartDao;
    }

    @Override
    public Observable<List<CartItem>> getCartItems() {
        return cartDao.getCartItems();
    }

    @Override
    public void insertItem(CartItem cartItem) {
        new CartRepositoryImpl.insertAsyncTask(cartDao).execute(cartItem);
    }

    @Override
    public void removeItem(CartItem cartItem) {
        cartDao.removeItem(cartItem);
    }

    private static class insertAsyncTask extends AsyncTask<CartItem, Void, Void> {

        CartDao asyncDao;

        insertAsyncTask(CartDao dao) {
            asyncDao = dao;
        }

        @Override
        protected Void doInBackground(CartItem... cartItems) {
            asyncDao.insertItem(cartItems[0]);
            return null;
        }
    }

}
