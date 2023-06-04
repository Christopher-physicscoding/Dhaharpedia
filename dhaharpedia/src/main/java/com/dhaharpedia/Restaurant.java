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
    private byte[] Gambar;
    private ArrayList<Makanan> menu;
    private ArrayList<Review> review;
    private int jumlahorang;

    // constructor
    public Restaurant(String nama, String alamat, String noHp, float rating, String kategory, byte[] Gambar, int jumlahorang) {
        this.nama = nama;
        this.alamat = alamat;
        this.noHp = noHp;
        this.rating = rating;
        this.kategory = kategory;
        this.Gambar = Gambar;
        this.jumlahorang = jumlahorang;
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
    // setter and getter jumlahorang
    public int getJumlahorang() {
        return jumlahorang;
    }
    public void setJumlahorang(int jumlahorang) {
        this.jumlahorang = jumlahorang;
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
    public byte[] getGambar() {
        return Gambar;
    }
    public void setGambar(byte[] Gambar) {
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
   
   
    // get menu by name
    public Makanan getMenuByName(String name) {
        for (Makanan makanan : this.menu) {
            if (makanan.getName().equals(name)) {
                return makanan;
            }
        }
        return null;
    }
    
    // remove menu
    public void removeMenu(String name) {
        for (Makanan makanan : this.menu) {
            if (makanan.getName().equals(name)) {
                this.menu.remove(makanan);
                break;
            }
        }
    }
    
   
    public void editMenu(Makanan makanan, String name) {
        System.out.println("hello dunia");
        //edit menu
        for (Makanan makanan1 : this.menu) {
            if (makanan1.getName().equals(name)) {
                this.menu.set(this.menu.indexOf(makanan1), makanan);
                break;
            }
        }
    }
    // show all menu
    public void showAllMenu() {
        for (Makanan makanan : this.menu) {
            System.out.println("Nama: " + makanan.getName());
            System.out.println("Harga: " + makanan.getPrice());
            System.out.println("Deskripsi: " + makanan.getDescription());
            System.out.println("Kategori: " + makanan.getCategory());
        }
    }
}
