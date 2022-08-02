package com.example.wirelessstore.domain.model;

import java.util.ArrayList;
import java.util.List;

public class ProductsList {

    static private List<Product> _productsList;

    public static List<Product> getProductsList() {
        if (_productsList == null) {
            _productsList = new ArrayList<>();
            _productsList.add(new Product(
                    "Iphone 13 pro max",
                    "https://m.media-amazon.com/images/I/61i8Vjb17SL._AC_SX679_.jpg",
                    false
            ));
            _productsList.add(new Product(
                    "Iphone 13",
                    "https://mobizil.com/wp-content/uploads/2021/09/IPhone-13.jpg",
                    false
            ));
            _productsList.add(new Product(
                    "Samsung galaxy S21",
                    "https://m.media-amazon.com/images/I/314ZQqShGtS._AC_.jpg",
                    false
            ));
            _productsList.add(new Product(
                    "Google pixel 6 pro",
                    "https://m.media-amazon.com/images/I/716n8eAia+L._AC_SX679_.jpg",
                    false
            ));
            _productsList.add(new Product(
                    "Poco f3",
                    "https://mobizil.com/wp-content/uploads/2021/03/Xiaomi-Poco-F3.jpg",
                    false
            ));
            _productsList.add(new Product(
                    "Huawei p50 pocket",
                    "https://mobizil.com/wp-content/uploads/2022/03/Huawei-P50-Pocket.jpg",
                    false
            ));
            _productsList.add(new Product(
                    "Samsung galaxy note 20 ultra",
                    "https://mobizil.com/wp-content/uploads/2020/08/Samsung-Galaxy-Note-20-Ultra.jpg",
                    false
            ));
            _productsList.add(new Product(
                    "Xiaomi 12 pro",
                    "https://mobizil.com/wp-content/uploads/2022/06/Xiaomi-12-Pro.jpg",
                    false
            ));
            _productsList.add(new Product(
                    "Iphone 11",
                    "https://mobizil.com/wp-content/uploads/2019/09/Apple-iPhone-11.jpg",
                    false
            ));
            _productsList.add(new Product(
                    "Iphone X",
                    "https://mobizil.com/wp-content/uploads/2018/09/iphone-xs.jpg",
                    false
            ));
            _productsList.add(new Product(
                    "Xiaomi a3",
                    "https://www.geekmall.eu/6635-large_default/xiaomi-mi-a3-464gb-androidone-white.jpg",
                    false
            ));
        }
        return _productsList;
    }
}
