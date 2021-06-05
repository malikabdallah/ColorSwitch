package model.obstacles;

public class Circle implements Obstacle{


    private int circleX;
    private int circleY;
    private int firstDegree;
    private int secondDegree;
    private int thirdDegree;
    private int fourthDegree;

    // coordonn�es de d�part pour les variables x et y du premier rond gris
    private int maskX = 90;
    private int maskY = 5;


    public int getMaskX() {
        return maskX;
    }

    public void setMaskX(int maskX) {
        this.maskX = maskX;
    }

    public int getMaskY() {
        return maskY;
    }

    public void setMaskY(int maskY) {
        this.maskY = maskY;
    }

    public Circle(int circleX, int circleY, int firstDegree,
                  int secondDegree, int thirdDegree, int fourthDegree
                  ,int maskX,int maskY) {
        this.circleX = circleX;
        this.circleY = circleY;
        this.firstDegree = firstDegree;
        this.secondDegree = secondDegree;
        this.thirdDegree = thirdDegree;
        this.fourthDegree = fourthDegree;
        this.maskX=maskX;
        this.maskY=maskY;
    }

    public int getCircleX() {
        return circleX;
    }

    public void setCircleX(int circleX) {
        this.circleX = circleX;
    }

    public int getCircleY() {
        return circleY;
    }

    public void setCircleY(int circleY) {
        this.circleY = circleY;
    }

    public int getFirstDegree() {
        return firstDegree;
    }

    public void setFirstDegree(int firstDegree) {
        this.firstDegree = firstDegree;
    }

    public int getSecondDegree() {
        return secondDegree;
    }

    public void setSecondDegree(int secondDegree) {
        this.secondDegree = secondDegree;
    }

    public int getThirdDegree() {
        return thirdDegree;
    }

    public void setThirdDegree(int thirdDegree) {
        this.thirdDegree = thirdDegree;
    }

    public int getFourthDegree() {
        return fourthDegree;
    }

    public void setFourthDegree(int fourthDegree) {
        this.fourthDegree = fourthDegree;
    }
}

