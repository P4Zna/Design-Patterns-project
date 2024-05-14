/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package design_pattern;

/**
 *
 * @author 96656
 */


public interface MovieComponent {
    String getTitle();
    int getYear();
    String getLanguage();
    String getGenre();
    int getRating();
    void setVerified(boolean isVerified);
    String getExtraGenre();
    String getInfo();
}