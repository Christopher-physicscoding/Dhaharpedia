package com.dhaharpedia;

public class Review {
    private String nama;
    private String review;
    private int rating;

    public Review(String nama, String review, int rating) {
        this.nama = nama;
        this.review = review;
        this.rating = rating;
    }

    public String getNama() {
        return nama;
    }

    public String getReview() {
        return review;
    }

    public int getRating() {
        return rating;
    }
    
}
