import greenfoot.*;

public class Spielregeln extends Scene {
    
    public Spielregeln() {
        super("Spielregeln/Spielregeln.png");
        
        addElement(new Button(1085, 714, "SpielregelnButton/ausblenden.png") {
                void onClick() {
                    world.usePreviousScene();
                }
            });
    }
}