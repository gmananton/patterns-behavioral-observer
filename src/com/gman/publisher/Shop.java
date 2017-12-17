package com.gman.publisher;

import com.gman.Product;
import com.gman.ProductCatalog;
import lombok.Data;
import com.gman.subscriber.Subscriber;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Created by Anton Mikhaylov on 24.11.17.
 */
@Data
public class Shop implements Publisher {

    private Map<Product.Type, List<Subscriber>> subscribers = new HashMap<>();
    private Map<Product.Type, Product> productsInStock = new HashMap<>();

    @Override
    public void subscribe(Product.Type t, Subscriber s) {
        List<Subscriber> currProductSubscribers = subscribers.get(t);
        if (currProductSubscribers == null) {
            currProductSubscribers = new ArrayList<>();
        }

        currProductSubscribers.add(s);
        subscribers.put(t, currProductSubscribers);
    }

    @Override
    public void unsubscribe(Product.Type t, Subscriber s) {
        List<Subscriber> subscribersForProductType = subscribers.get(t);
        if (subscribersForProductType != null && !subscribersForProductType.isEmpty()) {
            subscribersForProductType.remove(s);
        }
    }

    /**
     * Уведомление заинтересованных покупателей о конкретном виде товара
     */
    @Override
    public void notifySubscribers(Product.Type eventType) {
        List<Subscriber> productSubs = subscribers.get(eventType);
        if (productSubs != null) {
            productSubs.forEach(s -> s.update());
        }
    }


    /**
     * Рандомно генерирует несколько товаров
     */
    public void logistics() {
        Map<Product.Type, List<String>> catalog = new ProductCatalog().getCatalog();
        int minId = 1;
        int maxId = 3;

        int minPrice = 100;
        int maxPrice = 1000;


        for (int i = 0 ; i < 2; i ++) {
            int randomId = ThreadLocalRandom.current().nextInt(minId, maxId + 1);
            int randomPrice = ThreadLocalRandom.current().nextInt(minPrice, maxPrice);
            Product.Type type = Product.Type.getById(randomId);

            String name = catalog.get(type).get(randomId);

            Product product = new Product(name, randomPrice, type);
            productsInStock.put(product.getType(), product);

            System.out.println("\nNEW PRODUCTS IN OUR STOCK! -- " + product);

            notifySubscribers(type);
        }
    }

    public Map<Product.Type, Product> getProductsInStock() {
        return productsInStock;
    }


}
