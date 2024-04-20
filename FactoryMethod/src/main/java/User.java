import java.util.ArrayList;

public class User implements Person {
    private int userID;
    private String name;
    private String email;
    private String password;
    private ArrayList<Review> reviews = new ArrayList<>();
    private int reviewCount; // Add reviewCount field
    private static int id = 1;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userID = id++;
        this.reviewCount = 0; // Initialize reviewCount to 0
    }

    @Override
    public Person createPerson(String name, String email, String password, Person.Role role) {
        throw new UnsupportedOperationException("A User instance cannot create other Person objects.");
    }

    @Override
    public boolean verifyPassword(String passwordAuth) {
        return password.equals(passwordAuth);
    }

    public int getUserID() {
        return userID;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void addReview(Movie movie, Review review) {
        if (!isReviewedAlready(movie)) {
            reviews.add(review);
            movie.reviews.add(review);
            System.out.println("Reviewed SUCCESSFULLY");
            reviewCount++; // Increment reviewCount when a review is added
        } else {
            System.out.println("You already reviewed this movie");
        }
    }

    public void listReviewsByUser() {
        for (Review review : reviews) {
            System.out.println(name + " has reviewed " + review.movie.title + " with " + review.reviewScore + " rating");
        }
    }

    public boolean isReviewedAlready(Movie movie) {
        for (Review review : reviews) {
            if (review.movie.equals(movie)) {
                return true;
            }
        }
        return false;
    }
}
