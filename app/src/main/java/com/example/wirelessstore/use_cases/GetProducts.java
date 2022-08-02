package com.example.wirelessstore.use_cases;

import com.example.wirelessstore.domain.model.Product;
import com.example.wirelessstore.domain.model.ProductsList;
import com.example.wirelessstore.domain.repository.ProductsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class GetProducts {

    private final ProductsRepository repository;

    @Inject
    public GetProducts(ProductsRepository repository) {
        this.repository = repository;
    }

    public Observable<List<Product>> getProducts() {

        return Observable.create(emitter ->
                repository.getProducts().observeOn(Schedulers.io())
                        .subscribeOn(Schedulers.io()).subscribe(
                                new Observer<List<Product>>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {

                                    }

                                    @Override
                                    public void onNext(List<Product> products) {

                                        try {
                                            if (!products.isEmpty()) {
                                                if (products.size() ==
                                                        ProductsList.getProductsList().size()) {
                                                    emitter.onNext(products);
                                                }
                                            } else {
                                                createDummyData();
                                            }
                                        } catch (Exception e) {
                                            emitter.onError(e);
                                        }

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

    void createDummyData() {

        for (Product product : ProductsList.getProductsList()) {

            repository.insertProduct(product);

        }

        getProducts();

    }

}
