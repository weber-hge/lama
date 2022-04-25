import greenfoot.World;
import java.util.ArrayList;

/**
 * Klasse zum Verwalten von {@link Scene}
 * @author Arnim Antritter
 * @version 2022.4.21
 */
public class UIWorld extends World {
    private ArrayList<Scene> scenes;
    private ArrayList<Scene> history;

    /**
     * Erzeugt eine neue Welt.
     * @param width Breite
     * @param height Höhe
     */
    public UIWorld(int width, int height) {
        super(width, height, 1);
        this.scenes = new ArrayList();
        this.history = new ArrayList();
    }

    /**
     * Fügt eine neue Szene hinzu.
     * @param s die Szene, die hinzugef�gt werden soll.
     */
    public void addScene(Scene s) {
        scenes.add(s);
        addObject(s, 0, 0);
        s.hide();
    }

    /**
     * Wechselt zu einer neuen Szene.
     * Wenn keine passende Szene gefunden wird, passiert nichts.
     * @param c die Klasse der Szene, die angezeigt werden soll
     */
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

    /**
     * Gibt die aktuelle Szene zurück.
     * @return die aktuelle Szene
     */
    public Scene getCurrentScene() {
        return history.size() > 0 ? history.get(history.size() - 1) : null;    
    }

    /**
     * Wechselt zu vorherigen Szene.
     * Wenn es keine vorherige Szene gibt, wird die aktuelle trotzdem ausgeblendet.
     */
    public void usePreviousScene() {
        if (history.size() <= 1) return;
        getCurrentScene().hide();
        history.remove(history.size() - 1);

        if (history.size() == 0) return;
        getCurrentScene().show();
    }
}