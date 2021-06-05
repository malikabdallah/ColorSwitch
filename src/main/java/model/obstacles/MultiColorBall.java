package model.obstacles;

public class MultiColorBall implements Obstacle{


    public  boolean visible;

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    private int degrePremierQuartBouleMultiCouleur = 0;


    private int degreDeuxiemeQuartBouleMultiCouleur = 90;


    private int degreTroisiemeQuartBouleMultiCouleur = 180;


    private int degreQuatriemeQuartBouleMultiCouleur = 270;

    private int absiceBouleMulti;

    private int ordonneBouleMulti;

    public MultiColorBall(int degrePremierQuartBouleMultiCouleur, int degreDeuxiemeQuartBouleMultiCouleur, int degreTroisiemeQuartBouleMultiCouleur, int degreQuatriemeQuartBouleMultiCouleur,
                          int absiceBouleMulti, int ordonneBouleMulti
    ,boolean visible)
    {
        this.degrePremierQuartBouleMultiCouleur = degrePremierQuartBouleMultiCouleur;
        this.degreDeuxiemeQuartBouleMultiCouleur = degreDeuxiemeQuartBouleMultiCouleur;
        this.degreTroisiemeQuartBouleMultiCouleur = degreTroisiemeQuartBouleMultiCouleur;
        this.degreQuatriemeQuartBouleMultiCouleur = degreQuatriemeQuartBouleMultiCouleur;
        this.absiceBouleMulti = absiceBouleMulti;
        this.ordonneBouleMulti = ordonneBouleMulti;
        this.visible=visible;
    }

    public int getAbsiceBouleMulti() {
        return absiceBouleMulti;
    }

    public void setAbsiceBouleMulti(int absiceBouleMulti) {
        this.absiceBouleMulti = absiceBouleMulti;
    }

    public int getOrdonneBouleMulti() {
        return ordonneBouleMulti;
    }

    public void setOrdonneBouleMulti(int ordonneBouleMulti) {
        this.ordonneBouleMulti = ordonneBouleMulti;
    }

    public int getDegrePremierQuartBouleMultiCouleur() {
        return degrePremierQuartBouleMultiCouleur;
    }

    public void setDegrePremierQuartBouleMultiCouleur(int degrePremierQuartBouleMultiCouleur) {
        this.degrePremierQuartBouleMultiCouleur = degrePremierQuartBouleMultiCouleur;
    }

    public int getDegreDeuxiemeQuartBouleMultiCouleur() {
        return degreDeuxiemeQuartBouleMultiCouleur;
    }

    public void setDegreDeuxiemeQuartBouleMultiCouleur(int degreDeuxiemeQuartBouleMultiCouleur) {
        this.degreDeuxiemeQuartBouleMultiCouleur = degreDeuxiemeQuartBouleMultiCouleur;
    }

    public int getDegreTroisiemeQuartBouleMultiCouleur() {
        return degreTroisiemeQuartBouleMultiCouleur;
    }

    public void setDegreTroisiemeQuartBouleMultiCouleur(int degreTroisiemeQuartBouleMultiCouleur) {
        this.degreTroisiemeQuartBouleMultiCouleur = degreTroisiemeQuartBouleMultiCouleur;
    }

    public int getDegreQuatriemeQuartBouleMultiCouleur() {
        return degreQuatriemeQuartBouleMultiCouleur;
    }

    public void setDegreQuatriemeQuartBouleMultiCouleur(int degreQuatriemeQuartBouleMultiCouleur) {
        this.degreQuatriemeQuartBouleMultiCouleur = degreQuatriemeQuartBouleMultiCouleur;
    }
}
