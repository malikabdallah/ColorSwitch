package model.obstacles;

public class Cross implements Obstacle{

    private int crossX=80;
    private int crossY=300;
    private int degre1=45;
    private int degre2=135;
    private int degre3=225;
    private int degre4=315;


    public Cross(int crossX, int crossY, int degre1, int degre2, int degre3, int degre4) {
        this.crossX = crossX;
        this.crossY = crossY;
        this.degre1 = degre1;
        this.degre2 = degre2;
        this.degre3 = degre3;
        this.degre4 = degre4;
    }

    public int getCrossX() {
        return crossX;
    }

    public void setCrossX(int crossX) {
        this.crossX = crossX;
    }

    public int getCrossY() {
        return crossY;
    }

    public void setCrossY(int crossY) {
        this.crossY = crossY;
    }

    public int getDegre1() {
        return degre1;
    }

    public void setDegre1(int degre1) {
        this.degre1 = degre1;
    }

    public int getDegre2() {
        return degre2;
    }

    public void setDegre2(int degre2) {
        this.degre2 = degre2;
    }

    public int getDegre3() {
        return degre3;
    }

    public void setDegre3(int degre3) {
        this.degre3 = degre3;
    }

    public int getDegre4() {
        return degre4;
    }

    public void setDegre4(int degre4) {
        this.degre4 = degre4;
    }
}
