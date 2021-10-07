package controller;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import model.GameManager;
import view.FrameGame;
import view.PanelGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller implements MouseListener, KeyListener {

    FrameGame frame;
    PanelGame panel;
    GameManager gameManager;
    public Controller() {
       // AudioClip mApplause = new AudioClip(this.getClass().getResource("/colorswitch.mp3").toExternalForm());
       // mApplause.play();

        gameManager=new GameManager(this);
        panel=new PanelGame(this);

        frame=new FrameGame(panel);
        gameManager.setController(this);
        gameManager.startFallingBall();
        gameManager.objectStartMoving();
        frame.addKeyListener(this);
    }

    public JPanel getPan(){
        return panel;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


        if(e.getKeyCode()== 32) {
            if (gameManager.isRun()) {

                panel.monter();
                //gameManager.startJumpingBall();
            }
        }

        if(e.getKeyCode()==65){
            gameManager.losing();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (gameManager.isRun()) {
            //gameManager.setStarted(true);
            panel.descendre();

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (gameManager.isRun()) {
            panel.monter();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (gameManager.isRun()) {
            panel.monter();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (gameManager.isRun()) {
            //gameManager.setStarted(true);
            gameManager.startFallingBall();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public GameManager getGameManager() {
        return this.gameManager;
    }

    public void updateScore() {
        this.panel.updateScore();
    }
}
