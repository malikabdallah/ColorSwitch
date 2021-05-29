package view;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import constantes.Constantes;
import controller.Controller;
import model.threads.FallingBall;
import model.threads.JumpingBall;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class PanelGame extends JPanel implements Observer {

    private JLabel label = new JLabel("Score: 0");
    private Controller controller;

    private void initLabelScore(){
        label.setForeground(Constantes.COLOR_WHITE);
        this.add(label);
        Dimension size = label.getPreferredSize();
        label.setBounds(5, 0, size.width, size.height);
    }

    public PanelGame(Controller controller) {
       this.initLabelScore();

        this.controller=controller;

    }

    @Override
    protected void paintComponent(Graphics g) {

        g.setColor(Constantes.COLOR_BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        // On red�finit une couleur pour le rond
        g.setColor(this.controller.getGameManager().getCouleur());
        // On le dessine aux coordonn�es souhait�es
        g.fillOval(this.controller.getGameManager().getAbsiceJoueur(),
                this.controller.getGameManager().getOrdonnesJoeur(), 25, 25);

    }

    @Override
    public void update(Observable o, Object arg) {

    }

    public void monter() {
        if (this.controller.getGameManager().getFallingBall().isAlive()) {
            this.controller.getGameManager().getFallingBall().stop();
        }else{
        }

        this.controller.getGameManager().setJumpingBall(new Thread(new JumpingBall( this.controller)));
        this.controller.getGameManager().getJumpingBall().start();

    }

    public void descendre() {
        if (this.controller.getGameManager().getFallingBall().isAlive()) {
            this.controller.getGameManager().getFallingBall().stop();
        }else{
        }

        this.controller.getGameManager().setFallingBall(new Thread(new FallingBall( this.controller)));
        this.controller.getGameManager().getFallingBall().start();

    }
}
