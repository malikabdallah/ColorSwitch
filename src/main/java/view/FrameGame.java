package view;

import javax.swing.*;

public class FrameGame extends JFrame {

    //permet a la fenetre de connaitre le modele
    //private Executeur exe;

    //permet a la fenetre de connaitre le controleur
    //private Controlleur cont;


    public FrameGame(PanelGame panel) {

        //definit le titre de la fenetre
        this.setTitle("Switch color v2.0");

        //definit la taille de la fenetre
        this.setSize(400, 600);

        ///Termine le processus lorsqu'on clique sur la croix rouge
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //positionne notre fenetre au milieu
        this.setLocationRelativeTo(null);

        //la fenetre n est pas redimentionnable
        this.setResizable(false);


        //    //On prévient notre JFrame que notre JPanel sera son content pane
        this.setContentPane(panel);

        //rend notre fenetre visible
        this.setVisible(true);


        //la fenetre est toujours visible
        this.setAlwaysOnTop(true);


        //le controleur intercepte les evenement de la souris sur la fenetre
        //this.addMouseListener(cont);

        //le controleur intercepte les evenement du claviers sur la fenetre
        //this.addKeyListener(cont);


    }





}
