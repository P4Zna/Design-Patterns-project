package com.mycompany.design_pattren;

/**
 *
 * @author رغد
 */
public interface MovieComponent {
    void addObserver(MovieObserver observer);
    void removeObserver(MovieObserver observer);
    void setVerified(boolean isVerified);
    String getTitle();
    boolean isVerified();
}
