package com.dhaharpedia;

public class Makanan {
    // attributes
    private String name;
    private String description;
    private double price;
    private String category;
    private byte[] Gambar;
    
    //constructor
    public Makanan(String name, String description, Double price, String category, byte[] Gambar) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.Gambar = Gambar;
    }

    // methods

    //getter  and setter name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //getter  and setter description
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    //getter  and setter price
    public double getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    //getter  and setter category
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    //getter  and setter Gambar
    public byte[] getGambar() {
        return Gambar;
    }
    public void setGambar(byte[] Gambar) {
        this.Gambar = Gambar;
    }
}
