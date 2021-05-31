package model.obstacles;

public class Square extends Obstacle {

    // Carré
    //coordonnée de la pointe du triangle
    private int pointeX = 135;
    private int pointeY = 170; // 180

    //coordonnées du premier point du triangle
    private int posTrianX1 = 135;
    private int posTrianY1 = -100; //110

    //coordonnées du 2ieme point du triangle
    private int posTrianX2 = 65;
    private int posTrianY2 = -170; //180


    private int degTrian1 = 0;

    private int degTrian3 = 180;

    private int degTrian2 = 90;

    private int degTrian4 = 270;

    private int xpoints[] = {pointeX, posTrianX1, posTrianX2};
    private int ypoints[] = {pointeY, posTrianY1, posTrianY2};
    public int posCarreMaskX = 90;
    public int posCarreMaskY = -695; //135
    public int degCarreMask = 45;

    public int getDegCarreMask() {
        return degCarreMask;
    }

    public void setDegCarreMask(int degCarreMask) {
        this.degCarreMask = degCarreMask;
    }

    public int getPointeX() {
        return pointeX;
    }

    public void setPointeX(int pointeX) {
        this.pointeX = pointeX;
    }

    public int getPointeY() {
        return pointeY;
    }

    public void setPointeY(int pointeY) {
        this.pointeY = pointeY;
    }

    public int getPosTrianX1() {
        return posTrianX1;
    }

    public void setPosTrianX1(int posTrianX1) {
        this.posTrianX1 = posTrianX1;
    }

    public int getPosTrianY1() {
        return posTrianY1;
    }

    public void setPosTrianY1(int posTrianY1) {
        this.posTrianY1 = posTrianY1;
    }

    public int getPosTrianX2() {
        return posTrianX2;
    }

    public void setPosTrianX2(int posTrianX2) {
        this.posTrianX2 = posTrianX2;
    }

    public int getPosTrianY2() {
        return posTrianY2;
    }

    public void setPosTrianY2(int posTrianY2) {
        this.posTrianY2 = posTrianY2;
    }

    public int getDegTrian1() {
        return degTrian1;
    }

    public void setDegTrian1(int degTrian1) {
        this.degTrian1 = degTrian1;
    }

    public int getDegTrian3() {
        return degTrian3;
    }

    public void setDegTrian3(int degTrian3) {
        this.degTrian3 = degTrian3;
    }

    public int getDegTrian2() {
        return degTrian2;
    }

    public void setDegTrian2(int degTrian2) {
        this.degTrian2 = degTrian2;
    }

    public int getDegTrian4() {
        return degTrian4;
    }

    public void setDegTrian4(int degTrian4) {
        this.degTrian4 = degTrian4;
    }

    public int[] getXpoints() {
        return xpoints;
    }

    public void setXpoints(int[] xpoints) {
        this.xpoints = xpoints;
    }

    public int[] getYpoints() {
        return ypoints;
    }

    public void setYpoints(int[] ypoints) {
        this.ypoints = ypoints;
    }
}
