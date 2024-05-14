/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.design_pattren;

/**
 *
 * @author USER
 */
public class PersonFactory {
    public static Person createPerson(String name, String email, String password, String role) {
        if ("Admin".equalsIgnoreCase(role)) {
            return new Admin(name, email, password);
        } else if ("User".equalsIgnoreCase(role)) {
            return new User(name, email, password);
        }
        // Handle other roles or return default
        return null;
    }
}