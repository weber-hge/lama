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
        super("Scenes/Spielregeln/Spielregeln.png");
        
        addElement(new Button(982, 692, "Scenes/Spielregeln/SpielregelnAusblenden.png") {
                void onClick() {
                    world.usePreviousScene();
                }
            });
    }
}