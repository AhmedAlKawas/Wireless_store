package com.example.wirelessstore.use_cases;

import com.example.wirelessstore.domain.model.CartItem;
import com.example.wirelessstore.domain.repository.CartsRepository;

import io.reactivex.Observable;

public class RemoveCartItem extends CartUseCases {

    CartsRepository cartsRepository;

    public RemoveCartItem(CartsRepository cartsRepository) {
        super();
        this.cartsRepository = cartsRepository;
    }

    public Observable<Boolean> removeItem(CartItem cartItem) {

        return Observable.create(emitter -> {
                    try {
                        cartsRepository.removeItem(cartItem);
                        emitter.onNext(true);
                    } catch (Exception e) {
                        emitter.onError(e);
                    }
                }
        );

    }

}
