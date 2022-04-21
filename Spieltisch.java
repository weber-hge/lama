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
        super("Scenes/Spieltisch/Spieltisch.png");

        addElement(new Button(1085, 714, "Scenes/Spieltisch/SpielregelnAnzeigen.png") {
                void onClick() {
                    world.useScene(Spielregeln.class);
                }
            });
    }
}