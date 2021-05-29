package model;

import constantes.Constantes;

import java.awt.*;

public class GameManager {
    public GameManager() {

    }

    // coordonn�es de d�part pour les variables x et y de la balle
    private int absiceJoueur = 200;
    private int ordonnesJoeur = 500;

    private Color couleur= Constantes.COLOR_TURQUOISE;

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getAbsiceJoueur() {
        return absiceJoueur;
    }

    public int getOrdonnesJoeur() {
        return ordonnesJoeur;
    }

    public void setAbsiceJoueur(int absiceJoueur) {
        this.absiceJoueur = absiceJoueur;
    }

    public void setOrdonnesJoeur(int ordonnesJoeur) {
        this.ordonnesJoeur = ordonnesJoeur;
    }
}
