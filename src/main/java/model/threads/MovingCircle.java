package model.threads;

import controller.Controller;
import model.obstacles.Circle;

import java.util.ArrayList;
import java.util.List;

public class MovingCircle implements Runnable{


    private Controller controller;
    //-80
    private final static int D1=-95;

    private final static int D2=285;

    public MovingCircle(Controller controller) {
        super();
        this.controller=controller;
    }


    @Override
    public void run() {
        moveCircle();
    }


    public void moveCircle() {
        System.out.println("move circle");
        List<Circle> circleList = controller.getGameManager().getsCircle();
        for (Circle circle : circleList) {
            int a = 1;
            // recuperation des degres de degre des differentes formes necessaires a la creation du caree
            //recuperation du premier triangle qui compose le care
            int d1 = circle.getFirstDegree();
            //recuperation du deuxieme triangle qui compose le care
            int d2 = circle.getSecondDegree();
            int d3 = circle.getThirdDegree();
            int d4 = circle.getFourthDegree();
            //recuperation  du carree mask qui creer l espace vide a l interieur du caree
            //int d5 = pan.getDegCarreMask();
            while (controller.getGameManager().isRun()) {
                //on increment les degrer des triangles qui composent le career
                d1 = d1 + a;
                d2 = d2 + a;
                d3 = d3 + a;
                d4 = d4 + a;

                if (d1 > 360)
                    d1 = 0;
                if (d2 > 360)
                    d2 = 0;
                if (d3 > 360)
                    d3 = 0;
                if (d4 > 360)
                    d4 = 0;
                //if (d5 > 360)
                //  d5 = 0;
               circle.setFirstDegree(d1);
                circle.setSecondDegree(d2);
               circle.setThirdDegree(d3);
               circle.setFourthDegree(d4);
                // on redecine notre panneau avec les cercles et la boule multicolor
                controller.getPan().repaint();
                try {
                    Thread.sleep(12);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
