package com.gman;

import com.gman.publisher.Shop;
import com.gman.subscriber.CameraBuyer;
import com.gman.subscriber.ComputerBuyer;
import com.gman.subscriber.SmartphoneBuyer;
import com.gman.subscriber.Subscriber;

/**
 * Created by Anton Mikhaylov on 23.11.17.
 */
public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();


        Subscriber cameraBuyer = new CameraBuyer(shop);
        Subscriber smartphoneBuyer = new SmartphoneBuyer(shop);
        Subscriber computerBuyer = new ComputerBuyer(shop);

        shop.subscribe(Product.Type.CAMERA, cameraBuyer);
        shop.subscribe(Product.Type.SMARTPHONE, smartphoneBuyer);
        shop.subscribe(Product.Type.COMPUTER, computerBuyer);

        shop.logistics();
    }
}
