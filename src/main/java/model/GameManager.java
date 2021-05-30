package model;

import constantes.Constantes;
import controller.Controller;
import model.obstacles.Circle;
import model.obstacles.Square;
import model.threads.FallingBall;
import model.threads.JumpingBall;
import model.threads.ObstacleMoving;

import java.awt.*;

public class GameManager {

    private Controller controller;


    private Square square;

    private Circle circle;

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public GameManager(Controller controller) {
        this.run=true;
        this.controller=controller;
       // square=new Square(0,100,200,300,200);
         circle=new Circle(150,200,0,90,180,270,
                 150,200);

    }

    // coordonn�es de d�part pour les variables x et y de la balle
    private int absiceJoueur = 200;
    private int ordonnesJoeur = 400;

    private Color couleur= Constantes.COLOR_TURQUOISE;


    private Thread fallingBall;
    private Thread jumpingBall;
    private Thread obstacleMoving;

    public Thread getObstacleMoving() {
        return obstacleMoving;
    }

    public void setObstacleMoving(Thread obstacleMoving) {
        this.obstacleMoving = obstacleMoving;
    }

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

    public void objectStartMoving() {
        this.obstacleMoving=new Thread(new ObstacleMoving(controller));
        this.obstacleMoving.start();

    }
}
