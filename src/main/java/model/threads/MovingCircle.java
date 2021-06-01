package model.threads;

import controller.Controller;

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
        //moveCircle();
    }
    public void moveCircle(){
      System.out.println("move circle");

    int a = 1;

    // recuperation des degres de degre des differentes formes necessaires a la creation du caree
    //recuperation du premier triangle qui compose le care
    int d1 = controller.getGameManager().getCircle().getFirstDegree();

    //recuperation du deuxieme triangle qui compose le care
    int d2 = controller.getGameManager().getCircle().getSecondDegree();


    int d3 = controller.getGameManager().getCircle().getThirdDegree();


    int d4 = controller.getGameManager().getCircle().getFourthDegree();

    //recuperation  du carree mask qui creer l espace vide a l interieur du caree
    //int d5 = pan.getDegCarreMask();

        while (controller.getGameManager().getMovingCircle().isAlive()) {

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


            controller.getGameManager().getCircle().setFirstDegree(d1);
            controller.getGameManager().getCircle().setSecondDegree(d2);
            controller.getGameManager().getCircle().setThirdDegree(d3);
            controller.getGameManager().getCircle().setFourthDegree(d4);


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
