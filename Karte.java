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
        setzeSpielbar(true);
    }
    
    /**
     * Andert das Aussehen der Karte.
     * @param spielbar ob die Karte abgelegt werden kann
     */
    public void setzeSpielbar(boolean spielbar) {
        this.spielbar = spielbar;
        setImage("Karte/" + wert + "/" + (spielbar ? "bunt" : "grau") + ".png");
    }
    
    /**
     * Gibt zurück, ob die Karte gelegt werden kann.
     * @return ob die Karte gelegt werden kann.
     */
    public boolean istSpielbar() {
        return spielbar;
    }
    
    /**
     * Wird aufgerufen, wenn die Karte angeklickt wird.
     */
    void onClick() {
        if (!spielbar) return;
        //TODO: Karte ablegen
    }
}