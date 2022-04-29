import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Überklasse der zwei verschiedenen möglichen Spieler
 *
 * @author Lisa Abendschein
 * @author Juliane Fassl
 * @version 28.04.2022
 */
public class Spieler extends Actor
{
    // Attribute
    public boolean playing;
    public int anzKarten;
   
    //Konstruktor
    /**
     * Erstellt einen Spieler mit playing zuerst auf true gesetzt, da der Spieler ja zu Beginn aktiv ist und noch nicht ausgestiegen ist.
     * anzKarten wird auf die Anzahl der Startkarten gestetzt
     * ??-- also 6???
    */
    public Spieler (){
        this.playing = true;
        this.anzKarten = 6;
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
    
    
    
    //Fragen + Ideen
    /**
     * Legt die entsprechende Karte.
     * @param wert Gibt an, welche Karte abgelegt werden soll.
     */
    private void karteLegen(int wert){
        //Welche Klasse ist dafür zuständig?
        
        //wenn Karte existiert
        changeAnzKarten(false);
        
        //Verweis Klasse "Karten" bzw. Spielelogik?
    }
    
    //Handkarten: Bei Spieler oder Karten?
    
    /**
     * Bestimmt die Strafpunkte der Handkarten.
     * @return Strafpunkte
     */
    private int strafpunkte(){
        int punkte = 0;
        
        //Punkte zählen
        
        return punkte;
    }
}