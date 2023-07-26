/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 177 "model.ump"
// line 255 "model.ump"
public class Tile
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Tile Attributes
  private int x;
  private int y;
  private char letter;

  //Tile Associations
  private Board board;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Tile(int aX, int aY, char aLetter)
  {
    x = aX;
    y = aY;
    letter = aLetter;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setX(int aX)
  {
    boolean wasSet = false;
    x = aX;
    wasSet = true;
    return wasSet;
  }

  public boolean setY(int aY)
  {
    boolean wasSet = false;
    y = aY;
    wasSet = true;
    return wasSet;
  }

  public boolean setLetter(char aLetter)
  {
    boolean wasSet = false;
    letter = aLetter;
    wasSet = true;
    return wasSet;
  }

  public int getX()
  {
    return x;
  }

  public int getY()
  {
    return y;
  }

  public char getLetter()
  {
    return letter;
  }
  /* Code from template association_GetOne */
  public Board getBoard()
  {
    return board;
  }

  public boolean hasBoard()
  {
    boolean has = board != null;
    return has;
  }
  /* Code from template association_SetOptionalOneToMany */
  public boolean setBoard(Board aBoard)
  {
    boolean wasSet = false;
    Board existingBoard = board;
    board = aBoard;
    if (existingBoard != null && !existingBoard.equals(aBoard))
    {
      existingBoard.removeTile(this);
    }
    if (aBoard != null)
    {
      aBoard.addTile(this);
    }
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    if (board != null)
    {
      Board placeholderBoard = board;
      this.board = null;
      placeholderBoard.removeTile(this);
    }
  }

  // line 183 "model.ump"
   public String toString(){
    return letter + "";
  }

}