package model.threads;

import controller.Controller;
import model.obstacles.*;

import java.util.List;

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
        moveLine();
    }

    private void moveLine() {
        List<Line> lines=controller.getGameManager().getLines();
        for(Line line:lines){
            int i1 = line.getFirstRectangleX();
            int i2 =line.getSecondRectangleX();
            int i3 = line.getThirdRectangleX();
            int i4 = line.getFourthRectangleX();
            while (controller.getGameManager().getMovingLine().isAlive()) {
                //System.out.println(exe.isDefileLigne());
                if (i4 == D1)
                    i4 = D2;
                //pan.setPosX12(i4);
               line.setFourthRectangleX(i4);
                i4--;

                if (i3 == D1)
                    i3 = D2;
                //	pan.setPosX11(i3);
                line.setThirdRectangleX(i3);
                i3--;
                // si le rectangle sort de la fenetre du cote gauche , il est rematerialisé un peu plus a droite de la fenetre
                if (i1 == D1) {
                    i1 = D2;
                }
                line.setFirstRectangleX(i1);
                i1--;

                // si le rectangle sort de la fenetre du cote gauche , il est rematerialisé un peu plus a droite de la fenetre
                if (i2 == D1)
                    i2 = D2;
                //pan.setPosX10(i2);
                line.setSecondRectangleX(i2);
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
}
