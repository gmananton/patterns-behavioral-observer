package com.gman.subscriber;

import com.gman.Product;
import com.gman.publisher.Shop;

/**
 * Created by Anton Mikhaylov on 24.11.17.
 */
public class ComputerBuyer implements Subscriber {
    private final String name = "Computer buyer";
    private final Product.Type productType = Product.Type.COMPUTER;
    private Shop shop;

    public ComputerBuyer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void update() {
        System.out.println(
                updateMsg
                        .replace("{name}", name)
                        .replace("{productType}", productType.toString().toLowerCase())
                        .replace("{product}", shop.getProductsInStock().get(productType).toString())
        );
    }
}
