package model.threads;

import controller.Controller;
import model.obstacles.Square;

public class ObstacleMoving implements Runnable{

    private Controller controller;
    //-80
    private final static int D1=-95;

    private final static int D2=285;

    public ObstacleMoving(Controller controller) {
        super();
        this.controller=controller;
    }
    @Override
    public void run() {


        System.out.println("called");
        moveCircle();

        moveLine();
        controller.getPan().repaint();
        try {

            Thread.sleep(12);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        //moveSquare();

    }

    private void moveSquare() {
        // utiliser pour inTrian�menter des degres des triangles et du rectangle (qui sert de masque)
        // qui compose la figure carre
        int a = 1;

        // recuperation des degres de degre des differentes formes necessaires a la creation du caree
        //recuperation du premier triangle qui compose le care
        Square pan=controller.getGameManager().getSquare();
        int d1 = controller.getGameManager().getSquare().getDegTrian1();

        //recuperation du deuxieme triangle qui compose le care
        int d2 = pan.getDegTrian2();


        int d3 = pan.getDegTrian3();


        int d4 = pan.getDegTrian4();

        //recuperation  du carree mask qui creer l espace vide a l interieur du caree
        int d5 =    45;

        while (controller.getGameManager().getObstacleMoving().isAlive()) {

            //on increment les degrer des triangles qui composent le career
            d1 = d1 + a;
            d2 = d2 + a;
            d3 = d3 + a;
            d4 = d4 + a;
            d5 = d5 + a;




            // r�initialiser le degr� � 0 quand il atteind 360 pour but d'avoir des degr�s
            // normaux lors de la comparaison des colisions

            if (d1 > 360)
                d1 = 0;
            if (d2 > 360)
                d2 = 0;
            if (d3 > 360)
                d3 = 0;
            if (d4 > 360)
                d4 = 0;
            if (d5 > 360)
                d5 = 0;





            pan.setDegTrian1(d1);
            pan.setDegTrian2(d2);
            pan.setDegTrian3(d3);
            pan.setDegTrian4(d4);
            pan.setDegCarreMask(d5);



            // on redecine notre panneau avec les cercles et la boule multicolor
            controller.getPan().repaint();

            // on ralentis la rotation des cercles et de la boule mutlicolor pour que �a
            // soit plus joli a regarder

        }
    }

    private void moveCircle() {
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

        while (controller.getGameManager().getObstacleMoving().isAlive()) {

            //on increment les degrer des triangles qui composent le career
            d1 = d1 + a;
            d2 = d2 + a;
            d3 = d3 + a;
            d4 = d4 + a;
            //d5 = d5 + a;


            // r�initialiser le degr� � 0 quand il atteind 360 pour but d'avoir des degr�s
            // normaux lors de la comparaison des colisions

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


        }
    }

    private void moveLine() {
        // recuperation de la position
        // des rectangles de l'obstacle ligne color�e


        // recuperation des 4 rectangles qui compose la premiere ligne

        int i1 = controller.getGameManager().getLine().getFirstRectangleX();
        int i2 =controller.getGameManager().getLine().getSecondRectangleX();
        int i3 = controller.getGameManager().getLine().getThirdRectangleX();
        int i4 = controller.getGameManager().getLine().getFourthRectangleX();



        while (controller.getGameManager().getObstacleMoving().isAlive()) {
            //System.out.println(exe.isDefileLigne());

            if (i4 == D1)
                i4 = D2;
            //pan.setPosX12(i4);
            controller.getGameManager().getLine().setFourthRectangleX(i4);
            i4--;

            if (i3 == D1)
                i3 = D2;
            //	pan.setPosX11(i3);
            controller.getGameManager().getLine().setThirdRectangleX(i3);
            i3--;


            // si le rectangle sort de la fenetre du cote gauche , il est rematerialisé un peu plus a droite de la fenetre
            if (i1 == D1) {
                i1 = D2;
            }
            controller.getGameManager().getLine().setFirstRectangleX(i1);
            i1--;

            // si le rectangle sort de la fenetre du cote gauche , il est rematerialisé un peu plus a droite de la fenetre

            if (i2 == D1)
                i2 = D2;
            //pan.setPosX10(i2);
            controller.getGameManager().getLine().setSecondRectangleX(i2);
            i2--;

            // si le rectangle sort de la fenetre du cote gauche , il est rematerialisé un peu plus a droite de la fenetre



            // si le rectangle sort de la fenetre du cote gauche , il est rematerialisé un peu plus a droite de la fenetre


















        }



    }
}
