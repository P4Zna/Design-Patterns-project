/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package design_pattern;

/**
 *
 * @author USER
 */


import java.util.ArrayList;



public  class Movie implements MovieComponent {

    String title ;
    int movieID ;
    static int id =1;
    Integer year;
    String language;
    String genre;
    Integer rating;
    ArrayList <Review> reviews;
    Boolean isVerified=false;
    private String description; // Added for providing additional movie information
    private String extraGenre;
   
    Movie(String title, int year, String language, String genre)
     {
        this.title =title;
        this.year=year;
        this.language=language;
        this.genre=genre;
        this.movieID=id++;
      
        reviews = new ArrayList<>();
       

    }


    public int Rating()
    {
        int res=0;
        if(reviews.size()==0){return 0;}
        for(Review review:reviews)
        {
            if(review.user.reviewCount>=3) 
              {
                  res =res + 2*review.reviewScore;
              } 
            else
              {
                   res = res+res;
              }
        }
        
      return res/reviews.size();

    }
    
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public String getLanguage() {
        return language;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    @Override
    public String getExtraGenre() {
    return extraGenre != null ? extraGenre : genre; // Return extra genre if it exists, otherwise return the regular genre
}

    @Override
    public String getInfo() {
        return description ;
    }
  
    
}
