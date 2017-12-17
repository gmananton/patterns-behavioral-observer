package com.gman;

import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anton Mikhaylov on 24.11.17.
 */
@Getter
public class ProductCatalog {
    private final Map<Product.Type, List<String>> catalog = new HashMap<>();

    public ProductCatalog() {
        List<String> smartphones = Arrays.asList(new String[]{
                "iPhone 7",
                "iPhone 7 Plus",
                "iPhone 8",
                "iPhone 8 Plus",
                "iPhone X",
                "Galaxy 8",
                "Pixel 2XL"
        });
        List<String> computers = Arrays.asList(new String[]{
                "Asus",
                "Acer",
                "MacBook Pro",
                "MacBook Air",
                "MacPro",
                "iMac"
        });
        List<String> cameras = Arrays.asList(new String[]{
                "Canon 6D",
                "Canon 5d MarkIV",
                "Canon 7D",
                "Nikon D810",
                "Canon 750D"
        });

        catalog.put(Product.Type.COMPUTER, computers);
        catalog.put(Product.Type.SMARTPHONE, smartphones);
        catalog.put(Product.Type.CAMERA, cameras);
    }

}


