/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.design_pattren;

/**
 *
 * @author USER
 */
class MovieGenreDecorator extends MovieDecorator {
    private String genre;

    public MovieGenreDecorator(MovieComponent decoratedMovie, String genre) {
        super(decoratedMovie);
        this.genre = genre;
    }

    public String getDescription() {
        return super.getDescription() + ", Genre: " + genre;
    }
}