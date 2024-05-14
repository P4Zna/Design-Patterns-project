/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.design_pattren;

/**
 *
 * @author USER
 */

abstract class MovieDecorator implements MovieComponent {
    protected MovieComponent decoratedMovie;

    public MovieDecorator(MovieComponent decoratedMovie) {
        this.decoratedMovie = decoratedMovie;
    }

    public String getDescription() {
        return decoratedMovie.getDescription();
    }

    public int getRating() {
        return decoratedMovie.getRating();
    }
}


