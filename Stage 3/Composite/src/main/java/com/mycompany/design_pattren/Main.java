
package com.mycompany.design_pattren;

/**
 *
 * @author USER
 */
import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<Movie> movies;
    static ArrayList<User> users;
    static ArrayList<Admin> admins;

    public static void main(String arr[]) {
        movies = new ArrayList<>();
        users = new ArrayList<>();
        admins = new ArrayList<>();
        
        Admin admin = new Admin("SAM", "sam@gmail.com", "samx");
        User newuser = new User("SAM", "sam@gmail.com", "samx");
        users.add(newuser);
        admins.add(admin);

        movies.add(new Movie("Lovetoday", 2022, "Tamil", "Love"));
        movies.add(new Movie("Inception", 2022, "Tamil", "Action"));
        movies.add(new Movie("Devil", 2012, "English", "Horror"));
        movies.add(new Movie("Frozen", 2020, "English", "Sci-Fi"));
        movies.add(new Movie("Kathi", 2017, "Tamil", "Action"));
        movies.add(new Movie("Friends", 2014, "English", "Comedy"));
         MovieComponent movie1 = new Movie("Lovetoday", 2022, "Tamil", "Love");
        MovieComponent movie2 = new Movie("Inception", 2022, "Tamil", "Action");
        MovieComponent movie3 = new Movie("Devil", 2012, "English", "Horror");
        MovieComponent movie4 = new Movie("Frozen", 2020, "English", "Sci-Fi");
        MovieComponent movie5 = new Movie("Kathi", 2017, "Tamil", "Action");
        MovieComponent movie6 = new Movie("Friends", 2014, "English", "Comedy");

        // Decorate movies with genre and additional information
        movie2 = new MovieGenreDecorator(movie2, "Action");
        movie3 = new MovieGenreDecorator(movie3, "Horror");
        movie4 = new MovieGenreDecorator(movie4, "Sci-Fi");
        movie5 = new MovieGenreDecorator(movie5, "Action");
        movie6 = new MovieGenreDecorator(movie6, "Comedy");

        movie2 = new MovieInfoDecorator(movie2, "Director: Christopher Nolan");
        movie3 = new MovieInfoDecorator(movie3, "Director: John Erick Dowdle");
        movie4 = new MovieInfoDecorator(movie4, "Director: Chris Buck, Jennifer Lee");
        movie5 = new MovieInfoDecorator(movie5, "Director: A.R. Murugadoss");
        movie6 = new MovieInfoDecorator(movie6, "Director: David Crane, Marta Kauffman");


      // Create an ArrayList to hold Person objects (composite)
        ArrayList<Person> persons = new ArrayList<>();
     

        // Add the Admin instance to the ArrayList
        persons.add(admin);
        
        // Accessing the composite structure
        System.out.println("Composite Person Name: " + persons.get(0).getName());

        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Welcome to MovieReview CLI Application!!!");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("1. Register User\n2. Login User\n3. List All Movies\n4. Admin Login\n5. List all reviews of a movie\n6. List all reviews given by a User\n7. List Top N movies 8.get descriiption\n. 9.rating ");
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    listMovies();
                    break;
                case 4:
                    adminLogin();
                    break;
                case 5:
                    listReviewsOfMovie();
                    break;
                case 6:
                    listReviewsByUser();
                    break;
                case 7:
                    listTopNMovies();
                    break;
                  case 8:
                    System.out.println(movie1.getDescription());
                    break;
                case 9:
                    System.out.println("Rating: " + movie1.getRating());
             case 10:
                    // Perform Admin-specific operations here
                    if (persons.get(0) instanceof Admin) {
                        Admin retrievedAdmin = (Admin) persons.get(0);
                        System.out.println("Admin Role: " + retrievedAdmin.getRole());
                    }
          

        
                default:
                    flag = false;
                    break;
            }
        }
        // Close the Scanner object after finishing its usage
        sc.close();
    }

    // Methods for various actions in the application
    private static void registerUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
      
          final String name = sc.nextLine();
                        System.out.print("Enter your email");
        
         final String email = sc.nextLine();
                        System.out.print("Enter your password");
                        final String password = sc.nextLine();
                        
                        User user = User.getInstance(name, email, password);
                        users.add(user);
    }
