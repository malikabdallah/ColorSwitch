package model.threads;

import controller.Controller;

public class ObstacleMoving implements Runnable{

    private Controller controller;
    private final static int D1=-100;
    private final static int D2=290;

    public ObstacleMoving(Controller controller) {
        super();
        this.controller=controller;
    }
    @Override
    public void run() {


        moveLine();

    }

    private void moveLine() {
        // recuperation de la position
        // des rectangles de l'obstacle ligne color�e


        // recuperation des 4 rectangles qui compose la premiere ligne
        int i1 = controller.getGameManager().getSquare().getFirstRectangleX();
        int i2 =controller.getGameManager().getSquare().getSecondRectangleX();
        int i3 = controller.getGameManager().getSquare().getThirdRectangleX();
        int i4 = controller.getGameManager().getSquare().getFourthRectangleX();

        System.out.println("1="+i1+" ; 2="+i2+" ;3+"+i3+" ;4="+i4);






        while (controller.getGameManager().getObstacleMoving().isAlive()) {
            //System.out.println(exe.isDefileLigne());
            System.out.println("1="+i1+" ; 2="+i2+" ;3+"+i3+" ;4="+i4);

            // si le rectangle sort de la fenetre du cote gauche , il est rematerialisé un peu plus a droite de la fenetre
            if (i1 == D1) {
                i1 = D2;
                System.out.println("################## " + i1 + " #########################");
            }
            controller.getGameManager().getSquare().setFirstRectangleX(i1);
            i1--;

            // si le rectangle sort de la fenetre du cote gauche , il est rematerialisé un peu plus a droite de la fenetre

            if (i2 == D1)
                i2 = D2;
            //pan.setPosX10(i2);
            controller.getGameManager().getSquare().setSecondRectangleX(i2);
            i2--;

            // si le rectangle sort de la fenetre du cote gauche , il est rematerialisé un peu plus a droite de la fenetre

            if (i3 == D1)
                i3 = D2;
            //	pan.setPosX11(i3);
            controller.getGameManager().getSquare().setThirdRectangleX(i3);
            i3--;

            // si le rectangle sort de la fenetre du cote gauche , il est rematerialisé un peu plus a droite de la fenetre
            if (i4 == D1)
                i4 = D2;
            //pan.setPosX12(i4);
            controller.getGameManager().getSquare().setFourthRectangleX(i4);
            i4--;

















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
