package com.gman.publisher;

import com.gman.Product;
import com.gman.subscriber.Subscriber;

/**
 * Created by Anton Mikhaylov on 24.11.17.
 */
public interface Publisher {
    public void subscribe(Product.Type t, Subscriber s);
    public void unsubscribe(Product.Type t, Subscriber s);
    public void notifySubscribers(Product.Type eventType);
}
