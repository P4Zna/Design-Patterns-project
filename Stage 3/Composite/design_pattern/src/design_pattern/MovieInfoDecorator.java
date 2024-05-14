/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package design_pattern;

/**
 *
 * @author 96656
 */


public class MovieInfoDecorator extends MovieDecorator {
    private String description;

    public MovieInfoDecorator(MovieComponent decoratedMovie, String description) {
        super(decoratedMovie);
        this.description = description;
    }

    @Override
    public String getInfo() {
        String originalInfo = decoratedMovie.getInfo();
        return originalInfo + "\nDescription: " + description;
    }
}

