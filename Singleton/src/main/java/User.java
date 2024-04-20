import java.util.ArrayList;

public class User extends Person {
    private static User instance;
    private static int id = 1;
    int userID;
    static Integer reviewCount = 0;
    private ArrayList<Review> reviews = new ArrayList<>();

    private User(String name, String email, String password) {
        super(name, email, password);
        Role role = Role.User;
        this.userID = id++;
    }

    public static User getInstance(String name, String email, String password) {
        if (instance == null) {
            instance = new User(name, email, password);
        }
        return instance;
    }

    public void addReview(Movie movie, Review review) {
        ++reviewCount;

        if (!isReviewedAlready(movie)) {
            reviews.add(review);
            movie.reviews.add(review);
            System.out.println("Reviewed SUCCESSFULLY");
        } else {
            System.out.println("You already reviewed this movie");
        }
    }

    public void listReviewsByUser(User user) {
        for (Review r : reviews) {
            System.out.println(user.name + " has reviewed " + r.movie.title + " with " + r.reviewScore + " rating");
        }
    }

    public Boolean isReviewedAlready(Movie movie) {
        if (reviews != null) {
            for (Review review : reviews) {
                if (review.movie.equals(movie)) {
                    return true;
                }
            }
        }
        return false;
    }
}