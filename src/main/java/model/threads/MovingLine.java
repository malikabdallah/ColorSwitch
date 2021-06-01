package model.threads;

import controller.Controller;

public class MovingLine implements Runnable{

    private Controller controller;
    //-80
    private final static int D1=-95;

    private final static int D2=285;

    public MovingLine(Controller controller) {
        super();
        this.controller=controller;
    }
    @Override
    public void run() {
        //moveLine();
    }

    private void moveLine() {
        // recuperation de la position
        // des rectangles de l'obstacle ligne color�e


        // recuperation des 4 rectangles qui compose la premiere ligne

        int i1 = controller.getGameManager().getLine().getFirstRectangleX();
        int i2 =controller.getGameManager().getLine().getSecondRectangleX();
        int i3 = controller.getGameManager().getLine().getThirdRectangleX();
        int i4 = controller.getGameManager().getLine().getFourthRectangleX();



        while (controller.getGameManager().getMovingLine().isAlive()) {
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

















            controller.getPan().repaint();
            //posez le thread pour rendre la vision plus agreable
            try {

                Thread.sleep(8);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

        }



    }
}
