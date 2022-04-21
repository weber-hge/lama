import greenfoot.*;

/**
 * Szene für Anzeigen des Spieltischs.
 * @author Arnim Antritter
 * @version 2022.4.21
 */
public class Spieltisch extends Scene{

    /**
     * Erstellt eine neue Spieltisch-Szene.
     */
    public Spieltisch() {
        super("Spieltisch/Hintergrund.png");

        addElement(new Button(1085, 714, "SpielregelnButton/anzeigen.png") {
                void onClick() {
                    int i = 0;
                    world.useScene(Spielregeln.class);
                }
            });
    }
}