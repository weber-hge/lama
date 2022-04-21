import greenfoot.World;
import java.util.ArrayList;

public class UIWorld extends World {
    private ArrayList<Scene> scenes;
    private ArrayList<Scene> history;

    public UIWorld(int width, int height) {
        super(width, height, 1);
        this.scenes = new ArrayList();
        this.history = new ArrayList();
    }

    public void addScene(Scene s) {
        scenes.add(s);
        addObject(s, 0, 0);
        s.hide();
    }

    public void useScene(Class c) {
        for (var s : scenes) {
            if (s == getCurrentScene()) continue;
            
            if (c.isInstance(s)) {
                if (history.size() != 0) getCurrentScene().hide();
                if (history.size() >= 10) history.remove(0);
                
                history.add(s);
                s.show();
                return;
            }
        }
    }

    public Scene getCurrentScene() {
        return history.size() > 0 ? history.get(history.size() - 1) : null;    
    }

    public void usePreviousScene() {
        if (history.size() <= 1) return;
        getCurrentScene().hide();
        history.remove(history.size() - 1);

        if (history.size() == 0) return;
        getCurrentScene().show();
    }
}