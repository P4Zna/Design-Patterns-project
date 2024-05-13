public class Admin extends Person {
    private static Admin instance;
    private Role role = Role.Admin;

    private Admin(String name, String email, String password) {
        super(name, email, password);
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
}