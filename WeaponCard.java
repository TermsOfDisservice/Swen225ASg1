/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 236 "model.ump"
// line 287 "model.ump"
public class WeaponCard extends Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //WeaponCard Attributes
  private String type;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public WeaponCard(int aValue, String aName)
  {
    super(aValue, aName);
    type = "Weapon";
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