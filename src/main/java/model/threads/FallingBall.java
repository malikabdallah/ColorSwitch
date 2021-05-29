package model.threads;

import controller.Controller;

public class FallingBall implements Runnable {


    private Controller controller;

    public FallingBall(Controller controller) {
        super();
       this.controller=controller;
    }

    public void run() {
        //cette boucle sert a generer la chute de la balle
        //!tres important !
        for (int i = controller.getGameManager().getOrdonnesJoeur(); i < 540; i++) {
            controller.getGameManager().setAbsiceJoueur(controller.getGameManager().getAbsiceJoueur());
            controller.getGameManager().setOrdonnesJoeur(i);
            controller.getPan().repaint();
            try {

                if (controller.getGameManager().getOrdonnesJoeur() > 180) {
                    Thread.sleep(15);
                } else {
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
