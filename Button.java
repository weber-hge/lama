import greenfoot.*;

/**
 * Allgemeiner Button, der angeklickt werden kann.
 * Bei einem Mausklick wird {@link onClick} aufgerufen.
 * @author Arnim Antritter
 * @version 2022.4.19
 */
public abstract class Button extends Actor {

    /**
     * Erzeugt einen neuen Button.
     */
    public Button() {      
        setImage("Button/default.png");
    }
    
    public final void act() {
        if (Greenfoot.mousePressed(this)) this.onClick();
    }

    /**
     * Wird bei jedem erneuten Klick einmal ausgeführt.
     */
    abstract void onClick();
}
