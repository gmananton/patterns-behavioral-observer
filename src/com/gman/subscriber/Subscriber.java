package com.gman.subscriber;


/**
 * Created by Anton Mikhaylov on 24.11.17.
 */
public interface Subscriber {
    final String updateMsg = "My name is {name} and I just got an update about new {productType} in store! : {product}";
    public void update();
}
