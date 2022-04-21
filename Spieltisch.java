import greenfoot.*;

public class Spieltisch extends Scene{
    
    public Spieltisch() {
        super("Spieltisch/Hintergrund.png");
        
        addElement(new A());
    }
}

class A extends Button {
    public A() {
        super(1085, 600);
        setImage("SpielregelnButton/anzeigen.png");
    }
    
    void onClick() {
        System.out.println("Spielregeln anzeigen");
        world.useScene(Spielregeln.class);
    }
}