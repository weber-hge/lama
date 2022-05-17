import java.util.*;
import greenfoot.*;

/**
 * Szene für Anzeigen des Spieltischs.
 * @author Arnim Antritter
 * @version 2022.4.21
 */
public class Spieltisch extends Scene {
    private Kartenstapel nachziehstapel;
    private Kartenstapel ablagestapel;
    private Spieler[] spieler;

    /**
     * Erstellt eine neue Spieltisch-Szene.
     */
    public Spieltisch() {
        super("Scenes/Spieltisch/Spieltisch.png");

        addElement(new Button(982, 692, "Scenes/Spieltisch/SpielregelnAnzeigen.png") {
                void onClick() {
                    world.useScene(Spielregeln.class);
                }
            });
            
        spieler = new Spieler[4];
        for (int i = 0; i < spieler.length; i++) spieler[i] = new Spieler();
            
        nachziehstapel = new Kartenstapel();
        ablagestapel = new Kartenstapel();
        
        ArrayList<Karte> karten = new ArrayList();
        
        for (int wert = 1; wert <= 7; wert++) {
            for (int i = 0; i < 8; i++) karten.add(new Karte(389, 335, wert));
        }
        
        Collections.shuffle(karten);
        
        for (Karte k : karten) nachziehstapel.add(k);
        
        for (Spieler s : spieler) {
            for (int i = 1; i <= 6; i++) s.nimmKarteAuf(nachziehstapel.pickUp());
        }
    }
}