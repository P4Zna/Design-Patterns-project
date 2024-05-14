package com.mycompany.design_pattren;

/**
 *
 * @author USER
 */


import java.util.ArrayList;
import java.util.List;



public class Movie implements MovieComponent{

    String title;
    boolean isVerified;
    private List<MovieObserver> observers;
    
    int movieID ;
    static int id =1;
    Integer year;
    String language;
    String genre;
    Integer rating;
    ArrayList <Review> reviews;

   
    Movie(String title, int year, String language, String genre)
     {
        this.title = title;
        this.isVerified = false;
        this.observers = new ArrayList<>();
        
        this.year=year;
        this.language=language;
        this.genre=genre;
        this.movieID=id++;
        reviews = new ArrayList<>();
       

    }
    
    @Override
    public void addObserver(MovieObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(MovieObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
        notifyObservers();
    }

    private void notifyObservers() {
        for (MovieObserver observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean isVerified() {
        return isVerified;
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
}
