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
