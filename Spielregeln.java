import greenfoot.*;

/**
 * Szene für Anzeigen der Spielregeln.
 * @author Arnim Antritter
 * @version 2022.4.21
 */
public class Spielregeln extends Scene {
    
    /**
     * Erstellt eine neue Spielregel-Szene.
     */
    public Spielregeln() {
        super("Spielregeln/Spielregeln.png");
        
        addElement(new Button(1085, 714, "SpielregelnButton/ausblenden.png") {
                void onClick() {
                    world.usePreviousScene();
                }
            });
    }
}