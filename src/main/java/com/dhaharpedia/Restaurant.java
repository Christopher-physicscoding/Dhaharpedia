package com.dhaharpedia;

import java.util.ArrayList;

// this is how restaurant is defined
public class Restaurant {
    //  attributes
    private String nama;
    private String alamat;
    private String noHp;
    private float rating;
    private String kategory;
    private String Gambar;
    private ArrayList<Makanan> menu;
    private ArrayList<Review> review;

    // constructor
    public Restaurant(String nama, String alamat, String noHp, float rating, String kategory, String Gambar) {
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
        this.rating = rating;
        this.kategory = kategory;
        this.Gambar = Gambar;
        this.menu = new ArrayList<Makanan>();
        this.review = new ArrayList<Review>();
    }

    // methods
    // setter and getter nama
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    // setter and getter alamat
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    // setter and getter noHp   
    public String getNoHp() {
        return noHp;
    }
    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
    // setter and getter rating
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
    // setter and getter kategory
    public String getKategory() {
        return kategory;
    }
    public void setKategory(String kategory) {
        this.kategory = kategory;
    }
    // setter and getter Gambar
    public String getGambar() {
        return Gambar;
    }
    public void setGambar(String Gambar) {
        this.Gambar = Gambar;
    }
    // setter and getter menu
    public ArrayList<Makanan> getMenu() {
        return menu;
    }
    public void setMenu(ArrayList<Makanan> menu) {
        this.menu = menu;
    }
    // setter and getter review
    public ArrayList<Review> getReview() {
        return review;
    }
    public void setReview(ArrayList<Review> review) {
        this.review = review;
    }
    // add menu
    public void addMenu(Makanan makanan) {
        this.menu.add(makanan);
    }
    // add review
    public void addReview(Review review) {
        this.review.add(review);
    }
    // remove menu
    public void removeMenu(Makanan makanan) {
        this.menu.remove(makanan);
    }
    // remove review
    public void removeReview(Review review) {
        this.review.remove(review);
    }
    // get menu by name
    public Makanan getMenuByName(String name) {
        for (Makanan makanan : this.menu) {
            if (makanan.getName().equals(name)) {
                return makanan;
            }
        }
        return null;
    }
    // get review by name
    public Review getReviewByName(String name) {
        for (Review review : this.review) {
            if (review.getNama().equals(name)) {
                return review;
            }
        }
        return null;
    }
    // get menu by category
    public ArrayList<Makanan> getMenuByCategory(String category) {
        ArrayList<Makanan> result = new ArrayList<Makanan>();
        for (Makanan makanan : this.menu) {
            if (makanan.getCategory().equals(category)) {
                result.add(makanan);
            }
        }
        return result;
    }
    // get review by rating
    public ArrayList<Review> getReviewByRating(int rating) {
        ArrayList<Review> result = new ArrayList<Review>();
        for (Review review : this.review) {
            if (review.getRating() == rating) {
                result.add(review);
            }
        }
        return result;
    }
    // sort menu by price   
    public void sortMenuByPrice() {
        for (int i = 0; i < this.menu.size(); i++) {
            for (int j = 0; j < this.menu.size() - 1; j++) {
                if (this.menu.get(j).getPrice() > this.menu.get(j + 1).getPrice()) {
                    Makanan temp = this.menu.get(j);
                    this.menu.set(j, this.menu.get(j + 1));
                    this.menu.set(j + 1, temp);
                }
            }
        }
    }
    // search menu by name
    public ArrayList<Makanan> searchMenuByName(String name) {
        ArrayList<Makanan> result = new ArrayList<Makanan>();
        for (Makanan makanan : this.menu) {
            if (makanan.getName().contains(name)) {
                result.add(makanan);
            }
        }
        return result;
    }


    
    
}
