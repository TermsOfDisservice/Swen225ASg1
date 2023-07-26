/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 231 "model.ump"
// line 282 "model.ump"
public class PlayerCard extends Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PlayerCard Attributes
  private String type;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PlayerCard(int aValue, String aName)
  {
    super(aValue, aName);
    type = "Player";
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public String getType()
  {
    return type;
  }

  public void delete()
  {
    super.delete();
  }

}