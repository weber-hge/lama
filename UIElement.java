import greenfoot.Actor;
import greenfoot.World;
import java.util.ArrayList;

public class UIElement extends Actor {
    private int x;
    private int y;
    private boolean hidden;
    private boolean parentHidden;
    private ArrayList<UIElement> children;
    protected UIWorld world;

    public UIElement(int x, int y) {
        this(x, y, new UIElement[0]);
    }

    public UIElement(int x, int y, UIElement[] children) {
        this.x = x;
        this.y = y;
        this.hidden = false;
        this.parentHidden = false;
        this.children = new ArrayList();
        for (var c : children) addElement(c);
        this.world = null;
    }

    public void addedToWorld(World w) {
        for (var e : children) w.addObject(e, e.x, e.y);
        world = (UIWorld) w;
    }

    public void addElement(UIElement c) {
        children.add(c);
        if (world != null) world.addObject(c, c.x, c.y);
    }

    public void hide() {
        if (hidden) return;
        hidden = true;

        rerender();
        updateChildren(false);
    }

    public void show() {
        if (!hidden) return;
        hidden = false;

        rerender();
        updateChildren(true);
    }

    private void updateChildren(boolean parentHidden) {
        for (var c : children) {
            c.parentHidden = parentHidden;
            c.rerender();
            c.updateChildren(parentHidden);
        }
    }

    private void rerender() {
        getImage().setTransparency((hidden || parentHidden) ? 0 : 255);
    }
}