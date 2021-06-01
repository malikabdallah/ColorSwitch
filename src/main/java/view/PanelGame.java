package view;

import constantes.Constantes;
import controller.Controller;
import model.obstacles.Circle;
import model.obstacles.Cross;
import model.obstacles.Line;
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

        //this.drawLineObstacle(g);
        //this.drawCircleObstacle(g,controller.getGameManager().getCircle());
        this.drawCrossObsacle(g,controller.getGameManager().getCross());
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




        g.setColor(Constantes.COLOR_TURQUOISE);
        int x=controller.getGameManager().multiColorBall.getAbsiceBouleMulti();
        int y=controller.getGameManager().multiColorBall.getOrdonneBouleMulti();
        int d1=controller.getGameManager().multiColorBall.getDegrePremierQuartBouleMultiCouleur();
        int d2=controller.getGameManager().multiColorBall.getDegreDeuxiemeQuartBouleMultiCouleur();
        int d3=controller.getGameManager().multiColorBall.getDegreTroisiemeQuartBouleMultiCouleur();
        int d4=controller.getGameManager().multiColorBall.getDegreQuatriemeQuartBouleMultiCouleur();
        g.fillArc(x, y, 20, 20, 0,90 );

        g.setColor(Constantes.COLOR_YELLOW);
        g.fillArc(x, y, 20,20,90, 90);

        g.setColor(Constantes.COLOR_PINK);
        g.fillArc(x, y, 20, 20, 180, 90);

        g.setColor(Constantes.COLOR_VIOLET);
        g.fillArc(x,y, 20, 20, 270, 90);




    }


    @Override
    public void drawCrossObsacle(Graphics g, Cross c) {
        // dessiner la croix
        //le lien d'ou j'ai récuperer cette façon de rotation de n'importe kel forme :
        //https://stackoverflow.com/questions/13519449/rotate-rectangle-and-move-it-in-sin-wave-help-using-graphics2d
        Graphics2D g1 = (Graphics2D) g;
        g1.setColor(Constantes.COLOR_TURQUOISE);
        Rectangle rect1 = new Rectangle((int) c.getCrossX(), (int) c.getCrossY(), 10, 70);
        AffineTransform transform1 = new AffineTransform();
        transform1.rotate(Math.toRadians(c.getDegre1()), rect1.getX() + rect1.width / 2, rect1.getY());
        Shape transformed1 = transform1.createTransformedShape(rect1);
        g1.fill(transformed1);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Constantes.COLOR_YELLOW);
        Rectangle rect2 = new Rectangle((int) c.getCrossX(), (int) c.getCrossY(), 10, 70);
        AffineTransform transform2 = new AffineTransform();
        transform2.rotate(Math.toRadians(c.getDegre2()), rect2.getX() + rect2.width / 2, rect2.getY());
        Shape transformed2 = transform2.createTransformedShape(rect2);
        g2.fill(transformed2);

        Graphics2D g3 = (Graphics2D) g;
        g3.setColor(Constantes.COLOR_PINK);
        Rectangle rect3 = new Rectangle((int) c.getCrossX(), (int) c.getCrossY(), 10, 70);
        AffineTransform transform3 = new AffineTransform();
        transform3.rotate(Math.toRadians(c.getDegre3()), rect3.getX() + rect3.width / 2, rect3.getY());
        Shape transformed3 = transform3.createTransformedShape(rect3);
        g3.fill(transformed3);

        Graphics2D g4 = (Graphics2D) g;
        g4.setColor(Constantes.COLOR_VIOLET);
        Rectangle rect4 = new Rectangle((int) c.getCrossX(), (int) c.getCrossY(), 10, 70);
        AffineTransform transform4 = new AffineTransform();
        transform4.rotate(Math.toRadians(c.getDegre4()), rect4.getX() + rect4.width / 2, rect4.getY());
        Shape transformed4 = transform4.createTransformedShape(rect4);
        g4.fill(transformed4);

    }
}
