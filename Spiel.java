import greenfoot.*;

public class Spiel extends UIWorld{
    
    public Spiel() {
        super(1200, 800);
        
        addScene(new Spielregeln());
        addScene(new Spieltisch());
        
        useScene(Spieltisch.class);
    }
}
