/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 200 "model.ump"
// line 265 "model.ump"
public class Hand
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Hand Associations
  private List<EstateCard> estateCards;
  private List<PlayerCard> playerCards;
  private List<WeaponCard> WeaponCards;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Hand()
  {
    estateCards = new ArrayList<EstateCard>();
    playerCards = new ArrayList<PlayerCard>();
    WeaponCards = new ArrayList<WeaponCard>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public EstateCard getEstateCard(int index)
  {
    EstateCard aEstateCard = estateCards.get(index);
    return aEstateCard;
  }

  public List<EstateCard> getEstateCards()
  {
    List<EstateCard> newEstateCards = Collections.unmodifiableList(estateCards);
    return newEstateCards;
  }

  public int numberOfEstateCards()
  {
    int number = estateCards.size();
    return number;
  }

  public boolean hasEstateCards()
  {
    boolean has = estateCards.size() > 0;
    return has;
  }

  public int indexOfEstateCard(EstateCard aEstateCard)
  {
    int index = estateCards.indexOf(aEstateCard);
    return index;
  }
  /* Code from template association_GetMany */
  public PlayerCard getPlayerCard(int index)
  {
    PlayerCard aPlayerCard = playerCards.get(index);
    return aPlayerCard;
  }

  public List<PlayerCard> getPlayerCards()
  {
    List<PlayerCard> newPlayerCards = Collections.unmodifiableList(playerCards);
    return newPlayerCards;
  }

  public int numberOfPlayerCards()
  {
    int number = playerCards.size();
    return number;
  }

  public boolean hasPlayerCards()
  {
    boolean has = playerCards.size() > 0;
    return has;
  }

  public int indexOfPlayerCard(PlayerCard aPlayerCard)
  {
    int index = playerCards.indexOf(aPlayerCard);
    return index;
  }
  /* Code from template association_GetMany */
  public WeaponCard getWeaponCard(int index)
  {
    WeaponCard aWeaponCard = WeaponCards.get(index);
    return aWeaponCard;
  }

  public List<WeaponCard> getWeaponCards()
  {
    List<WeaponCard> newWeaponCards = Collections.unmodifiableList(WeaponCards);
    return newWeaponCards;
  }

  public int numberOfWeaponCards()
  {
    int number = WeaponCards.size();
    return number;
  }

  public boolean hasWeaponCards()
  {
    boolean has = WeaponCards.size() > 0;
    return has;
  }

  public int indexOfWeaponCard(WeaponCard aWeaponCard)
  {
    int index = WeaponCards.indexOf(aWeaponCard);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfEstateCards()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addEstateCard(EstateCard aEstateCard)
  {
    boolean wasAdded = false;
    if (estateCards.contains(aEstateCard)) { return false; }
    estateCards.add(aEstateCard);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeEstateCard(EstateCard aEstateCard)
  {
    boolean wasRemoved = false;
    if (estateCards.contains(aEstateCard))
    {
      estateCards.remove(aEstateCard);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addEstateCardAt(EstateCard aEstateCard, int index)
  {  
    boolean wasAdded = false;
    if(addEstateCard(aEstateCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEstateCards()) { index = numberOfEstateCards() - 1; }
      estateCards.remove(aEstateCard);
      estateCards.add(index, aEstateCard);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveEstateCardAt(EstateCard aEstateCard, int index)
  {
    boolean wasAdded = false;
    if(estateCards.contains(aEstateCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfEstateCards()) { index = numberOfEstateCards() - 1; }
      estateCards.remove(aEstateCard);
      estateCards.add(index, aEstateCard);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addEstateCardAt(aEstateCard, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPlayerCards()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addPlayerCard(PlayerCard aPlayerCard)
  {
    boolean wasAdded = false;
    if (playerCards.contains(aPlayerCard)) { return false; }
    playerCards.add(aPlayerCard);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePlayerCard(PlayerCard aPlayerCard)
  {
    boolean wasRemoved = false;
    if (playerCards.contains(aPlayerCard))
    {
      playerCards.remove(aPlayerCard);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPlayerCardAt(PlayerCard aPlayerCard, int index)
  {  
    boolean wasAdded = false;
    if(addPlayerCard(aPlayerCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlayerCards()) { index = numberOfPlayerCards() - 1; }
      playerCards.remove(aPlayerCard);
      playerCards.add(index, aPlayerCard);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePlayerCardAt(PlayerCard aPlayerCard, int index)
  {
    boolean wasAdded = false;
    if(playerCards.contains(aPlayerCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlayerCards()) { index = numberOfPlayerCards() - 1; }
      playerCards.remove(aPlayerCard);
      playerCards.add(index, aPlayerCard);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPlayerCardAt(aPlayerCard, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfWeaponCards()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addWeaponCard(WeaponCard aWeaponCard)
  {
    boolean wasAdded = false;
    if (WeaponCards.contains(aWeaponCard)) { return false; }
    WeaponCards.add(aWeaponCard);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeWeaponCard(WeaponCard aWeaponCard)
  {
    boolean wasRemoved = false;
    if (WeaponCards.contains(aWeaponCard))
    {
      WeaponCards.remove(aWeaponCard);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addWeaponCardAt(WeaponCard aWeaponCard, int index)
  {  
    boolean wasAdded = false;
    if(addWeaponCard(aWeaponCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWeaponCards()) { index = numberOfWeaponCards() - 1; }
      WeaponCards.remove(aWeaponCard);
      WeaponCards.add(index, aWeaponCard);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveWeaponCardAt(WeaponCard aWeaponCard, int index)
  {
    boolean wasAdded = false;
    if(WeaponCards.contains(aWeaponCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfWeaponCards()) { index = numberOfWeaponCards() - 1; }
      WeaponCards.remove(aWeaponCard);
      WeaponCards.add(index, aWeaponCard);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addWeaponCardAt(aWeaponCard, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    estateCards.clear();
    playerCards.clear();
    WeaponCards.clear();
  }

  // line 206 "model.ump"
   public void addCard(Card c){
    if(c instanceof EstateCard){
     	addEstateCard((EstateCard) c); 
    }else if(c instanceof PlayerCard){
     	addPlayerCard((PlayerCard) c); 
    }else if(c instanceof WeaponCard){
     	addWeaponCard((WeaponCard) c); 
    }
  }

}