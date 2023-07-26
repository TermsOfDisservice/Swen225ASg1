import java.util.List;

/**
 * Write a description of class Door here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Door extends Tile
{
   boolean left = false;
   boolean right = false;
   boolean top = false;
   boolean bot = false;
   
   public Door(int x, int y){
        super(x,y,'D');
    }
   public void setRightTrue(){
        right = true;
    }
    public void setLeftTrue(){
        left = true;
    } 
    public void setBotTrue(){
        bot = true;
    } 
    public void setTopTrue(){
        top = true;
    } 
}
