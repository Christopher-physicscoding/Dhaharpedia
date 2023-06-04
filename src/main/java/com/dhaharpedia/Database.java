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
        listRestaurant.add(new Restaurant("Ayam Bakar Pak Boss", "Jl. Raya Bogor, No. 1, Jakarta", "08123456789", 4.5f, "Chicken", null, 200));
        Restaurant restaurant2 = new Restaurant("Pizza Delight", "Jl. Sudirman, No. 10, Jakarta", "08234567890", 4.2f, "Italian", null, 150);
         // add makan on different Ayam Bakar Pak Boss
        restaurant2.addMenu(new Makanan("Ayam Bakar", "Ayam Bakar dengan bumbu khas", 20000.0, "Chicken", null));
        listRestaurant.add(restaurant2);
        Restaurant restaurant3 = new Restaurant("Sushi Tei", "Jl. Thamrin, No. 20, Jakarta", "08345678901", 4.7f, "Japanese", null, 100);
        listRestaurant.add(restaurant3);
        Restaurant restaurant4 = new Restaurant("Bakmi GM", "Jl. Sudirman, No. 30, Jakarta", "08456789012", 4.3f, "Chinese", null, 50);
        listRestaurant.add(restaurant4);
        Restaurant restaurant5 = new Restaurant("Bakso Malang", "Jl. Sudirman, No. 40, Jakarta", "08567890123", 4.1f, "Indonesian", null, 100);
        listRestaurant.add(restaurant5);
        Restaurant restaurant6 = new Restaurant("Burger King", "Jl. Sudirman, No. 50, Jakarta", "08678901234", 4.4f, "American", null, 200);
        listRestaurant.add(restaurant6);
        Restaurant restaurant7 = new Restaurant("KFC", "Jl. Sudirman, No. 60, Jakarta", "08789012345", 4.6f, "Chicken", null, 200);
        listRestaurant.add(restaurant7);
        Restaurant restaurant8 = new Restaurant("McDonald", "Jl. Sudirman, No. 70, Jakarta", "08890123456", 4.8f, "American", null, 200);
        listRestaurant.add(restaurant8);
        //this.removeRestaurantByName("McDonald");

        // add restaurat 9
        Restaurant restaurant9 = new Restaurant("Bakso", "Jl. Sudirman, No. 40, Jakarta", "08567890123", 4.1f, "Indonesian", null, 100);
        restaurant9.addMenu(new Makanan("Bakso", "Bakso Malang", 20000.0, "Indonesian", null));
        restaurant9.addMenu(new Makanan("Mie Ayam", "Mie Ayam Malang", 20000.0, "Indonesian", null));
        restaurant9.addMenu(new Makanan("Nasi Goreng", "Nasi Goreng Malang", 20000.0, "Indonesian", null));
        restaurant9.addMenu(new Makanan("Soto Ayam", "Soto Ayam Malang", 20000.0, "Indonesian", null));
        restaurant9.addMenu(new Makanan("Soto Ayam", "Soto Ayam Malang", 20000.0, "Indonesian", null));
        restaurant9.addMenu(new Makanan("Soto Ayam", "Soto Ayam Malang", 20000.0, "Indonesian", null));
        restaurant9.addMenu(new Makanan("Soto Ayam", "Soto Ayam Malang", 20000.0, "Indonesian", null));
        restaurant9.addMenu(new Makanan("Soto Ayam", "Soto Ayam Malang", 20000.0, "Indonesian", null));
        restaurant9.addMenu(new Makanan("Soto Ayam", "Soto Ayam Malang", 20000.0, "Indonesian", null));


        // add restaurat 10
        Restaurant restaurant10 = new Restaurant("Malang", "Jl. Sudirman, No. 40, Jakarta", "08567890123", 4.1f, "Indonesian", null, 100);
        restaurant10.addMenu(new Makanan("Bakso", "Bakso Malang", 20000.0, "Indonesian", null));
        restaurant10.addMenu(new Makanan("Mie Ayam", "Mie Ayam Malang", 20000.0, "Indonesian", null));
        restaurant10.addMenu(new Makanan("Nasi Goreng", "Nasi Goreng Malang", 20000.0, "Indonesian", null));
        restaurant10.addMenu(new Makanan("Soto Ayam", "Soto Ayam Malang", 20000.0, "Indonesian", null));
        restaurant10.addMenu(new Makanan("Soto Ayam", "Soto Ayam Malang", 20000.0, "Indonesian", null));
        listRestaurant.add(restaurant9);
        listRestaurant.add(restaurant10);
        
        // add restaurat 11
        Restaurant restaurant11 = new Restaurant("Bakso Malang", "Jl. Sudirman, No. 40, Jakarta", "08567890123", 4.1f, "Indonesian", null, 100);
        listRestaurant.add(restaurant11);

        //add restaurat 12
        Restaurant restaurant12 = new Restaurant("Baksong", "Jl. Sudirman, No. 40, Jakarta", "08567890123", 4.1f, "Indonesian", null, 100);
        listRestaurant.add(restaurant12);

        //add restaurat 13
        Restaurant restaurant13 = new Restaurant("Bakg", "Jl. Sudirman, No. 40, Jakarta", "08567890123", 4.1f, "Indonesian", null, 100);
        listRestaurant.add(restaurant13);

        //add restaurat 14
        Restaurant restaurant14 = new Restaurant("Balang", "Jl. Sudirman, No. 40, Jakarta", "08567890123", 4.1f, "Indonesian", null, 100);
        listRestaurant.add(restaurant14);

        //add restaurat 15
        Restaurant restaurant15 = new Restaurant("Baka0", "Jl. Sudirman, No. 40, Jakarta", "08567890123", 4.1f, "Indonesian", null, 100);
        listRestaurant.add(restaurant15);


       

        

       
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
    //method to edit restaurant
    public void editRestaurant(Restaurant restaurant, String name) {
        for (Restaurant restaurant1 : listRestaurant) {
            if (restaurant1.getNama().equals(name)) {
                listRestaurant.set(listRestaurant.indexOf(restaurant1), restaurant);
                break;
            }
        }
    }

    
    // method to remove restaurant by name
    public void removeRestaurantByName(String name) {
        for (Restaurant restaurant : listRestaurant) {
            if (restaurant.getNama().equals(name)) {
                listRestaurant.remove(restaurant);
                break;
            }
        }
    }    
    
}
