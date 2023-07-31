package com.projectandroid03;

public class Product {
    private int imageResource;
    private int id;
    private String name;
    private String price;

    public Product(int id, int imageResource, String name, String price) {
        this.id = id;
        this.imageResource = imageResource;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getImageResource() {
        return imageResource;
    }
    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}