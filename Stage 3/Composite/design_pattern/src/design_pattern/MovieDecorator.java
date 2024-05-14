/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package design_pattern;

/**
 *
 * @author 96656
 */
public abstract class MovieDecorator implements MovieComponent {
    protected MovieComponent decoratedMovie;

    public MovieDecorator(MovieComponent decoratedMovie) {
        this.decoratedMovie = decoratedMovie;
    }

    @Override
    public String getTitle() {
        return decoratedMovie.getTitle();
    }

    @Override
    public int getYear() {
        return decoratedMovie.getYear();
    }

    @Override
    public String getLanguage() {
        return decoratedMovie.getLanguage();
    }

    @Override
    public String getGenre() {
        return decoratedMovie.getGenre();
    }

    @Override
    public int getRating() {
        return decoratedMovie.getRating();
    }

    @Override
    public void setVerified(boolean isVerified) {
        decoratedMovie.setVerified(isVerified);
    }

    @Override
    public String getExtraGenre() {
        return decoratedMovie.getExtraGenre();
    }

    @Override
    public String getInfo() {
        return decoratedMovie.getInfo();
    }
}