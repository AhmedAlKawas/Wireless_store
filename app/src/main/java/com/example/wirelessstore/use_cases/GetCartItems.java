package com.example.wirelessstore.use_cases;

import com.example.wirelessstore.domain.model.CartItem;
import com.example.wirelessstore.domain.repository.CartsRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GetCartItems extends CartUseCases {

    CartsRepository cartsRepository;

    public GetCartItems(CartsRepository cartsRepository) {
        super();
        this.cartsRepository = cartsRepository;
    }

    public Observable<List<CartItem>> getCartItems() {

        return Observable.create(emitter ->
                cartsRepository.getCartItems().observeOn(Schedulers.io())
                        .subscribeOn(Schedulers.io()).subscribe(
                                new Observer<List<CartItem>>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(List<CartItem> products) {
                                        emitter.onNext(products);
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        emitter.onError(e);
                                    }

                                    @Override
                                    public void onComplete() {

                                    }
                                })
        );

    }
}
