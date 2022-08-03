package com.example.wirelessstore.utils;

import androidx.room.TypeConverter;

import com.example.wirelessstore.domain.model.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class ProductTypeConverter {

    private static final Gson gson = new Gson();

    @TypeConverter
    public static String convertProductToJson(Product product) {
        return gson.toJson(product);
    }

    @TypeConverter
    public static Product convertJsonToProduct(String data) {
        if (data == null) {
            return null;
        }

        Type listType = new TypeToken<Product>() {
        }.getType();
        return gson.fromJson(data, listType);
    }

}
