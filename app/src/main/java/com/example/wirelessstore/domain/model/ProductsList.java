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
                    "https://www.google.com/imgres?imgurl=https%3A%2F%2Fsmartkoshk.com%2Fwp-content%2Fuploads%2F2021%2F09%2FiPhone-13-Pro-Max-Egypt-1.png&imgrefurl=https%3A%2F%2Fsmartkoshk.com%2Far%2Fproduct%2Fapple-iphone-13-pro-max%2F&tbnid=DT4s3F6lmP_muM&vet=12ahUKEwi9ibmZ4qf5AhVThHMKHXqXCv8QMygCegUIARDuAQ..i&docid=3CluZRJuCXqoWM&w=482&h=614&q=Iphone%2013%20pro%20max&ved=2ahUKEwi9ibmZ4qf5AhVThHMKHXqXCv8QMygCegUIARDuAQ",
                    false
            ));
            _productsList.add(new Product(
                    "Iphone 13",
                    "https://www.google.com/imgres?imgurl=https%3A%2F%2Ftradelinestores.s3.amazonaws.com%2Fmedia%2Fproduct_images%2F8beed3df-488d-4c8a-b808-bd2ef6c2fe86.png&imgrefurl=https%3A%2F%2Fwww.tradelinestores.com%2Fshop%2FiPhone%2FiPhone-13%2FiPhone-13&tbnid=JZeD9MtKP-VTzM&vet=12ahUKEwjC8vmw4qf5AhVXwoUKHSsPBhUQMygAegUIARDTAQ..i&docid=SknPay-gRvrteM&w=500&h=500&q=Iphone%2013&ved=2ahUKEwjC8vmw4qf5AhVXwoUKHSsPBhUQMygAegUIARDTAQ",
                    false
            ));
            _productsList.add(new Product(
                    "Samsung 21",
                    "https://www.google.com/imgres?imgurl=https%3A%2F%2Fimages.samsung.com%2Fis%2Fimage%2Fsamsung%2Fp6pim%2Feg%2Fgalaxy-s21%2Fgallery%2Feg-galaxy-s21-5g-g991-sm-g991bzadmea-360317246&imgrefurl=https%3A%2F%2Fwww.samsung.com%2Feg%2Fsmartphones%2Fgalaxy-s21-5g%2Fbuy%2F&tbnid=n1SdVaT_PA6b8M&vet=12ahUKEwiC3ODB4qf5AhUJBRoKHZVABxoQMygBegUIARDhAQ..i&docid=Y74q2ezGFoayJM&w=330&h=330&q=Samsung%2021&ved=2ahUKEwiC3ODB4qf5AhUJBRoKHZVABxoQMygBegUIARDhAQ",
                    false
            ));
            _productsList.add(new Product(
                    "Google pixel 6 pro",
                    "https://www.google.com/imgres?imgurl=https%3A%2F%2Fm.media-amazon.com%2Fimages%2FI%2F41kLC3Dn-3L._AC_SY780_.jpg&imgrefurl=https%3A%2F%2Fwww.amazon.eg%2F-%2Fen%2FGoogle-Pixel-Dual-SIM-256GB-12GB%2Fdp%2FB09HZGGSFR&tbnid=7p4X__0H2TfcUM&vet=12ahUKEwjB6bTN4qf5AhUKqRoKHfEiDRsQMygAegUIARDMAQ..i&docid=tFnuZrohTPyt4M&w=327&h=373&q=Google%20pixel%206%20pro&ved=2ahUKEwjB6bTN4qf5AhUKqRoKHfEiDRsQMygAegUIARDMAQ",
                    false
            ));
            _productsList.add(new Product(
                    "Poco f3",
                    "https://www.google.com/imgres?imgurl=https%3A%2F%2Fmobizil.com%2Fwp-content%2Fuploads%2F2021%2F03%2FXiaomi-Poco-F3.jpg&imgrefurl=https%3A%2F%2Fmobizil.com%2Fxiaomi-poco-f3-specs%2F&tbnid=Xs3GsR2Xh8IDKM&vet=12ahUKEwjvqPfa4qf5AhVLKxoKHap3A7oQMygAegUIARC4AQ..i&docid=7NPHlOV5uFB3bM&w=500&h=500&q=Poco%20f3&ved=2ahUKEwjvqPfa4qf5AhVLKxoKHap3A7oQMygAegUIARC4AQ",
                    false
            ));
            _productsList.add(new Product(
                    "Huawei p50 pocket",
                    "https://www.google.com/imgres?imgurl=https%3A%2F%2Fgizmobo.com%2Fwp-content%2Fuploads%2F2021%2F12%2Fhuawei-p50-pocket-front-display.webp&imgrefurl=https%3A%2F%2Fgizmobo.com%2Far%2Fjihaz%2Fhuawei-p50-pocket%2F&tbnid=XnehzM6ogD-wLM&vet=12ahUKEwiijdHk4qf5AhUzgHMKHUpWAA0QMygAegUIARCfAQ..i&docid=RqS6zGWE5Cl8xM&w=500&h=500&q=Huawei%20p50%20pocket&ved=2ahUKEwiijdHk4qf5AhUzgHMKHUpWAA0QMygAegUIARCfAQ",
                    false
            ));
            _productsList.add(new Product(
                    "Samsung galaxy note 20 ultra",
                    "https://www.google.com/imgres?imgurl=https%3A%2F%2Fm.media-amazon.com%2Fimages%2FI%2F41iiYWoicrL._AC_SY780_.jpg&imgrefurl=https%3A%2F%2Fwww.amazon.eg%2F-%2Fen%2FSamsung-Galaxy-Mobile-Hybrid-4500mAh%2Fdp%2FB091NY1VCB&tbnid=S3i51Xbtm6Ue5M&vet=12ahUKEwisg6zv4qf5AhX1gc4BHXerA4wQMygAegUIARDjAQ..i&docid=jG_TsqdlaoWTPM&w=383&h=500&q=Samsung%20galaxy%20note%2020%20ultra&ved=2ahUKEwisg6zv4qf5AhX1gc4BHXerA4wQMygAegUIARDjAQ",
                    false
            ));
            _productsList.add(new Product(
                    "Xiaomi 12 pro",
                    "https://www.google.com/imgres?imgurl=https%3A%2F%2Fi01.appmifile.com%2Fwebfile%2Fglobalimg%2FIris%2Fxiaomi-12-pro-black.png&imgrefurl=https%3A%2F%2Fwww.mi.com%2Fuk%2Fxiaomi-12-pro%2F&tbnid=wh4rfgnq8FcR3M&vet=12ahUKEwjLtpP64qf5AhXC8IUKHZGPAFwQMygAegUIARCvAQ..i&docid=p0NicidSxKknyM&w=1600&h=1600&q=Xiaomi%2012%20pro&ved=2ahUKEwjLtpP64qf5AhXC8IUKHZGPAFwQMygAegUIARCvAQ",
                    false
            ));
            _productsList.add(new Product(
                    "Iphone 11",
                    "https://www.google.com/imgres?imgurl=https%3A%2F%2Fm.media-amazon.com%2Fimages%2FI%2F41dxRWxEFPL._AC_SY780_.jpg&imgrefurl=https%3A%2F%2Fwww.amazon.eg%2F-%2Fen%2FApple-iPhone-Facetime-Physical-Dual%2Fdp%2FB07Y7HR6GS&tbnid=x194xFiLXUq7WM&vet=12ahUKEwiIpqOG46f5AhXCgc4BHSntAfAQMygAegUIARDhAQ..i&docid=qBkOOEFPsPpWlM&w=300&h=428&q=Iphone%2011&ved=2ahUKEwiIpqOG46f5AhXCgc4BHSntAfAQMygAegUIARDhAQ",
                    false
            ));
            _productsList.add(new Product(
                    "Iphone X",
                    "https://www.google.com/imgres?imgurl=https%3A%2F%2Fm.media-amazon.com%2Fimages%2FI%2F61nlT53kRKL.jpg&imgrefurl=https%3A%2F%2Fwww.amazon.eg%2F-%2Fen%2FApple-Iphone-Facetime-Space-Single%2Fdp%2FB075LXNK24&tbnid=sFj662bt8tnfhM&vet=12ahUKEwjJt-KP46f5AhUJhM4BHeG2C8AQMygBegUIARDdAQ..i&docid=gTbfvaaSytYzzM&w=1100&h=1500&q=Iphone%20X&ved=2ahUKEwjJt-KP46f5AhUJhM4BHeG2C8AQMygBegUIARDdAQ",
                    false
            ));
            _productsList.add(new Product(
                    "Xiaomi a3",
                    "https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.geekmall.eu%2F6635-large_default%2Fxiaomi-mi-a3-464gb-androidone-white.jpg&imgrefurl=https%3A%2F%2Fwww.geekmall.eu%2Fen%2Fxiaomi-mi-a3-464gb-androidone-white-1128.html&tbnid=4NxDM35HvIlgIM&vet=12ahUKEwj6sPSY46f5AhUIhxoKHbhxBdUQMygBegUIARC3AQ..i&docid=DR3AqWtBO2WckM&w=520&h=520&q=Xiaomi%20a3&ved=2ahUKEwj6sPSY46f5AhUIhxoKHbhxBdUQMygBegUIARC3AQ",
                    false
            ));
        }
        return _productsList;
    }
}
