/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
