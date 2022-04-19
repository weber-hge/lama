import greenfoot.*;

/**
 * Button zum Anzeigen der Spielregeln.
 * @author Arnim Antritter
 * @version 2022.4.19
 */
public class SpielregelnButton extends Button {
    private boolean regelnAngezeigt;

    /**
     * Erzeugt einen neuen Button.
     */
    public SpielregelnButton() {
        super();
        regelnAngezeigt = false;
        updateImage();
    }

    public void onClick() {
        regelnAngezeigt = !regelnAngezeigt;
        updateSpielregeln();
        updateImage();
    }
    
    /**
     * Ändert das Bild des Buttons je nachdem, ob die Spielregeln aktuell angezeigt sind.
     */
    void updateImage() {
        setImage("SpielregelnButton/" + (regelnAngezeigt ? "ausblenden" : "anzeigen") + ".png");
    }
    
    /**
     * Blendet ein Spielregel-Object aus/ein.
     */
    void updateSpielregeln() {
        World world = getWorld();
        
        if (regelnAngezeigt) {
            world.addObject(new Spielregeln(), 600, 400); //TODO: warum geht (0, 0) nicht?

            // wieder hinzufügen damit der Button über den Spielregeln ist
            int[] p = new int[] {getX(), getY()};
            world.removeObject(this);
            world.addObject(this, p[0], p[1]);
        } else {
            for (Actor a : world.getObjectsAt(0, 0, Actor.class)) {
                if (a instanceof Spielregeln) {
                    world.removeObject(a);
                }
            }
        }
    }
}
