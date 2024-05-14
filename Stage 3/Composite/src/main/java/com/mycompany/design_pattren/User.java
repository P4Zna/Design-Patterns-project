/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.design_pattren;

/**
 *
 * @author USER
 */
import java.util.ArrayList;

public class User implements Person {
    private static User instance;
    private static int id = 1;
    int userID;
    static Integer reviewCount = 0;
    private ArrayList<Review> reviews = new ArrayList<>();
    private String  password;
    public String  name;
    public String  email;

 User(String name, String email, String password) {
      
    }

    public static User getInstance(String name, String email, String password) {
        if (instance == null) {
            instance = new User(name, email, password);
        }
        return instance;
    }

  @Override
    public Person createPerson(String name, String email, String password, Person.Role role) {
        throw new UnsupportedOperationException("A User instance cannot create other Person objects.");
    }

    @Override
    public boolean verifyPassword(String passwordAuth) {
        return password.equals(passwordAuth);
    }

    public int getUserID() {
        return userID;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void addReview(Movie movie, Review review) {
        if (!isReviewedAlready(movie)) {
            reviews.add(review);
            movie.reviews.add(review);
            System.out.println("Reviewed SUCCESSFULLY");
            reviewCount++; // Increment reviewCount when a review is added
        } else {
            System.out.println("You already reviewed this movie");
        }
    }

    public void listReviewsByUser() {
        for (Review review : reviews) {
            System.out.println(name + " has reviewed " + review.movie.title + " with " + review.reviewScore + " rating");
        }
    }

    public boolean isReviewedAlready(Movie movie) {
        for (Review review : reviews) {
            if (review.movie.equals(movie)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addPerson(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removePerson(Person person) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Person getChild(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}