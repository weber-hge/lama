import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Überklasse der zwei verschiedenen möglichen Spieler
 *
 * @author Lisa Abendschein
 * @author Juliane Fassl
 * @version 10.05.2022
 */
public class Spieler extends Actor {
    // Attribute
    private boolean playing;
    
    private Kartenstapel[] handKarten;
   
    //Konstruktor
    /**
     * Erstellt einen Spieler mit playing zuerst auf true gesetzt, da der Spieler ja zu Beginn aktiv ist und noch nicht ausgestiegen ist.
     * Anzahl der Karten wird auf null gesetzt.
     */
    public Spieler (){
        this.playing = true;
        this.handKarten = new Kartenstapel[7];
        for (int i = 0; i < handKarten.length; i++) handKarten[i] = new Kartenstapel();
    }
   
    //Methoden
    public void nimmKarteAuf(Karte k) {
        int w = k.getWert();
        handKarten[w != 10 ? w-1 : 6].add(k);
    }
    
    /**
     * Die Methode aussteigen setzt die boolean playing auf false.
     * Wenn der Button AUSSTEIGEN gedrückt wird, sollte dieser die Methode am Spieler aufrufen.
     */
    public void aussteigen() {
        this.playing = false;
    } 
    
    /** 
     * Mit dieser Methode kann der Spielsatus erfragt werden, ob der Spieler noch spielt, playing = true, oder nicht, palying = false.
     * @return Spielstatus
     */
    public boolean gibStatus() {
        return playing;
    }
   
    /** 
     * Gibt die Anzahl der Karten zurück.
     * @return Anzahl Karten insgesamt
    */
    public int gibAnzKarten (){
        int anzKarten = 0;
        for (Kartenstapel s : handKarten) anzKarten += s.getAnzKarten();
        return anzKarten;
    }
    
    
    /**
     * Bestimmt die Strafpunkte der Handkarten.
     * @return Strafpunkte
     */
    private int strafpunkte(){
        int punkte = 0;
        
        for (int i = 0; i < handKarten.length; i++) {
            if (handKarten[i].istLeer()) {
                if (i != 7) punkte += i;
                else punkte += 10;
            }
        }
    
        return punkte;
    }
    
}