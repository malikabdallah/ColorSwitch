package view;

import model.obstacles.Circle;
import model.obstacles.Line;
import model.obstacles.Square;

import java.awt.*;

public interface Drawer {

     void drawLineObstacle(Graphics g, Line l) ;

     void drawCircleObstacle(Graphics g, Circle c);

     void drawSquareObstacle(Graphics g, Square s);


    }
