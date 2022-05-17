import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Stack;

/**
 * Kartenstapel.
 * 
 * @author Lisa Abendschein 
 * @author Juliane Fassl
 * @version 10.05.2022
 */
public class Kartenstapel extends Actor
{
    private Stack<Karte> stack = new Stack<>();
    private int anzKarten;

    //Konstruktor
    public Kartenstapel(){
        anzKarten = 0;
    }
    
    //Methoden
    
    /**
     * Gibt zurück, ob der Stapel leer ist.
     * @return Ist der Stapel leer?
     */
    public boolean istLeer(){
        return stack.empty();
    }
    
    /**
     * Fügt eine Karte dem Stapel zu und passt die Anzahl der Karten an.
     */
    public void add(Karte a){
        stack.push(a);
        anzKarten++;
    }
    
    /**
     * Nimmt die oberste Karte vom Stapel und passt die Anzahl der Karten an.
     * @return Die oberste Karte
     */
    public Karte pickUp() {
        if(!(stack.empty())){
            anzKarten--;
            return stack.pop();
        }else{return null;}
    }
    
    /**
     * Gibt die oberste Karte zurück, ohne sie zu entfernen.
     * @return Die oberste Karte
     */
    public Karte read (){
        return stack.peek();
    }
    
    /**
     * Gibt die Anzhal der Karten im Stapel zurück.
     * @return Anzahl der Karten im Stapel
     */
    public int getAnzKarten(){
        return anzKarten;
    }
}
