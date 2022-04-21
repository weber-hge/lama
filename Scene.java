/**
 * Klasse, um verschiedene Spielszenen zu erstellen.
 * @author Arnim Antritter
 * @version 2022.4.21
 */
public class Scene extends UIElement {
  
  /**
   * Erzeugt eine neue Szene mit Hintergrund.
   * @param background Bild-Datei
   */
  public Scene(String background) {
    super(0, 0);
    setImage(background);
  }
}