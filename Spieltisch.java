import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


/**
 * Spieltisch für mehrere Spielrunden.
 * @author Arnim Antritter
 * @version 2022.4.19
 */
public class Spieltisch extends World {
    
    /**
     * Erzeugt einen neuen Spieltisch.
     */
    public Spieltisch() {    
        super(1200, 800, 1);
        setBackground("Spieltisch/Hintergrund.png");
        
        addObject(new AussteigenButton(), 1085, 660-5);
        addObject(new SpielregelnButton(), 1085, 714);
    }
}