package com.example.wirelessstore.di;

import android.app.Application;

import com.example.wirelessstore.data.data_source.AppDatabase;
import com.example.wirelessstore.domain.repository.ProductsRepository;
import com.example.wirelessstore.presentation.products.ProductsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RoomModule.class})
public interface AppComponent {

    void inject(ProductsActivity mainActivity);

    AppDatabase database();

    ProductsRepository productRepository();

    Application application();

}
