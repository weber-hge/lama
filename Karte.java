import greenfoot.*;

/**
 * Repräsentiert eine Spielkarte.
 * @author Arnim Antritter
 * @version 2022.4.24
 */
public class Karte extends Button {
    private int wert;
    private boolean spielbar;

    /**
     * Erzeugt eine neue Karte.
     * @param x x-Koordinate
     * @param y y-Koordinate
     * @param wert der Wert der Karte
     */
    public Karte(int x, int y, int wert) {
        super(x, y);
        this.wert = wert;
        setzeSpielbar(false);
    }

    /**
     * Ändert das Aussehen der Karte.
     * @param spielbar ob die Karte abgelegt werden kann
     */
    public void setzeSpielbar(boolean spielbar) {
        this.spielbar = spielbar;
        setImage("Karte/" + wert + "/" + (spielbar ? "bunt" : "grau") + ".png");
    }

    /**
     * Gibt zur�ck, ob die Karte gelegt werden kann.
     * @return ob die Karte gelegt werden kann.
     */
    public boolean istSpielbar() {
        return spielbar;
    }

    void onClick(){
        if (!spielbar) return;
        else setzeSpielbar(false);
        
        //TODO: Wert an Ablagestapel übergeben
    }
    
    public int getWert() {
        return wert;
    }

    /**
     * Wird aufgerufen, wenn die Karte angeklickt wird.
     */
    void geheZu(Kartenstapel k, boolean rotation) {
        if(rotation == true){
            setRotation((int)((Math.random()*180+270)%360));
        }
        while(!(getX()==k.getX() && getY()==335)){
            int a=k.getX()-getX();
            int b=k.getY()-getX();
            if(a>0){
                if(b>0){
                    if(Math.abs(a)>Math.abs(b)){
                        while(getX()<k.getX()){
                            while(getY()<k.getY()){
                                setLocation(getX()+1,getY()+1);
                                Greenfoot.delay(4);
                            }
                            setLocation(getX()+1,getY());
                            Greenfoot.delay(4);
                        }
                    }
                    else{
                        while(getY()<k.getY()){
                            while(getX()<k.getX()){
                                setLocation(getX()+1,getY()+1);
                                Greenfoot.delay(4);
                            }
                            setLocation(getX(),getY()+1);
                            Greenfoot.delay(4);
                        }
                    }
                }
                else{
                    if(Math.abs(a)>Math.abs(b)){
                        while(getX()<k.getX()){
                            while(getY()>k.getY()){
                                setLocation(getX()+1,getY()-1);
                                Greenfoot.delay(4);
                            }
                            setLocation(getX()+1,getY());
                            Greenfoot.delay(4);
                        }
                    }
                    else{
                        while(getY()>k.getY()){
                            while(getX()<k.getX()){
                                setLocation(getX()+1,getY()-1);
                                Greenfoot.delay(4);
                            }
                            setLocation(getX(),getY()-1);
                            Greenfoot.delay(4);
                        }
                    }
                }
            }
            else{
                if(b>0){
                    if(Math.abs(a)>Math.abs(b)){
                        while(getX()>k.getX()){
                            while(getY()<k.getY()){
                                setLocation(getX()-1,getY()+1);
                            }
                            setLocation(getX()-1,getY());
                        }
                    }
                    else{
                        while(getY()<k.getY()){
                            while(getX()>k.getX()){
                                setLocation(getX()-1,getY()+1);
                            }
                            setLocation(getX(),getY()+1);
                        }
                    }
                }
                else{
                    if(Math.abs(a)>Math.abs(b)){
                        while(getX()>k.getX()){
                            while(getY()>k.getY()){
                                setLocation(getX()-1,getY()-1);
                            }
                            setLocation(getX()-1,getY());
                        }
                    }
                    else{
                        while(getY()>k.getY()){
                            while(getX()>k.getX()){
                                setLocation(getX()-1,getY()-1);
                            }
                            setLocation(getX(),getY()-1);
                        }
                    }
                }
            }
        }
    }
}