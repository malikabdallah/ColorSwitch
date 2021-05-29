package model.threads;

import controller.Controller;

public class JumpingBall implements Runnable {
/*
    private Panneau pan;

    private Executeur exe;
  */
    private Controller controller;

    public JumpingBall(Controller controller) {
        super();
        //this.pan = p
        this.controller=controller;
        //this.exe = exe;
    }

    public void run() {
        //cette boucle sert a generer la chute de la balle
        //!tres important !
        for (int i =controller.getGameManager().getOrdonnesJoeur(); i < 330; i++) {
            controller.getGameManager().setAbsiceJoueur(controller.getGameManager().getAbsiceJoueur());
            controller.getGameManager().setOrdonnesJoeur(i);
            /*
            exe.collision();
            exe.collision_ligne();
            exe.collision_multi_ligne();
            exe.collisionCroix();
            exe.collisionCarre();

             */
            //controller.getGameManager().changeCouleur();
            controller.getPan().repaint();
            try {
                if (controller.getGameManager().getOrdonnesJoeur() > 180) {
                    Thread.sleep(30);
                } else {
                    Thread.sleep(20);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
