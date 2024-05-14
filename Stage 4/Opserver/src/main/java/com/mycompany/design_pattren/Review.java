package com.mycompany.design_pattren;

/**
 *
 * @author USER
 */


import java.util.HashMap;

public class Review {
    
    User user;
    
    Movie movie;
    Integer reviewScore;
    
    Review(Integer reviewScore,User  user,Movie movie)
    {
        this.reviewScore=reviewScore;
        this.user = user;
        this.movie = movie;
        

    }




    
}
