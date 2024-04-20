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
