package view;

import model.obstacles.Circle;
import model.obstacles.Cross;
import model.obstacles.Line;

import java.awt.*;

public interface Drawer {

     void drawLineObstacle(Graphics g, Line l) ;

     void drawCircleObstacle(Graphics g, Circle c);


     void drawCrossObsacle(Graphics g, Cross c);


    }
