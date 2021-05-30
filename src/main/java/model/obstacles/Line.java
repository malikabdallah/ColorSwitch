package model.obstacles;

public class Line extends Obstacle{

    private int firstRectangleX;
    private int secondRectangleX;
    private int thirdRectangleX;
    private int FourthRectangleX;
    private int squareY;

    public Line(int firstRectangleX, int secondRectangleX, int thirdRectangleX,
                  int fourthRectangleX,int squareY) {
        this.firstRectangleX = firstRectangleX;
        this.secondRectangleX = secondRectangleX;
        this.thirdRectangleX = thirdRectangleX;
        FourthRectangleX = fourthRectangleX;
        this.squareY=squareY;
    }

    public int getSquareY() {
        return squareY;
    }

    public void setSquareY(int squareY) {
        this.squareY = squareY;
    }

    public int getFirstRectangleX() {
        return firstRectangleX;
    }

    public void setFirstRectangleX(int firstRectangleX) {
        this.firstRectangleX = firstRectangleX;
    }

    public int getSecondRectangleX() {
        return secondRectangleX;
    }

    public void setSecondRectangleX(int secondRectangleX) {
        this.secondRectangleX = secondRectangleX;
    }

    public int getThirdRectangleX() {
        return thirdRectangleX;
    }

    public void setThirdRectangleX(int thirdRectangleX) {
        this.thirdRectangleX = thirdRectangleX;
    }

    public int getFourthRectangleX() {
        return FourthRectangleX;
    }

    public void setFourthRectangleX(int fourthRectangleX) {
        FourthRectangleX = fourthRectangleX;
    }
}
