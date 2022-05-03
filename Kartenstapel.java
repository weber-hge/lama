import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Stack;

/**
 * Kartenstapel.
 * 
 * @author Lisa Abendschein
 * @author Marcel 
 * @author Juliane Fassl
 * @version 03.05.2022
 */
public class Kartenstapel extends Actor
{
    private Stack<Karte> stack = new Stack<>();
    
    public boolean istLeer(){
        return stack.empty();
    }
}
