package model.threads;

import controller.Controller;

public class JumpingBall implements Runnable {

    private Controller controller;
    public JumpingBall(Controller controller) {
        super();

        this.controller=controller;
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
        for (int i = 2; i < 9; i++) {
            y = y - i;
            // la balle ne doit pas depass� cette hauteur
            // pour laisser la balle au milieu vertical du panneau
            if (y > 200) {
                controller.getGameManager().setAbsiceJoueur(x);
                ;
                controller.getGameManager().setOrdonnesJoeur(y);

                controller.getGameManager().checkColission();
                ;
            }

            if( y < 250 ){
                controller.getGameManager().obstacleGoesDown();
            }
        }

        controller.getPan().repaint();
    }
}
