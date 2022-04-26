import java.util.ArrayList;
import greenfoot.*;

/**
 * Klasse zum einfachen Ein- und Ausblenden von {@link Actor}.
 * @author Arnim Antritter
 * @version 2022.4.26
 */
public class UIElement extends Actor {
    private int x;
    private int y;
    private boolean hidden;
    private boolean parentHidden;
    private boolean inWorld;
    private ArrayList<UIElement> children;
    protected UIWorld world;

    /**
     * Erstellt ein neues UIElement.
     * @param x x-Koordinate
     * @param y y-Koordinate
     */
    public UIElement(int x, int y) {
        this(x, y, new UIElement[0]);
    }

    /**
     * Erstellt ein neues UIElement, das Unterelemente enthält.
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param children Unterelemente
     */
    public UIElement(int x, int y, UIElement[] children) {
        this.x = x;
        this.y = y;
        this.hidden = false;
        this.parentHidden = false;
        this.inWorld = false;
        this.children = new ArrayList();
        for (UIElement c : children) addElement(c);
        this.world = null;
    }

    /**
     * Wird von Greenfoot aufgerufen, wenn ein Actor zur World hinzugefügt wird.
     */
    public void addedToWorld(World w) {
        world = (UIWorld) w;
        inWorld = true;
        for (UIElement c : children) world.addObject(c, c.x, c.y);
    }

    /**
     * Fügt ein Unterelement hinzu.
     * @param c das Unterelement
     */
    public void addElement(UIElement c) {
        children.add(c);
        if (world != null) world.addObject(c, c.x, c.y);
    }

    /**
     * Blendet das UIElement und seine Unterelemente aus.
     */
    public void hide() {
        if (hidden) return;
        hidden = true;

        rerender();
        updateChildren(true);
    }

    /**
     * Zeigt das UIElement und seine Unterelemente an.
     */
    public void show() {
        if (!hidden) return;
        hidden = false;

        rerender();
        updateChildren(false);
    }

    /**
     * Blendet alle Unterelemente ein/aus.
     * @param parentHidden ob das aktuelle Element aktuell angezeigt wird.
     */
    private void updateChildren(boolean parentHidden) {
        for (UIElement c : children) {
            c.parentHidden = parentHidden;
            c.rerender();
            c.updateChildren(parentHidden);
        }
    }

    /**
     * Versteckt oder zeigt das Element an, indem es zur World hinzugefügt/entfernt wird.
     */
    private void rerender() {
        if (inWorld) {
            world.removeObject(this);
            inWorld = false;
        }
        
        if (!hidden && !parentHidden) {
            GreenfootImage i = getImage();
            world.addObject(this, x + i.getWidth() / 2, y + i.getHeight() / 2);
            inWorld = true;
        }
    }

    /**
     * Ändert den x-Wert des Objekts.
     * @param x x-Wert
     */
    protected void setX(int x) {
        this.x = x;
        rerender();
    }

    /**
     * Ändert den y-Wert des Objekts.
     * @param x y-Wert
     */
    protected void setY(int y) {
        this.y = y;
        rerender();
    }
}