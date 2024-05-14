/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package design_pattern;

/**
 *
 * @author 96656
 */


public class ExtraGenreDecorator extends MovieDecorator {
    private String extraGenre;

    public ExtraGenreDecorator(MovieComponent decoratedMovie, String extraGenre) {
        super(decoratedMovie);
        this.extraGenre = extraGenre;
    }

    @Override
    public String getExtraGenre() {
        String originalGenre = decoratedMovie.getExtraGenre();
        return originalGenre + ", " + extraGenre;
    }
}


