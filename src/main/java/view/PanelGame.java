package view;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import constantes.Constantes;
import controller.Controller;
import model.obstacles.Circle;
import model.obstacles.Line;
import model.obstacles.Square;
import model.threads.FallingBall;
import model.threads.JumpingBall;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class PanelGame extends JPanel implements Drawer {

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

        this.drawLineObstacle(g);
        this.drawCircleObstacle(g,controller.getGameManager().getCircle());

        // On red�finit une couleur pour le rond
        g.setColor(this.controller.getGameManager().getCouleur());
        // On le dessine aux coordonn�es souhait�es
        g.fillOval(this.controller.getGameManager().getAbsiceJoueur(),
                this.controller.getGameManager().getOrdonnesJoeur(), 20, 20);

    }

    private void drawLineObstacle(Graphics g) {

        //on dessine la premiere ligne color de la double ligne

        g.setColor(Constantes.COLOR_TURQUOISE);
        g.fill3DRect(this.controller.getGameManager().getLine().getFirstRectangleX(),
                controller.getGameManager().getLine().getSquareY(), 95, 10, true);
        g.setColor(Constantes.COLOR_YELLOW);
        g.fill3DRect(this.controller.getGameManager().getLine().getSecondRectangleX(),
                controller.getGameManager().getLine().getSquareY(), 95, 10, true);
        g.setColor(Constantes.COLOR_PINK);
        g.fill3DRect(this.controller.getGameManager().getLine().getThirdRectangleX(),
                controller.getGameManager().getLine().getSquareY(), 95, 10, true);
        g.setColor(Constantes.COLOR_VIOLET);
        g.fill3DRect(this.controller.getGameManager().getLine().getFourthRectangleX(),
                controller.getGameManager().getLine().getSquareY(), 95, 10, true);

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

    @Override
    public void drawLineObstacle(Graphics g, Line l) {

    }

    @Override
    public void drawCircleObstacle(Graphics g, Circle c) {

        g.setColor(Constantes.COLOR_TURQUOISE);
        g.fillArc(c.getCircleX(), c.getCircleY(), 120, 120, c.getFirstDegree(),90 );

        g.setColor(Constantes.COLOR_YELLOW);
        g.fillArc(c.getCircleX(), c.getCircleY(), 120,120, c.getSecondDegree(), 90);

        g.setColor(Constantes.COLOR_PINK);
        g.fillArc(c.getCircleX(), c.getCircleY(), 120, 120, c.getThirdDegree(), 90);

        g.setColor(Constantes.COLOR_VIOLET);
        g.fillArc(c.getCircleX(), c.getCircleY(), 120, 120, c.getFourthDegree(), 90);

        g.setColor(Constantes.COLOR_BLACK);
        g.fillOval(c.getCircleX()+10, c.getCircleY()+10, 100, 100);



    }

    @Override
    public void drawSquareObstacle(Graphics g, Square s) {



    }
}
