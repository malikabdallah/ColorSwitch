package model;

import constantes.Constantes;
import controller.Controller;
import model.threads.FallingBall;
import model.threads.JumpingBall;

import java.awt.*;

public class GameManager {

    private Controller controller;
    public GameManager(Controller controller) {
        this.run=true;
        this.controller=controller;
    }

    // coordonn�es de d�part pour les variables x et y de la balle
    private int absiceJoueur = 200;
    private int ordonnesJoeur = 400;

    private Color couleur= Constantes.COLOR_TURQUOISE;


    private Thread fallingBall;
    private Thread jumpingBall;

    public Thread getFallingBall() {
        return fallingBall;
    }

    public void setFallingBall(Thread fallingBall) {
        this.fallingBall = fallingBall;
    }

    public Thread getJumpingBall() {
        return jumpingBall;
    }

    public void setJumpingBall(Thread jumpingBall) {
        this.jumpingBall = jumpingBall;
    }

    private boolean run;

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

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

    public void startFallingBall() {
        this.fallingBall=new Thread(new FallingBall(this.getController()));
        this.fallingBall.start();

    }

    public  void startJumpingBall(){
        this.jumpingBall=new Thread(new JumpingBall(this.getController()));
        this.jumpingBall.start();

    }

    private Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller=controller;
    }
}
