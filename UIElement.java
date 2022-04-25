import greenfoot.Actor;
import greenfoot.World;
import java.util.ArrayList;

/**
 * Klasse zum einfachen Ein- und Ausblenden von {@link Actor}.
 * @author Arnim Antritter
 * @version 2022.4.21
 */
public class UIElement extends Actor {
    private int x;
    private int y;
    private boolean hidden;
    private boolean parentHidden;
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
        this.children = new ArrayList();
        for (var c : children) addElement(c);
        this.world = null;
    }

    /**
     * Wird von Greenfoot aufgerufen, wenn ein Actor zur World hinzugefügt wird.
     */
    public void addedToWorld(World w) {
        world = (UIWorld) w;
        for (var c : children) world.addObject(c, c.x, c.y);
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
        for (var c : children) {
            c.parentHidden = parentHidden;
            c.rerender();
            c.updateChildren(parentHidden);
        }
    }

    /**
     * Versteckt oder zeigt das Element an, indem es zur World hinzugefügt/entfernt wird.
     */
    private void rerender() {
        try {
            if (hidden || parentHidden) {
                world.removeObject(this);
            }
            else {
                var i = getImage();
                world.addObject(this, x + i.getWidth() / 2, y + i.getHeight() / 2); 
            }
        } catch (Exception e) {
            //Element war schon entfernt
        }
    }
}