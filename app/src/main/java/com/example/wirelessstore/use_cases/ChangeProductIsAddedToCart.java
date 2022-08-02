package com.example.wirelessstore.use_cases;

import com.example.wirelessstore.domain.model.Product;
import com.example.wirelessstore.domain.repository.ProductsRepository;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ChangeProductIsAddedToCart {

    private final ProductsRepository repository;

    @Inject
    public ChangeProductIsAddedToCart(ProductsRepository repository) {
        this.repository = repository;
    }

    public Observable<Boolean> changeProductIsAddedToCart(Product product) {

        product.setProductIsAddedToCart(!product.getProductIsAddedToCart());

        return Observable.create(emitter -> {
                    try {
                        repository.insertProduct(product);
                        emitter.onNext(true);
                    } catch (Exception e) {
                        emitter.onError(e);
                    }
                }
        );

    }

}
