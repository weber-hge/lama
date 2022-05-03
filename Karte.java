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
     * �ndert das Aussehen der Karte.
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

    /**
     * Wird aufgerufen, wenn die Karte angeklickt wird.
     */
    void onClick() {
        if (!spielbar) return;
        else{
            setzeSpielbar(false);
            setRotation((int)((Math.random()*120+300)%360));
            while(!(getX()==719 && getY()==335)){
                int a=719-getX();
                int b=184;
                if(a>0){
                    if(Math.abs(a)>b){
                        while(getX()<719){
                            while(getY()>335){
                                setLocation(getX()+1,getY()-1);
                            }
                            setLocation(getX()+1,getY());
                        }
                    }
                    else{
                        while(getY()>335){
                            while(getX()<719){
                                setLocation(getX()+1,getY()-1);
                            }
                            setLocation(getX(),getY()-1);
                        }
                    }
                }
                else{
                    if(Math.abs(a)>b){
                        while(getX()>719){
                            while(getY()>335){
                                setLocation(getX()-1,getY()-1);
                            }
                            setLocation(getX()-1,getY());
                        }
                    }
                    else{
                        while(getY()>335){
                            while(getX()>719){
                                setLocation(getX()-1,getY()-1);
                            }
                            setLocation(getX(),getY()-1);
                        }
                    }
                }
            }
            //Wert dem Ablagestapel übergeben!!!!!
        }
    }
}