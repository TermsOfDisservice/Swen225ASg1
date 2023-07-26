/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 187 "model.ump"
// line 260 "model.ump"
public class Player
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Player Attributes
  private char letter;
  private String name;
  private boolean canSolve;
  private Tile location;

  //Player Associations
  private Hand hand;

  //------------------------
  // CONSTRUCTOR
  //------------------------
    
  public Player(char aLetter, String aName, Hand aHand)
  {
    letter = aLetter;
    name = aName;
    canSolve = true;
    location = null;
    if (!setHand(aHand))
    {
      throw new RuntimeException("Unable to create Player due to aHand. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLetter(char aLetter)
  {
    boolean wasSet = false;
    letter = aLetter;
    wasSet = true;
    return wasSet;
  }

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setCanSolve(boolean aCanSolve)
  {
    boolean wasSet = false;
    canSolve = aCanSolve;
    wasSet = true;
    return wasSet;
  }

  public boolean setLocation(Tile aLocation)
  {
    boolean wasSet = false;
    location = aLocation;
    wasSet = true;
    return wasSet;
  }

  public char getLetter()
  {
    return letter;
  }

  public String getName()
  {
    return name;
  }

  public boolean getCanSolve()
  {
    return canSolve;
  }

  public Tile getLocation()
  {
    return location;
  }
  /* Code from template association_GetOne */
  public Hand getHand()
  {
    return hand;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setHand(Hand aNewHand)
  {
    boolean wasSet = false;
    if (aNewHand != null)
    {
      hand = aNewHand;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    hand = null;
  }

  // line 195 "model.ump"
   public boolean guess(){
    return false;
  }


  public String toString()
  {
    return super.toString() + "["+
            "letter" + ":" + getLetter()+ "," +
            "name" + ":" + getName()+ "," +
            "canSolve" + ":" + getCanSolve()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "location" + "=" + (getLocation() != null ? !getLocation().equals(this)  ? getLocation().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "hand = "+(getHand()!=null?Integer.toHexString(System.identityHashCode(getHand())):"null");
  }
}