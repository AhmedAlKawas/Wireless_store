package com.example.wirelessstore.di;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.example.wirelessstore.data.data_source.AppDatabase;
import com.example.wirelessstore.data.repository.CartRepositoryImpl;
import com.example.wirelessstore.data.repository.ProductsRepositoryImpl;
import com.example.wirelessstore.domain.repository.CartsRepository;
import com.example.wirelessstore.domain.repository.ProductsRepository;
import com.example.wirelessstore.use_cases.CartUseCases;
import com.example.wirelessstore.use_cases.ChangeProductIsAddedToCart;
import com.example.wirelessstore.use_cases.GetCartItems;
import com.example.wirelessstore.use_cases.GetProducts;
import com.example.wirelessstore.use_cases.InsertCartItem;
import com.example.wirelessstore.use_cases.RemoveCartItem;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    Application application;

    public RoomModule(@NonNull Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    AppDatabase providesRoomDatabase() {
        Log.e(
                "bbbb", "ay &aga"
        );
        return Room.databaseBuilder(
                application,
                AppDatabase.class,
                "app_database"
        ).build();
    }

    @Singleton
    @Provides
    ProductsRepository productsRepository(AppDatabase database) {
        return new ProductsRepositoryImpl(database.productsDao());
    }

    @Singleton
    @Provides
    GetProducts provideGetProductsUseCase(ProductsRepository repository) {
        return new GetProducts(repository);
    }

    @Singleton
    @Provides
    ChangeProductIsAddedToCart provideChangeProductIsAddedToCart(ProductsRepository repository) {
        return new ChangeProductIsAddedToCart(repository);
    }

    @Singleton
    @Provides
    CartsRepository cartRepository(AppDatabase database) {
        return new CartRepositoryImpl(database.cartDao());
    }

    @Singleton
    @Provides
    CartUseCases provideCartUseCases(CartsRepository repository) {
        return new CartUseCases(
                new GetCartItems(repository),
                new InsertCartItem(repository),
                new RemoveCartItem(repository)
        );
    }

}
