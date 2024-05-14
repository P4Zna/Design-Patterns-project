/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.design_pattren;

/**
 *
 * @author USER
 */


// Composite pattern integrated into Person interface

public interface Person {

    String getName();
    
    String getEmail();

    boolean verifyPassword(String passwordAuth);
       void addPerson(Person person); // Method to add a person to the composite
    void removePerson(Person person); // Method to remove a person from the composite
    Person getChild(int index); // Method to get a child person from the composite

    Person createPerson(String name, String email, String password, Role role);

    enum Role {
        Admin,
        User
    }
}
