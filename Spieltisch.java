import greenfoot.*;

public class Spieltisch extends Scene{

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