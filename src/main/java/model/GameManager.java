package model;

import com.sun.org.apache.bcel.internal.Const;
import constantes.Constantes;
import controller.Controller;
import model.obstacles.*;
import model.threads.*;

import java.awt.*;

public class GameManager {

    private Controller controller;


    //public List<Obstacle>obstacleList;



    private Circle circle;

    private Line line;

    private Cross cross;

    public Cross getCross() {
        return cross;
    }

    public void setCross(Cross cross) {
        this.cross = cross;
    }

    public Circle getCircle() {
        return circle;
    }

    public void setCircle(Circle circle) {
        this.circle = circle;
    }


    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public MultiColorBall multiColorBall;

    public MultiColorBall getMultiColorBall() {
        return multiColorBall;
    }

    public void setMultiColorBall(MultiColorBall multiColorBall) {
        this.multiColorBall = multiColorBall;
    }

    public GameManager(Controller controller) {
        this.run=true;
        this.controller=controller;
       // square=new Square(0,100,200,300,200);
         circle=new Circle(90,100,0,90,180,270,
                150,200);
        //cross=new Cross(90,300,45,135,225,315);
         // line=new Line(0,95,190,285,300);

        multiColorBall=new MultiColorBall(90,100,0,90,140,320 );
    }

    // coordonn�es de d�part pour les variables x et y de la balle
    private int absiceJoueur = 140;
    private int ordonnesJoeur = 400;

    private Color couleur= Constantes.COLOR_TURQUOISE;


    private Thread fallingBall;
    private Thread jumpingBall;
    private Thread movingCircle;
    private Thread movingLine;
    private Thread movingCross;

    public Thread getMovingCross() {
        return movingCross;
    }

