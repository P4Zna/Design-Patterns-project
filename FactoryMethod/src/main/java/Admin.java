public class Admin implements Person {
    private String name;
    private String email;
    private String password;

    public Admin(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean verifyPassword(String password) {
        return this.password.equals(password);
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
    public Person createPerson(String name, String email, String password, Role role) {
        throw new UnsupportedOperationException("Admin cannot create other persons.");
    }
    
    public void verifyMovie(Movie movie) {
      movie.isVerified = true;
  }



}
