/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/



// line 216 "model.ump"
// line 272 "model.ump"
public class Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Card Attributes
  private int value;
  private String name;
  private String type;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Card(int aValue, String aName)
  {
    value = aValue;
    name = aName;
    type = "";
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setValue(int aValue)
  {
    boolean wasSet = false;
    value = aValue;
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

  public boolean setType(String aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public int getValue()
  {
    return value;
  }

  public String getName()
  {
    return name;
  }

  public String getType()
  {
    return type;
  }

  public void delete()
  {}

  // line 222 "model.ump"
   public String toString(){
    return this.getType() + " " + this.getValue();
  }
//hello
}
