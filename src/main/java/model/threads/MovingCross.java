package model.threads;

import controller.Controller;
import model.obstacles.Cross;

import java.util.List;

public class MovingCross implements Runnable{

    private Controller controller;

    public MovingCross(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        List<Cross> crossList = controller.getGameManager().getCrosses();
        for (Cross cross : crossList) {
            int a = 1;
            // recuperation des degres de d�part pour les 4 quarts du premier cercle
            int d1 = cross.getDegre1();
            int d2 =cross.getDegre2();
            int d3 = cross.getDegre3();
            int d4 =cross.getDegre4();
            while (controller.getGameManager().getMovingCross().isAlive()) {
                // on fait une incr�mentation des degres pour cr�er le mouvement de rotation du
                // pemier cercle
                d1 = d1 + a;
                d2 = d2 + a;
                d3 = d3 + a;
                d4 = d4 + a;
                // r�initialiser le degr� � 0 quand il atteind 360 pour but d'avoir des degr�s
                // normaux
                // lors de la comparaison des les conditions de collition avec un cercle
                if (d1 > 360)
                    d1 = 0;
                if (d2 > 360)
                    d2 = 0;
                if (d3 > 360)
                    d3 = 0;
                if (d4 > 360)
                    d4 = 0;
                // mise a jour des variables degres des formes cercle 1 cercle 2
              cross.setDegre1(d1);
                cross.setDegre2(d2);
                cross.setDegre3(d3);
                cross.setDegre4(d4);
                // on redecine notre panneau avec les cercles et la boule multicolor
                controller.getPan().repaint();
                try {
                    Thread.sleep(8);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                // on ralentis la rotation des cercles et de la boule mutlicolor pour que �a
                // soit plus joli a regarder
            }

        }
    }
}