    public void setMovingCross(Thread movingCross) {
        this.movingCross = movingCross;
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

    public Thread getMovingCircle() {
        return movingCircle;
    }

    public void setMovingCircle(Thread movingCircle) {
        this.movingCircle = movingCircle;
    }

    public Thread getMovingLine() {
        return movingLine;
    }

    public void setMovingLine(Thread movingLine) {
        this.movingLine = movingLine;
    }

    public void objectStartMoving() {
       // this.obstacleMoving=new Thread(new ObstacleMoving(controller));
        //this.obstacleMoving.start();

        this.movingCircle=new Thread(new MovingCircle(controller));
        //this.movingLine=new Thread(new MovingLine(controller));
       // this.movingCross=new Thread(new MovingCross(controller));
        //this.movingLine.start();
        this.movingCircle.start();
        //this.movingCross.start();

    }

    public int getDegree(int quart){
        int d=controller.getGameManager().circle.getFirstDegree();
        switch (quart){
            case 1:
                d= controller.getGameManager().getCircle().getFirstDegree();
                break;
            case 2:
                d= controller.getGameManager().getCircle().getSecondDegree();
                break;
            case 3:
                d= controller.getGameManager().getCircle().getThirdDegree();
                break;
            case 4:
                d= controller.getGameManager().getCircle().getFourthDegree();
                break;

        }
        return d;
    }

    public boolean checkColissionCircleUp(int firstQuart,int secondQuart,int thirdQuart){
        int quart1,quart2,quart3;
        quart1=getDegree(firstQuart);
        quart2=getDegree(secondQuart);
        quart3=getDegree(thirdQuart);


        //0 || 90
        if (this.controller.getGameManager().getOrdonnesJoeur() < this.controller.getGameManager().getCircle().getCircleY()
                && (this.ordonnesJoeur + 20 > this.getCircle().getCircleY())
                &&( (quart1 > 0 && quart1 <90)
                || (quart2 > 0 && quart2 <90)
                || (quart3 < 90 && quart3>0 ))
               )

        {




            // System.out.println(this.getPan().getOrdonnesJoeur());
            return true;

            //stopper_tout();
        }else{
            return false;
        }
    }

    public boolean checkColissionCircleBottom(int firstQuart,int secondQuart,int thirdQuart){
        int quart1,quart2,quart3;
        quart1=getDegree(firstQuart);
        quart2=getDegree(secondQuart);
        quart3=getDegree(thirdQuart);

        if (this.controller.getGameManager().getOrdonnesJoeur() - 115 < this.controller.getGameManager().getCircle().getMaskY()
                //collision avec la partie interne  hute du plus petit double cercle
                && this.controller.getGameManager().getOrdonnesJoeur() - 95 > this.controller.getGameManager()
                .getCircle().getMaskY()

                // si le degre du quart de cercle est superieur a 180 et inferieur a 270
                && ((quart1 > 180 && quart1<270)

                || (quart2 > 180 && quart2<270)
                || (quart3>180 && quart3<270)
        )) {
            return true;
        }else{
            return false;
        }

    }


    public boolean checkColissionLine(){
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
        boolean colission=false;
        switch (couleurCode){

            case 1:
                if (this.controller.getGameManager().getOrdonnesJoeur() <= this.controller.getGameManager().line.getSquareY() + 5
                        && this.controller.getGameManager().getOrdonnesJoeur() >= this.controller.getGameManager().line.getSquareY() - 15
                        && this.controller.getGameManager().getAbsiceJoueur() >= this.controller.getGameManager().line.getSecondRectangleX()
                        && this.controller.getGameManager().getAbsiceJoueur() <= this.controller.getGameManager().line.getSecondRectangleX() + 95) {
                        System.out.println("colision ligne");
                        return true;
                    //stopper_tout();
                }
                if (this.controller.getGameManager().getOrdonnesJoeur() <= this.controller.getGameManager().line.getSquareY() + 5
                        && this.controller.getGameManager().getOrdonnesJoeur() >= this.controller.getGameManager().line.getSquareY() - 15
                        && this.controller.getGameManager().getAbsiceJoueur() >= this.controller.getGameManager().line.getThirdRectangleX()
                        && this.controller.getGameManager().getAbsiceJoueur() <= this.controller.getGameManager().line.getThirdRectangleX() + 95) {
                        System.out.println("colision ligne");
                        return true;
                }
                if (this.controller.getGameManager().getOrdonnesJoeur() <= this.controller.getGameManager().line.getSquareY() + 5
                        && this.controller.getGameManager().getOrdonnesJoeur() >= this.controller.getGameManager().line.getSquareY() - 15
                        && this.controller.getGameManager().getAbsiceJoueur() >= this.controller.getGameManager().line.getFourthRectangleX()
                        && this.controller.getGameManager().getAbsiceJoueur() <= this.controller.getGameManager().line.getFourthRectangleX() + 95) {
                        System.out.println("colision ligne");
                        return true;
                }


                break;

        }
        return true;
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
        boolean colission=false;
        switch (couleurCode){
            case 1:

                checkColissionMultiColorBall();
                break;
            case 2:
                colission=checkColissionCircleBottom(1,3,4)
                || checkColissionCircleUp(1,3,4);
                if(colission){
                    System.out.println("colission");
                }else {
                    System.out.println("aucune colision");
                }
                break;
            case 3:
                colission=checkColissionCircleBottom(2,1,4)
                || checkColissionCircleUp(2,1,4);
                if(colission){
                    //System.out.println("colission");
                }else {
                    //System.out.println("aucune colision");
                }
                break;
            case 4:
                colission=checkColissionCircleBottom(2,3,1)
                || checkColissionCircleUp(2,3,1);
                if(colission){
                    System.out.println("colission");
                }else {
                    System.out.println("aucune colision");
                }
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


    public  void checkColissionMultiColorBall(){

        if(multiColorBall.getOrdonneBouleMulti()>= this.ordonnesJoeur-10
        && multiColorBall.getOrdonneBouleMulti()<= this.ordonnesJoeur+10){
            int couleurCode;
            if(couleur == Constantes.COLOR_TURQUOISE){
               couleur=Constantes.COLOR_VIOLET;
            }else if(couleur == Constantes.COLOR_VIOLET){
                couleur=Constantes.COLOR_PINK;
            }else if(couleur == Constantes.COLOR_PINK){
                 couleur=Constantes.COLOR_YELLOW;
            }else {
                couleur=Constantes.COLOR_TURQUOISE;
            }
        }

    }


    public boolean checkColissionCross(){
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
        boolean colission=false;

        switch (couleurCode) {
            case 1:
                int d2 = cross.getDegre2();
                int d3 = cross.getDegre1();
                int d4 = cross.getDegre4();
                if (((d2 > 70 && d2 < 130))
                        && this.ordonnesJoeur>= cross.getCrossY()-20 && this.ordonnesJoeur<=cross.getCrossY()+20) {
                    System.out.println("colission D2");
                }
                if (((d3 > 70 && d3 < 130))
                        && this.ordonnesJoeur>= cross.getCrossY()-20 && this.ordonnesJoeur<=cross.getCrossY()+20) {
                    System.out.println("colission D3");
                }
                if (( (d4 > 70 && d4 < 130))
                 && this.ordonnesJoeur>= cross.getCrossY()-20 && this.ordonnesJoeur<=cross.getCrossY()+20) {
                    System.out.println("colission D4");
                }
                break;
        }



        return false;
    }
}
