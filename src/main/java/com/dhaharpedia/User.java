package com.dhaharpedia;

// this is how user is defined
public class User {
    // attributes
    private String noHp;
    private String username;
    private String password;
    private String food_fav;
    private String role;

    // constructor
    public User(String noHp, String username, String password, String food_fav, String role) {
        this.noHp = noHp;
        this.username = username;
        this.password = password;
        this.food_fav = food_fav;
        this.role = role;
    }

    // methods

    // getter noHp
    public String getNoHp() {
        return noHp;
    }
    // getter username
    public String getUsername() {
        return username;
    }
    // getter password
    public String getPassword() {
        return password;
    }
    // getter food_favorite
    public String getFood_fav() {
        return food_fav;
    }
    // getter role
    public String getRole() {
        return role;
    }

    // setter noHp
    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
    // setter username
    public void setUsername(String username) {
        this.username = username;
    }
    // setter password
    public void setPassword(String password) {
        this.password= password;
    }
    // setter food_favorite
    public void setFood_fav(String food_fav) {
        this.food_fav = food_fav;
    }
    // setter role
    public void setRole(String role) {
        this.role = role;
    }

    // method forgot password set new password
    public void forgotPassword(String newPassword) {
        this.password = newPassword;
    }
}
