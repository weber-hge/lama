import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Überklasse der zwei verschiedenen möglichen Spieler
 *
 * @author Lisa Abendschein
 * @author Juliane Fassl
 * @version 03.05.2022
 */
public class Spieler extends Actor
{
    // Attribute
    private boolean playing;
    private int anzKarten;
    
    private Kartenstapel eins;
    private Kartenstapel zwei;
    private Kartenstapel drei;
    private Kartenstapel vier;
    private Kartenstapel fünf;
    private Kartenstapel sechs;
    private Kartenstapel lama;
   
    //Konstruktor
    /**
     * Erstellt einen Spieler mit playing zuerst auf true gesetzt, da der Spieler ja zu Beginn aktiv ist und noch nicht ausgestiegen ist.
     * anzKarten wird auf die Anzahl der Startkarten gestetzt
    */
    public Spieler (){
        this.playing = true;
        this.anzKarten = 0;
    }
   
    //Methoden
    /**
     * Die Methode aussteigen setzt die boolean playing auf false.
     * Wenn der Button AUSSTEIGEN gedrückt wird, sollte dieser die Methode am Spieler aufrufen.
    */
    public void aussteigen(){
        this.playing = false;
    }
   
    /**
     * Wenn der Spieler eine Karte nachgezogen oder abgelegt hat, kann diese Methode aufgerufen werden um anzKarten anzupassen.
     * @param onemore = true - dann wurde nachgezogen; = false - dann wurde eine Karte abglegt
     */
     public void changeAnzKarten(boolean onemore){
         if (onemore == true){
            anzKarten = anzKarten + 1;
        }
        if (onemore == false){
            anzKarten = anzKarten - 1;
        }
    }
   
    
    /** 
     * Mit dieser Methode kann der Spielsatus erfragt werden, ob der Spieler noch spielt, playing = true, oder nicht, palying = false.
     * @return Spielstatus
     */
    public boolean gibStatus (){
        return playing;
    }
   
    /** 
     * Gibt die Anzahl der Karten zurück.
     * @return Anzahl Karten
    */
    public int gibAnzKarten (){
        return anzKarten;
    }
    
    
    /**
     * Bestimmt die Strafpunkte der Handkarten.
     * @return Strafpunkte
     */
    private int strafpunkte(){
        int punkte = 0;
        
        if(eins.istLeer() == false){
            punkte ++;
        }
        if(zwei.istLeer() == false){
            punkte += 2;
        }
        if(drei.istLeer() == false){
            punkte += 3;
        }
        if(vier.istLeer() == false){
            punkte += 4;
        }
        if(fünf.istLeer() == false){
            punkte += 5;
        }
        if(sechs.istLeer() == false){
            punkte += 6;
        }
        if(lama.istLeer() == false){
            punkte += 10;
        }
    
        return punkte;
    }
    
}