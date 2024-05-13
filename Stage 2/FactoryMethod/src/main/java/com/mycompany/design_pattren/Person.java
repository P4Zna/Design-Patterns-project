/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.design_pattren;

/**
 *
 * @author USER
 */
public interface Person {

    String getName();
    
    String getEmail();

    boolean verifyPassword(String passwordAuth);

    Person createPerson(String name, String email, String password, Role role);

    enum Role {
        Admin,
        User
    }
}
