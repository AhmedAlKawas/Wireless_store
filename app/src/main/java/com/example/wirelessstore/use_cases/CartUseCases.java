package com.example.wirelessstore.use_cases;

public class CartUseCases {

    GetCartItems getCartItems;
    InsertCartItem insertCartItem;
    RemoveCartItem removeCartItem;

    public CartUseCases(GetCartItems getCartItems, InsertCartItem insertCartItem, RemoveCartItem removeCartItem) {
        this.getCartItems = getCartItems;
        this.insertCartItem = insertCartItem;
        this.removeCartItem = removeCartItem;
    }

    public GetCartItems getGetCartItems() {
        return getCartItems;
    }

    public InsertCartItem getInsertCartItem() {
        return insertCartItem;
    }

    public RemoveCartItem getRemoveCartItem() {
        return removeCartItem;
    }

    public CartUseCases() {

    }
}
