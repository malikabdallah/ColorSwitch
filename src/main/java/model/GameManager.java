package model;

import com.sun.org.apache.bcel.internal.Const;
import com.sun.org.apache.xpath.internal.operations.Mult;
import constantes.Constantes;
import controller.Controller;
import model.obstacles.*;
import model.threads.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private Controller controller;
    public List<Obstacle> obstacleList=new ArrayList<>();

    public List<Circle>getsCircle(){
        List<Circle>circles=new ArrayList<>();
        for(Obstacle obstacle:obstacleList){
            if(obstacle instanceof Circle){
                circles.add((Circle) obstacle);
            }
        }
        return circles;
    }

    public List<Line>getLines(){
        List<Line>lines=new ArrayList<>();
        for(Obstacle obstacle:obstacleList){
            if(obstacle instanceof Line){
                lines.add((Line) obstacle);
            }
        }
        return lines;
    }
    public List<Cross>getCrosses(){
        List<Cross>crosses=new ArrayList<>();
        for(Obstacle obstacle:obstacleList){
            if(obstacle instanceof Cross){
                crosses.add((Cross) obstacle);
            }
        }
        return crosses;
    }
    public List<MultiColorBall>getMultiColors(){
        List<MultiColorBall>multicolorsballs=new ArrayList<>();
        for(Obstacle obstacle:obstacleList){
            if(obstacle instanceof MultiColorBall){
                multicolorsballs.add((MultiColorBall) obstacle);
            }
        }
        return multicolorsballs;
    }
    public GameManager(Controller controller) {
        this.run=true;
        this.controller=controller;

         obstacleList.add(new Circle(90,-300,0,90,180,270,
                150,-370));
            obstacleList.add(new Cross(80,100,45,135,225,315));

            obstacleList.add(new Line(0,95,190,285,250));

       obstacleList.add(new MultiColorBall(90,
               100,0,
               90,140,320 ,true));
    }

    // coordonn�es de d�part pour les variables x et y de la balle
    private int absiceJoueur = 140;
    private int ordonnesJoeur = 400;

    private Color couleur= Constantes.COLOR_YELLOW;


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
        this.movingLine=new Thread(new MovingLine(controller));
        this.movingCross=new Thread(new MovingCross(controller));
        this.movingLine.start();
        this.movingCircle.start();
        this.movingCross.start();

    }

    public int getDegree(int quart,Circle c){
        int d=c.getFirstDegree();
        switch (quart){
            case 1:
                d= c.getFirstDegree();
                break;
            case 2:
                d= c.getSecondDegree();
                break;
            case 3:
                d= c.getThirdDegree();
                break;
            case 4:
                d= c.getFourthDegree();
                break;

        }
        return d;
    }

    public void  checkColissionCircleUp(int firstQuart,int secondQuart,int thirdQuart,Circle circle){


        int quart1,quart2,quart3;
        quart1=getDegree(firstQuart,circle);
        quart2=getDegree(secondQuart,circle);
        quart3=getDegree(thirdQuart,circle);


        //0 || 90
        if (this.controller.getGameManager().getOrdonnesJoeur() < circle.getCircleY()
                && (this.ordonnesJoeur + 20 > circle.getCircleY())
                &&( (quart1 > 0 && quart1 <90)
                || (quart2 > 0 && quart2 <90)
                || (quart3 < 90 && quart3>0 ))
               )

        {

            losing();
        }else{

        }
    }



    public void checkColissionCircleBottom(int firstQuart,int secondQuart,int thirdQuart,Circle circle){
        int quart1,quart2,quart3;
        quart1=getDegree(firstQuart,circle);
        quart2=getDegree(secondQuart,circle);
        quart3=getDegree(thirdQuart,circle);


        int cbb=this.controller.getGameManager().getOrdonnesJoeur()-115;
        int cbt=this.controller.getGameManager().getOrdonnesJoeur()-95;
        System.out.println(cbb+" "+this.getOrdonnesJoeur()+" "+cbt);

        if(circle.getCircleY()>=cbb && circle.getCircleY()
        <=cbt){
            System.out.println("ordonnes concorde");
            if(((quart1 > 180 && quart1<270)

                    || (quart2 > 180 && quart2<270)
                    || (quart3>180 && quart3<270)
            )){
                losing();
            }
        }
        /*
        if (circle.getMaskY()>=this.controller.getGameManager().getOrdonnesJoeur() - 115
                //collision avec la partie interne  hute du plus petit double cercle
                && circle.getMaskY() <=this.controller.getGameManager().getOrdonnesJoeur() - 95

                // si le degre du quart de cercle est superieur a 180 et inferieur a 270
                && ((quart1 > 180 && quart1<270)

                || (quart2 > 180 && quart2<270)
                || (quart3>180 && quart3<270)
        )) {
            System.out.println("colission up");
            losing();
        }else{

        }
        */
    }


    public void checkColissionLine(Line line){
        int couleurCode;
        if(couleur == Constantes.COLOR_TURQUOISE){
            couleurCode=1;
        }else if(couleur == Constantes.COLOR_YELLOW){
            couleurCode=2;
        }else if(couleur == Constantes.COLOR_PINK){
            couleurCode=3;
        }else {
            couleurCode = 4;
        }
        boolean colission=false;
        int d1=0;
        int d2=0;
        int d3=0;
        //turquoise
        switch (couleurCode){
            case 1:
                d1=line.getSecondRectangleX();
                d2=line.getThirdRectangleX();
                d3=line.getFourthRectangleX();

                break;
            case 2:
                d1=line.getFirstRectangleX();
                d2=line.getFourthRectangleX();
                d3=line.getThirdRectangleX();

                break;
            case 3:
                d1=line.getFirstRectangleX();
                d2=line.getSecondRectangleX();
                d3=line.getFourthRectangleX();
                break;
            case 4:
                d1=line.getFirstRectangleX();
                d2=line.getSecondRectangleX();
                d3=line.getThirdRectangleX();

                break;

        }

        if (this.controller.getGameManager().getOrdonnesJoeur() <= line.getSquareY() + 5
                && this.controller.getGameManager().getOrdonnesJoeur() >= line.getSquareY() - 15
                && this.controller.getGameManager().getAbsiceJoueur() >= d1
                && this.controller.getGameManager().getAbsiceJoueur() <= d1 + 95) {
            System.out.println("colision ligne");
            losing();
            //stopper_tout();
        }
        if (this.controller.getGameManager().getOrdonnesJoeur() <= line.getSquareY() + 5
                && this.controller.getGameManager().getOrdonnesJoeur() >= line.getSquareY() - 15
                && this.controller.getGameManager().getAbsiceJoueur() >= d2
                && this.controller.getGameManager().getAbsiceJoueur() <= d2 + 95) {
            System.out.println("colision ligne");
            losing();
        }
        if (this.controller.getGameManager().getOrdonnesJoeur() <= line.getSquareY() + 5
                && this.controller.getGameManager().getOrdonnesJoeur() >= line.getSquareY() - 15
                && this.controller.getGameManager().getAbsiceJoueur() >=d3
                && this.controller.getGameManager().getAbsiceJoueur() <=d3 + 95) {
            System.out.println("colision ligne");
           losing();
        }




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
        int d1check=1;
        int d2check=2;
        int d3check=3;
        switch (couleurCode){
            case 1:
                d1check=2;
                d2check=3;
                d3check=4;
                break;
            case 2:
                d1check=1;
                d2check=3;
                d3check=4;
                break;
            case 4:
                d1check=1;
                d2check=2;
                d3check=3;
                break;
            case 3:
                d1check=1;
                d2check=2;
                d3check=4;
        }

        for(Obstacle obstacle:obstacleList){
            if(obstacle instanceof Circle){

                checkColissionCircleBottom(d1check,d2check,d3check,(Circle) obstacle) ;
            checkColissionCircleUp(d1check,d2check,d3check,(Circle) obstacle);


            }else if(obstacle instanceof Line){
                checkColissionLine((Line) obstacle);
            }else if(obstacle instanceof Cross){
                checkColissionCross((Cross) obstacle);

            }else if (obstacle instanceof MultiColorBall) {
                checkColissionMultiColorBall((MultiColorBall)obstacle);
            }
        }



    }


    public  void checkColissionMultiColorBall(MultiColorBall multiColorBall){
        boolean collision=false;
        if(multiColorBall.isVisible()) {
            if (multiColorBall.getOrdonneBouleMulti() >= this.ordonnesJoeur - 10
                    && multiColorBall.getOrdonneBouleMulti() <= this.ordonnesJoeur + 10) {
                int couleurCode;
                if (couleur == Constantes.COLOR_TURQUOISE) {
                    couleur = Constantes.COLOR_VIOLET;
                    collision=true;
                } else if (couleur == Constantes.COLOR_VIOLET) {
                    couleur = Constantes.COLOR_PINK;
                    collision=true;
                } else if (couleur == Constantes.COLOR_PINK) {
                    couleur = Constantes.COLOR_YELLOW;
                    collision=true;
                } else {
                    couleur = Constantes.COLOR_TURQUOISE;
                    collision=true;
                }
            }
        }
        if(collision){
            System.out.println("colission multi color ball");
                 multiColorBall.setVisible(false);
        }

    }


    public  void checkColissionCross(Cross cross){
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
        int d1=0,d2=0,d3=0;
        switch (couleurCode){
            //1=3
            case 1:
                d1=cross.getDegre2();
                d2=cross.getDegre3();
                d3=cross.getDegre4();
                break;
            case 2:
                d1=cross.getDegre1();
                d2=cross.getDegre4();
                d3=cross.getDegre3();
                break;
            case 3:
                d1=cross.getDegre2();
                d2=cross.getDegre1();
                d3=cross.getDegre4();
                break;
            case 4:
                d1=cross.getDegre1();
                d2=cross.getDegre2();
                d3=cross.getDegre3();
                break;

        }


        System.out.println(d1+" "+d2+" "+d3);
        System.out.println(ordonnesJoeur+" "+cross.getCrossY());
        if ((d1 <= 270 && d1 >= 255
                && ordonnesJoeur <= cross.getCrossY() + 5
                && ordonnesJoeur >= cross.getCrossY() - 5)) {
            losing();
        }

        if(d2 <= 270 && d2 >= 255
                        && ordonnesJoeur <= cross.getCrossY() + 5
                        && ordonnesJoeur >= cross.getCrossY() - 5) {
            losing();
        }

        if(d3<= 270 && d3>= 255
                        && ordonnesJoeur <= cross.getCrossY() + 5
                        && ordonnesJoeur >= cross.getCrossY() - 5) {

            losing();
        }
        /*
        switch (couleurCode) {
            case 1:

                if (((d2 > 70 && d2 < 130))
                        && this.ordonnesJoeur>= cross.getCrossY()-20 && this.ordonnesJoeur<=cross.getCrossY()+20) {
                        colission=true;
                }
                if (((d3 > 70 && d3 < 130))
                        && this.ordonnesJoeur>= cross.getCrossY()-20 && this.ordonnesJoeur<=cross.getCrossY()+20) {
                    colission=true;

                }
                if (( (d1 > 70 && d1 < 130))
                 && this.ordonnesJoeur>= cross.getCrossY()-20 && this.ordonnesJoeur<=cross.getCrossY()+20) {
                    colission=true;

                }


                if ((d1 <= 265 && d1 >= 255
                        && ordonnesJoeur <= cross.getCrossY() + 5
                        && ordonnesJoeur >= cross.getCrossY() - 5) ||

                        (d2 <= 265 && d2 >= 255
                                && ordonnesJoeur <= cross.getCrossY() + 5
                                && ordonnesJoeur >= cross.getCrossY() - 5)
                        ||

                        (d3<= 265 && d3>= 255
                                && ordonnesJoeur <= cross.getCrossY() + 5
                                && ordonnesJoeur >= cross.getCrossY() - 5)) {

                   losing();
                }
                break;
            case 2:

                if (((d2 > 70 && d2 < 130))
                        && this.ordonnesJoeur>= cross.getCrossY()-20 && this.ordonnesJoeur<=cross.getCrossY()+20) {
                    colission=true;

                }
                if (((d3 > 70 && d3 < 130))
                        && this.ordonnesJoeur>= cross.getCrossY()-20 && this.ordonnesJoeur<=cross.getCrossY()+20) {
                    colission=true;

                }
                if (( (d1 > 70 && d1 < 130))
                        && this.ordonnesJoeur>= cross.getCrossY()-20 && this.ordonnesJoeur<=cross.getCrossY()+20) {
                    colission=true;

                }
                break;
            case 3:

                if (((d2 > 70 && d2 < 130))
                        && this.ordonnesJoeur>= cross.getCrossY()-20 && this.ordonnesJoeur<=cross.getCrossY()+20) {
                    colission=true;

                }
                if (((d3 > 70 && d3 < 130))
                        && this.ordonnesJoeur>= cross.getCrossY()-20 && this.ordonnesJoeur<=cross.getCrossY()+20) {
                    colission=true;

                }
                if (( (d1 > 70 && d1 < 130))
                        && this.ordonnesJoeur>= cross.getCrossY()-20 && this.ordonnesJoeur<=cross.getCrossY()+20) {
                    colission=true;

                }
                break;
            case 4:

                if (((d2 > 70 && d2 < 130))
                        && this.ordonnesJoeur>= cross.getCrossY()-20 && this.ordonnesJoeur<=cross.getCrossY()+20) {
                    colission=true;

                }
                if (((d3 > 70 && d3 < 130))
                        && this.ordonnesJoeur>= cross.getCrossY()-20 && this.ordonnesJoeur<=cross.getCrossY()+20) {
                    colission=true;

                }
                if (( (d1 > 70 && d1 < 130))
                        && this.ordonnesJoeur>= cross.getCrossY()-20 && this.ordonnesJoeur<=cross.getCrossY()+20) {
                    colission=true;

                }
                break;
                }

         */





    }

    public void obstacleGoesDown() {
        lineGoesDown();
        crossGoesDown();
        circleGoesDown();
        multiColorBallGoesDown();



    }

    private void multiColorBallGoesDown() {
        int j=5;
        int y0;
        for(Obstacle obstacle:obstacleList){
            if(obstacle instanceof MultiColorBall){
                MultiColorBall multiColorBall=(MultiColorBall) obstacle;
                y0=multiColorBall.getOrdonneBouleMulti();
                multiColorBall.setOrdonneBouleMulti(y0+j);

            }
        }
    }

    private void circleGoesDown() {
        int j=5;
        int y0;
        int y1;
        for(Obstacle obstacle:obstacleList){
            if(obstacle instanceof Circle){
                Circle circle=(Circle) obstacle;
                y0=circle.getCircleY();
                circle.setCircleY(y0+j);
                y1=circle.getMaskY();
                circle.setMaskY(y1+j);


            }
        }
    }

    private void crossGoesDown() {

        int j=5;
        int y0;
        int y1;
        for(Obstacle obstacle:obstacleList){
            if(obstacle instanceof Cross){
                Cross cross=(Cross) obstacle;
                y0=cross.getCrossY();
                cross.setCrossY(y0+j);

            }
        }

    }

    private void lineGoesDown() {


        int j=5;
        int y0;
        for(Obstacle obstacle:obstacleList){
            if(obstacle instanceof Line){
                Line line=(Line) obstacle;
                y0=line.getSquareY();
                line.setSquareY(y0+j);

            }
        }
    }



    public void losing() {
        this.run=false;
        this.movingCross.stop();
        this.jumpingBall.stop();
        this.fallingBall.stop();
        this.movingCircle.stop();
        this.movingLine.stop();

    }
}
