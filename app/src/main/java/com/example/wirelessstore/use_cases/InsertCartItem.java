package com.example.wirelessstore.use_cases;

import com.example.wirelessstore.domain.model.CartItem;
import com.example.wirelessstore.domain.repository.CartsRepository;

import io.reactivex.Observable;

public class InsertCartItem extends CartUseCases {

    CartsRepository cartsRepository;

    public InsertCartItem(CartsRepository cartsRepository) {
        super();
        this.cartsRepository = cartsRepository;
    }

    public Observable<Boolean> insertItem(CartItem cartItem) {

        return Observable.create(emitter -> {
                    try {
                        cartsRepository.insertItem(cartItem);
                        emitter.onNext(true);
                    } catch (Exception e) {
                        emitter.onError(e);
                    }
                }
        );

    }

}
