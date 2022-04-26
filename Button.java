import greenfoot.*;

/**
 * Allgemeiner Button, der angeklickt werden kann.
 * Bei einem Mausklick wird {@link onClick} aufgerufen.
 * @author Arnim Antritter
 * @version 2022.4.21
 */
public abstract class Button extends UIElement {

    /**
     * Erzeugt einen neuen Button.
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    public Button(int x, int y) {
        this(x, y, "Button/default.png");
    }

    /**
     * Erzeugt einen neuen Button mit Grafik.
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param filePath Bild-Datei
     */
    public Button(int x, int y, String filePath) {
        super(x, y);
        setImage(filePath);
    }

    public final void act() {
        if (Greenfoot.mousePressed(this)) this.onClick();
    }

    /**
     * Wird bei jedem erneuten Klick einmal ausgeführt.
     */
    abstract void onClick();
}
