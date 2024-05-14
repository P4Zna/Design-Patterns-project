/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.design_pattren;

/**
 *
 * @author USER
 */
class MovieInfoDecorator extends MovieDecorator {
    private String additionalInfo;

    public MovieInfoDecorator(MovieComponent decoratedMovie, String additionalInfo) {
        super(decoratedMovie);
        this.additionalInfo = additionalInfo;
    }

    public String getDescription() {
        return super.getDescription() + ", Additional Info: " + additionalInfo;
    }
}
