package controller;

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
    JPanel panel;
    GameManager gameManager;
    public Controller() {
        gameManager=new GameManager();
        System.out.println(" couleur "+gameManager.getCouleur().toString());
        PanelGame panel=new PanelGame(this);
        frame=new FrameGame(panel);
    }

    public JPanel getPan(){
        return panel;
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

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
}
