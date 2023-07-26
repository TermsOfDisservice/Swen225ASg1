/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 226 "model.ump"
// line 277 "model.ump"
public class EstateCard extends Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //EstateCard Attributes
  private String type;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public EstateCard(int aValue, String aName)
  {
    super(aValue, aName);
    type = "Estate";
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