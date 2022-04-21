import greenfoot.*;

public class Spielregeln extends Scene {
    
    public Spielregeln() {
        super("Spielregeln/Spielregeln.png");
        
        addElement(new B());
    }
}

class B extends Button {
    public B() {
        super(1085, 714);
        setImage("SpielregelnButton/ausblenden.png");
    }
    
    void onClick() {
        System.out.println("Spielregeln ausblenden");
        world.usePreviousScene();
    }
}