package com.gman;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Created by Anton Mikhaylov on 24.11.17.
 */
@Data
@AllArgsConstructor
@ToString
public class Product {
    private String name;
    private int price;
    private Type type;


    public static enum Type {

        COMPUTER(1), SMARTPHONE(2), CAMERA(3);

        private int id;

        Type(int id) {
            this.id = id;
        }

        public static Type getById(int id) {
            for (Type type : Type.values()) {
                if (id == type.id) {
                    return type;
                }
            }
            return null;
        }
    }
}
