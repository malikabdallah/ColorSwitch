package model;

import com.sun.org.apache.bcel.internal.Const;
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

    public void checkColission() {
        int couleurCode;
        if(couleur == Constantes.COLOR_TURQUOISE){
            couleurCode=1;
        }else if(couleur == Constantes.COLOR_VIOLET){
            couleurCode=2;
        }else if(couleur == Constantes.COLOR_PINK){
            couleurCode=3;
        }else {
            couleurCode = 4;
        }
        switch (couleurCode){
            case 1:

                if (this.controller.getGameManager().getOrdonnesJoeur() - 115 < this.controller.getGameManager().getCircle().getMaskY()
                        //collision avec la partie interne  hute du plus petit double cercle
                        && this.controller.getGameManager().getOrdonnesJoeur() - 95 > this.controller.getGameManager()
                        .getCircle().getMaskY()

                        // si le degre du quart de cercle est superieur a 180 et inferieur a 270
                        && ((this.controller.getGameManager().getCircle().getSecondDegree() > 180)

                        || (this.controller.getGameManager().getCircle().getThirdDegree() > 180)
                        || (this.controller.getGameManager().getCircle().getFourthDegree() > 180)
                       )) {
                    System.out.println("colision bas du double cercle");
                }else{
                    System.out.println("aucune colission");
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;


        }

       // switch (this.couleur) {

         //   case Constantes.COLOR_TURQUOISE:
                // double cercle
                //  colision avec la partie externe haute du plus grand double cercle
             /*   if (this.controller.getGameManager().getOrdonnesJoeur() - 115 < this.controller.getGameManager().getCircle().getCircleY()
                        //collision avec la partie interne  hute du plus petit double cercle
                        && this.controller.getGameManager().getOrdonnesJoeur() - 95 > this.controller.getGameManager()
                        ()

                        // si le degre du quart de cercle est superieur a 180 et inferieur a 270
                        && ((this.getPan().getDegreDeuxiemeQuartPremierDoubleCercle() > 180
                        && this.getPan().getDegreDeuxiemeQuartPremierDoubleCercle() < 270)
                        || (this.getPan().getDegreTroisiemeQuartPremierDoubleCercle() > 180
                        && this.getPan().getDegreTroisiemeQuartPremierDoubleCercle() < 270)
                        || (this.getPan().getDegreQuatriemeQuartPremierDoubleCercle() > 180
                        && this.getPan().getDegreQuatriemeQuartPremierDoubleCercle() < 270))) {
                    System.out.println("colision bas du double cercle");
                    stopper_tout();

                }

              */

    }
}