private static void login() {
    Person p = new Authenticate<Person>().auth(users);
   
                        if(p!=null)
                        {
                            System.out.println("Signed in sucessfully");

                            userDashboard((User)p);
                        }

                        else 
                        {
                            System.out.println("Wrong info"); 
                        }
}

    private static void adminLogin() {
        Person obj = new Authenticate<Person>().auth(admins);
        if (obj != null) {
            System.out.println("Signed in successfully");
            adminDashboard((Admin) obj);
        } else {
            System.out.println("Wrong credentials");
        }
    }

    public static void listMovie(ArrayList<Movie> movies)
    {   
        System.out.println("+-----------+-----------+-------------+------------+-------------+-----------");
        System.out.println("movie.id \t"+"title "+" \t"+" language  \t "+" "+"Year" + "\t"+"isVerifiedByAdmin"+"\t"+"Rating");
        System.out.println("+-----------+-----------+-------------+------------+-------------+-----------");
        for(Movie movie : movies )
        {   if(movie.isVerified)
            {
            System.out.println(movie.movieID+" \t"+movie.title+" \t"+movie.language+" \t"+movie.year + "   \t"+movie.isVerified+" \t"+movie.Rating());
            }
        }
 
    }

    private static void adminDashboard(Admin adminobj) 
    { 
      Boolean flag = true;
      while(flag)
      {
        System.out.println("---------------------------------------------------------------"); 
        System.out.println("################  ADMIN DASHBOARD #######################");
        System.out.println("-------------------------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("1 Verify Movies \n2 List all Movies\n3 Exit");
        int n = sc.nextInt();

        switch(n)
        {
            case 1:
                System.out.println("Enter movie ID"); 
                int id = sc.nextInt();
                Movie movieobj = findMovieByID( id);
                if(movieobj!=null)
                {
                adminobj.verifyMovie(movieobj);
                }
            case 2:
                System.out.println("+-----------+-----------+-------------+------------+-------------+-----------");
                System.out.println("movie.id   "+"isVerifiedByAdmin "+"  "+"title"+"   "+"\t\tlanguage"+" "+"\tYear" + "  "+" "+"Rating");
                System.out.println("+-----------+-----------+-------------+------------+-------------+-----------");
                for(Movie movie : movies )
                {
            
                    System.out.println(movie.movieID+"\t\t"+movie.isVerified+" \t"+" \t"+movie.title+" \t"+movie.language+" \t"+movie.year + "  \t"+movie.Rating());
                }

                break;
            case 3:
                 flag=false;
        }
      }

    }


    public static void userDashboard(User userobj)
    {   
        
        Boolean flag =true;
        while(flag)
        {
            System.out.println("---------------------------------------------------------------------------------"); 
            System.out.println("###################   USER DASHBOARD #######################");
            System.out.println("-----------------------------------------------------------------------------");
        
            Scanner sc = new Scanner(System.in);
            System.out.println("1 Add Movie \n2 Add Review \n3 List all Movies\n5 Exit");
            int n = sc.nextInt();   
        switch(n)
        {  
        case 1 : 
            sc.nextLine();
            System.out.print("Enter moviename: ");
            String moviename = sc.nextLine();

            System.out.print("Enter yearOfRelease: ");
            Integer year = sc.nextInt();
            sc.nextLine();  
            System.out.print("Enter language: ");
            String language = sc.nextLine();

            System.out.print("Enter genre");
            String genre = sc.nextLine();

            Movie movie = new Movie(moviename, year,language,genre);
            movies.add(movie);
                break;
        case 2:
            
            System.out.print("Enter the movie id to Review: ");
            int movieid = sc.nextInt();
            System.out.print("Enter Reviewscore out of 10: ");
            int score = sc.nextInt();
            if(score>10)
            {
                System.out.print("Enter value between 0-10: ");
                score = sc.nextInt();
            }

            Movie movieobj = findMovieByID(movieid );

            if(movieobj!=null&&movieobj.year<=Year.now().getValue())
            {
                userobj.addReview(movieobj,new Review(score,userobj,movieobj));
            }
            else
            {
                    System.out.println("Reason for the error");
                    System.out.println("1.User can only review Movies which have been released so far");
                    System.out.println("2.Movie id is wrong");
                
            }
            
            break;
        case 3 :

            listMovie(movies);
            break;
        case 5:
        flag=false;
            break;

        }
    }
    }

    public static Movie findMovieByID(Integer id)
    {


            for(Movie x:movies)
            {
                if(x.movieID==id)
                {
                
                return x;
                }
            }
            System.out.print("Enter correct ID");
            return null; 
    }

    public static User findUserByID(Integer id) 
    {


        for(User x:users)
        {
            if(x.getUserID()==id)
            {
            
            return x;
            }
        }
        System.out.print("Enter correct ID");
        return null; 
    }

    public static void sortbasedOnYear(int year)
    { 
        ArrayList<Movie> moviesort = movies;
        Collections.sort(moviesort, (s1, s2) ->Integer.compare(s2.Rating(), s1.Rating()));

        System.out.println("+-----------+-----------+-------------+------------+-------------+-----------");
        System.out.println("movie.id \t"+"title "+" \t"+" language  \t "+" "+"Year" + "\t"+"isVerifiedByAdmin"+"\t"+"Rating");
        System.out.println("+-----------+-----------+-------------+------------+-------------+-----------");
        for(Movie movie : moviesort )
        {   if(movie.year==year)
            {
            System.out.println(movie.movieID+" \t"+movie.title+" \t"+movie.language+" \t"+movie.year + "   \t"+movie.isVerified+" \t"+movie.Rating());
            }
        }
    }
    
    public static void sortbasedOnGenre(String genre)
    { 
        ArrayList<Movie> moviesort = movies;
        Collections.sort(moviesort, (s1, s2) ->Integer.compare(s2.Rating(), s1.Rating()));

        System.out.println("+-----------+-----------+-------------+------------+-------------+-----------");
        System.out.println("movie.id \t"+"title "+" \t"+" language  \t "+" "+"Year" + "\t"+"isVerifiedByAdmin"+"\t"+"Rating");
        System.out.println("+-----------+-----------+-------------+------------+-------------+-----------");
        for(Movie movie : moviesort )
        {   if(movie.genre==genre)
            {
            System.out.println(movie.movieID+" \t"+movie.title+" \t"+movie.language+" \t"+movie.year + "   \t"+movie.isVerified+" \t"+movie.Rating());
            }
        }
    } 



    private static void listMovies() {
        for (Movie movie : movies) {
            System.out.println(movie.title + " (" + movie.year + ")");
        }
    }

    private static void listReviewsOfMovie() {
        // Implement listing reviews of a movie
    }

    private static void listReviewsByUser() {
        // Implement listing reviews given by a user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user ID"); 
        int id = sc.nextInt();
        User userobj = findUserByID(id);
        if (userobj != null) {
            userobj.listReviewsByUser();
        } else {
            System.out.println("User not found");
        }
        
    }

    private static void listTopNMovies() {
        // Implement listing top N movies
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Top N"); 
        int n = sc.nextInt();
        System.out.println("Enter 1 to sort based on year, Enter 2 to sort based on Genre");
        int f = sc.nextInt();
        switch(f) {
            case 1:
                System.out.println("Enter the year"); 
                int year = sc.nextInt();
                sortbasedOnYear(year);
                break;
            case 2:
                System.out.println("Enter the genre"); 
                String genre = sc.nextLine(); // Consume newline
                genre = sc.nextLine(); 
                sortbasedOnGenre(genre);
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
        
    }
}