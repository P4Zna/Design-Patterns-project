/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package design_pattern;


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
