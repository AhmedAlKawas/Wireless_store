package com.example.wirelessstore.di;

import android.app.Application;

import androidx.room.Room;

import com.example.wirelessstore.data.data_source.AppDatabase;
import com.example.wirelessstore.data.repository.ProductsRepositoryImpl;
import com.example.wirelessstore.domain.repository.ProductsRepository;
import com.example.wirelessstore.use_cases.ChangeProductIsAddedToCart;
import com.example.wirelessstore.use_cases.GetProducts;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    private final AppDatabase database;

    public RoomModule(Application mApplication) {
        database = Room.databaseBuilder(
                mApplication,
                AppDatabase.class,
                "app_database"
        ).build();
    }

    @Singleton
    @Provides
    AppDatabase providesRoomDatabase() {
        return database;
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

}
