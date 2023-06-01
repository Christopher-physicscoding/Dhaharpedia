package com.dhaharpedia;
import java.util.ArrayList;

// this is database of users
public class Database {
    // attributes
    ArrayList<User> listUser = new ArrayList<User>();
    ArrayList<Restaurant> listRestaurant = new ArrayList<Restaurant>();
    
    // constructor noting just for call
    public Database() {
        // add some user
        listUser.add(new User("08123456789", "admin", "admin", "ayam", "admin"));
        listUser.add(new User("08123456789", "user", "user", "ayam", "user"));
        // add some restaurant
        listRestaurant.add(new Restaurant("Ayam Bakar Pak Boss", "Jl. Raya Bogor, No. 1, Jakarta", "08123456789", 4.5f, "Ayam Bakar", "ayam.jpg"));
        // add different restaurant
        

       
    }

    //getter listrestaurant
    public ArrayList<Restaurant> getListRestaurant() {
        return listRestaurant;
    }

    // methods to add User
    public void addUser(User user) {
        listUser.add(user);
    }
    // methods to add Restaurant
    public void addRestaurant(Restaurant restaurant) {
        listRestaurant.add(restaurant);
    }

    // method to get User
    public User getUser(String username) {
        for (User user : listUser) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    // method to sort Restaurant by rating
    public void sortRestaurant() {
        for (int i = 0; i < listRestaurant.size(); i++) {
            for (int j = 0; j < listRestaurant.size(); j++) {
                if (listRestaurant.get(i).getRating() > listRestaurant.get(j).getRating()) {
                    Restaurant temp = listRestaurant.get(i);
                    listRestaurant.set(i, listRestaurant.get(j));
                    listRestaurant.set(j, temp);
                }
            }
        }
    }

    // Method to get Restaurant by Category
    public ArrayList<Restaurant> getRestaurantByCategory(String category) {
        ArrayList<Restaurant> result = new ArrayList<Restaurant>();
        for (Restaurant restaurant : listRestaurant) {
            if (restaurant.getKategory().equals(category)) {
                result.add(restaurant);
            }
        }
        return result;
    }

    // Method to get Restaurant by Name
    public Restaurant getRestaurantByName(String name) {
        for (Restaurant restaurant : listRestaurant) {
            if (restaurant.getNama().equals(name)) {
                return restaurant;
            }
        }
        return null;
    }

    
    // method to remove restaurant by name
    public void removeRestaurantByName(String name) {
        for (Restaurant restaurant : listRestaurant) {
            if (restaurant.getNama().equals(name)) {
                listRestaurant.remove(restaurant);
            }
        }
    }
}
