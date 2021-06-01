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
        int j = 3;

        int plafond = 0;

        if (controller.getGameManager().getOrdonnesJoeur() > 180) {
            plafond = 10;
        } else {
            plafond = 8;
        }

        // initialisation des coordonn�es de la balle notre personnage
        int x = controller.getGameManager().getAbsiceJoueur(), y = controller.getGameManager().getOrdonnesJoeur();

        // boucle pour cr�er un effet pousser la balle vers l'avant
        for (int i = 2; i < plafond; i++) {
            y = y - i;

            // la balle ne doit pas depass� cette hauteur
            // pour laisser la balle au milieu vertical du panneau
            if (y > 120) {
                controller.getGameManager().setAbsiceJoueur(x);
                ;
                controller.getGameManager().setOrdonnesJoeur(y);

                controller.getGameManager().checkColission();
                ;
            }
        }

        controller.getPan().repaint();

    }
}
