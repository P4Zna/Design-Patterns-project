/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package design_pattern;

/**
 *
 * @author USER
 */
public class Admin implements Person {
    private static Admin instance;
    private Role role = Role.Admin;
    private String name;
    private String email;
    private String password;

      Admin(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public static Admin getInstance(String name, String email, String password) {
        if (instance == null) {
            instance = new Admin(name, email, password);
        }
        return instance;
    }
 


    public void verifyMovie(Movie movie) {
        movie.isVerified = true;
    }

    @Override
    public String getName() {
    return name;
    }

    @Override
    public String getEmail() {
          return email;
    }

    @Override
    public boolean verifyPassword(String passwordAuth) {
return this.password.equals(password);
    }

    @Override
    public Person createPerson(String name, String email, String password, Role role) {
  throw new UnsupportedOperationException("Admin cannot create other persons.");
    }
}
