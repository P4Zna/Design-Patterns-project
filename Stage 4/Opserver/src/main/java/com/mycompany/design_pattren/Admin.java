package com.mycompany.design_pattren;

/**
 *
 * @author USER
 */
public class Admin implements Person,MovieObserver {
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
    public void addPerson(Person person) {
        // Admin cannot add other persons
        throw new UnsupportedOperationException("Admin cannot add other persons.");
    }
    @Override
    public void removePerson(Person person) {
        // Admin cannot remove other persons
        throw new UnsupportedOperationException("Admin cannot remove other persons.");
    }
    @Override
    public Person getChild(int index) {
        // Admin has no children
        return null;
    }
    @Override
    public Person createPerson(String name, String email, String password, Role role) {
  throw new UnsupportedOperationException("Admin cannot create other persons.");
    }

    String getRole() {
        return "Admin";
    }


    @Override
    public void update(Movie movie) {
        if (movie.isVerified()) {
            System.out.println(name + ": Movie '" + movie.getTitle() + "' has been verified.");
        } else {
            System.out.println(name + ": Movie '" + movie.getTitle() + "' is not verified.");
        }
    }
}
