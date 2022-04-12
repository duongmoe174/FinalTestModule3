package com.finaltest3.model;

public class Product {
    private int id;
    private String name;
    private float price;
    private int number;
    private String color;
    private String description;
    private Category category;

    public Product(int id, String name, float price, int number, String color, String description, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.color = color;
        this.description = description;
        this.category = category;
    }

    public Product(String name, float price, int number, String color, String description) {
        this.name = name;
        this.price = price;
        this.number = number;
        this.color = color;
        this.description = description;
    }

    public Product(String name, float price, int number, String color, String description, Category category) {
        this.name = name;
        this.price = price;
        this.number = number;
        this.color = color;
        this.description = description;
        this.category = category;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", number=" + number +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
