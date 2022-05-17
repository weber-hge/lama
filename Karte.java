import greenfoot.*;

/**
 * Repräsentiert eine Spielkarte.
 * @author Arnim Antritter
 * @version 2022.4.24
 */
public class Karte extends Button {
    private int wert;
    private boolean spielbar;

    /**
     * Erzeugt eine neue Karte.
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param wert der Wert der Karte
     */
    public Karte(int x, int y, int wert) {
        super(x, y);
        this.wert = wert;
        setzeSpielbar(false);
    }

    /**
     * Ändert das Aussehen der Karte.
     * @param spielbar ob die Karte abgelegt werden kann
     */
    public void setzeSpielbar(boolean spielbar) {
        this.spielbar = spielbar;
        setImage("Karte/" + wert + "/" + (spielbar ? "bunt" : "grau") + ".png");
    }

    /**
     * Gibt zur�ck, ob die Karte gelegt werden kann.
     * @return ob die Karte gelegt werden kann.
     */
    public boolean istSpielbar() {
        return spielbar;
    }

    void onClick(){
        if (!spielbar) return;
        else setzeSpielbar(false);

        //TODO: Wert an Ablagestapel übergeben
    }

    public int getWert() {
        return wert;
    }

    /**
     * Wird aufgerufen, wenn die Karte angeklickt wird.
     */
    void geheZu(int x, int y, boolean rotation) {
        if(rotation) setRotation((int) ((Math.random()*180+270) % 360));
        
        int dx = x - getX();
        int dy = y - getY();

        while (dx != 0 || dy != 0) {
            int mx = 0, my = 0;
            if (dx != 0) mx = dx / Math.abs(dx); //+1 oder -1
            if (dy != 0) my = dy / Math.abs(dy); //+1 oder -1
            
            //TODO: mx und yx anpassen, dass Gerade bis zu (x|y) ensteht
            //TODO: Rotation langsam ändern
            setLocation(getX() + mx, getY() + my);
            Greenfoot.delay(4);
            
            dx = x - getX();
            dy = y - getY();
        }

    }
}