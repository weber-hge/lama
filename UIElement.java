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
        world = (UIWorld) w;
        for (var c : children) world.addObject(c, 0, 0);
    }

    public void addElement(UIElement c) {
        children.add(c);
        if (world != null) world.addObject(c, 0, 0);
    }

    public void hide() {
        if (hidden) return;
        hidden = true;

        rerender();
        updateChildren(true);
    }

    public void show() {
        if (!hidden) return;
        hidden = false;

        rerender();
        updateChildren(false);
    }

    private void updateChildren(boolean parentHidden) {
        for (var c : children) {
            c.parentHidden = parentHidden;
            c.rerender();
            c.updateChildren(parentHidden);
        }
    }

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