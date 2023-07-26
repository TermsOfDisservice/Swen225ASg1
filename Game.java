/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 2 "model.ump"
// line 244 "model.ump"
public class Game
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Game Attributes
  private int turnPointer;
  private EstateCard murderEstate;
  private WeaponCard murderWeapon;
  private PlayerCard murderer;

  //Game Associations
  private List<Player> players;
  private Board board;
  private List<Card> cards;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Game(Board aBoard, Player... allPlayers)
  {
    turnPointer = 1;
    murderEstate = null;
    murderWeapon = null;
    murderer = null;
    players = new ArrayList<Player>();
    boolean didAddPlayers = setPlayers(allPlayers);
    if (!didAddPlayers)
    {
      throw new RuntimeException("Unable to create Game, must have 3 to 4 players. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (!setBoard(aBoard))
    {
      throw new RuntimeException("Unable to create Game due to aBoard. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    cards = new ArrayList<Card>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTurnPointer(int aTurnPointer)
  {
    boolean wasSet = false;
    turnPointer = aTurnPointer;
    wasSet = true;
    return wasSet;
  }

  public boolean setMurderEstate(EstateCard aMurderEstate)
  {
    boolean wasSet = false;
    murderEstate = aMurderEstate;
    wasSet = true;
    return wasSet;
  }

  public boolean setMurderWeapon(WeaponCard aMurderWeapon)
  {
    boolean wasSet = false;
    murderWeapon = aMurderWeapon;
    wasSet = true;
    return wasSet;
  }

  public boolean setMurderer(PlayerCard aMurderer)
  {
    boolean wasSet = false;
    murderer = aMurderer;
    wasSet = true;
    return wasSet;
  }

  public int getTurnPointer()
  {
    return turnPointer;
  }

  public EstateCard getMurderEstate()
  {
    return murderEstate;
  }

  public WeaponCard getMurderWeapon()
  {
    return murderWeapon;
  }

  public PlayerCard getMurderer()
  {
    return murderer;
  }
  /* Code from template association_GetMany */
  public Player getPlayer(int index)
  {
    Player aPlayer = players.get(index);
    return aPlayer;
  }

  public List<Player> getPlayers()
  {
    List<Player> newPlayers = Collections.unmodifiableList(players);
    return newPlayers;
  }

  public int numberOfPlayers()
  {
    int number = players.size();
    return number;
  }

  public boolean hasPlayers()
  {
    boolean has = players.size() > 0;
    return has;
  }

  public int indexOfPlayer(Player aPlayer)
  {
    int index = players.indexOf(aPlayer);
    return index;
  }
  /* Code from template association_GetOne */
  public Board getBoard()
  {
    return board;
  }
  /* Code from template association_GetMany */
  public Card getCard(int index)
  {
    Card aCard = cards.get(index);
    return aCard;
  }

  public List<Card> getCards()
  {
    List<Card> newCards = Collections.unmodifiableList(cards);
    return newCards;
  }

  public int numberOfCards()
  {
    int number = cards.size();
    return number;
  }

  public boolean hasCards()
  {
    boolean has = cards.size() > 0;
    return has;
  }

  public int indexOfCard(Card aCard)
  {
    int index = cards.indexOf(aCard);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPlayers()
  {
    return 3;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfPlayers()
  {
    return 4;
  }
  /* Code from template association_AddUnidirectionalMN */
  public boolean addPlayer(Player aPlayer)
  {
    boolean wasAdded = false;
    if (players.contains(aPlayer)) { return false; }
    if (numberOfPlayers() < maximumNumberOfPlayers())
    {
      players.add(aPlayer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean removePlayer(Player aPlayer)
  {
    boolean wasRemoved = false;
    if (!players.contains(aPlayer))
    {
      return wasRemoved;
    }

    if (numberOfPlayers() <= minimumNumberOfPlayers())
    {
      return wasRemoved;
    }

    players.remove(aPlayer);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_SetUnidirectionalMN */
  public boolean setPlayers(Player... newPlayers)
  {
    boolean wasSet = false;
    ArrayList<Player> verifiedPlayers = new ArrayList<Player>();
    for (Player aPlayer : newPlayers)
    {
      if (verifiedPlayers.contains(aPlayer))
      {
        continue;
      }
      verifiedPlayers.add(aPlayer);
    }

    if (verifiedPlayers.size() != newPlayers.length || verifiedPlayers.size() < minimumNumberOfPlayers() || verifiedPlayers.size() > maximumNumberOfPlayers())
    {
      return wasSet;
    }

    players.clear();
    players.addAll(verifiedPlayers);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPlayerAt(Player aPlayer, int index)
  {  
    boolean wasAdded = false;
    if(addPlayer(aPlayer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlayers()) { index = numberOfPlayers() - 1; }
      players.remove(aPlayer);
      players.add(index, aPlayer);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePlayerAt(Player aPlayer, int index)
  {
    boolean wasAdded = false;
    if(players.contains(aPlayer))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPlayers()) { index = numberOfPlayers() - 1; }
      players.remove(aPlayer);
      players.add(index, aPlayer);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPlayerAt(aPlayer, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setBoard(Board aNewBoard)
  {
    boolean wasSet = false;
    if (aNewBoard != null)
    {
      board = aNewBoard;
      wasSet = true;
    }
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCards()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addCard(Card aCard)
  {
    boolean wasAdded = false;
    if (cards.contains(aCard)) { return false; }
    cards.add(aCard);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeCard(Card aCard)
  {
    boolean wasRemoved = false;
    if (cards.contains(aCard))
    {
      cards.remove(aCard);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addCardAt(Card aCard, int index)
  {  
    boolean wasAdded = false;
    if(addCard(aCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCards()) { index = numberOfCards() - 1; }
      cards.remove(aCard);
      cards.add(index, aCard);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveCardAt(Card aCard, int index)
  {
    boolean wasAdded = false;
    if(cards.contains(aCard))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfCards()) { index = numberOfCards() - 1; }
      cards.remove(aCard);
      cards.add(index, aCard);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addCardAt(aCard, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    players.clear();
    board = null;
    cards.clear();
  }

  // line 15 "model.ump"
   public void createCards(){
    //estates
    addCard(new EstateCard(1, "Haunted House"));
    addCard(new EstateCard(2, "Manic Manor"));
    addCard(new EstateCard(3, "Visitation Villa"));
    addCard(new EstateCard(4, "Calamity Castle"));
    addCard(new EstateCard(5, "Peril Palace"));
    //weapons
    addCard(new WeaponCard(1, "Broom"));
    addCard(new WeaponCard(2, "Scissors"));
    addCard(new WeaponCard(3, "Knife"));
    addCard(new WeaponCard(4, "Shovel"));
    addCard(new WeaponCard(5, "iPad"));
    //players
    addCard(new PlayerCard(1, "Lucilla"));
    addCard(new PlayerCard(2, "Bert"));
    addCard(new PlayerCard(3, "Malina"));
    addCard(new PlayerCard(4, "Donald"));
    
    Collections.shuffle(cards);
  }

  // line 37 "model.ump"
   public static  void main(String... args){
    Player lucilla = new Player('l', "Lucilla", new Hand());
    Player bert = new Player('b', "Bert", new Hand());
    Player malina = new Player('m', "Johnny", new Hand());
    Player donald = new Player('d', "Donald", new Hand());
    
    Player[] playerList = {lucilla, bert, malina, donald};
    
    Board board = new Board(playerList);
    Game game = new Game(board, playerList);
    
    game.createCards();
    game.createMurder();
    game.distributeCards();
    game.createMap();
    
    board.draw();
    game.displayPlayer();
  }

  // line 57 "model.ump"
   public void displayPlayer(){
    Player p = getPlayer(turnPointer);
    
    System.out.println("\n<-------------------Player " + (getTurnPointer() + 1) + "------------------->");
    System.out.println("Name: " + p.getName() + "\n");
    System.out.println("Location: X: " + p.getLocation().getX() + " Y: " + p.getLocation().getY() + "\n");
    
    System.out.println("Estate Cards: " + p.getHand().getEstateCards());
    System.out.println("Weapon Cards: " + p.getHand().getWeaponCards());
    System.out.println("Player Cards: " + p.getHand().getPlayerCards());
  }

  // line 69 "model.ump"
   public void createMurder(){
    for(Card c : getCards()){
              if(c instanceof EstateCard && murderEstate == null){
                  setMurderEstate((EstateCard) c);
             }
               if(c instanceof WeaponCard && murderWeapon == null){
                  setMurderWeapon((WeaponCard) c);
             }
               if(c instanceof PlayerCard && murderer == null){
                  setMurderer((PlayerCard) c);
             }
        }
        System.out.println("Murder Estate: " + murderEstate);
        System.out.println("Murder Weapon: " + murderWeapon);
        System.out.println("Murder Player: " + murderer);
  }

  // line 86 "model.ump"
   public void distributeCards(){
    removeCard(murderEstate);
    removeCard(murderWeapon);
    removeCard(murderer);
    
    int cardReciever = (int) ((Math.random()) * 4);
    for(Card c : getCards()){
         getPlayer(cardReciever).getHand().addCard(c);
          cardReciever = cardReciever == (numberOfPlayers() - 1) ? 0 : cardReciever + 1;
    }
     addCard(murderEstate);
    addCard(murderWeapon);
    addCard(murderer);
  }

  // line 101 "model.ump"
   public void createMap(){
    board.initialize();
  }


  public String toString()
  {
    return super.toString() + "["+
            "turnPointer" + ":" + getTurnPointer()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "murderEstate" + "=" + (getMurderEstate() != null ? !getMurderEstate().equals(this)  ? getMurderEstate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "murderWeapon" + "=" + (getMurderWeapon() != null ? !getMurderWeapon().equals(this)  ? getMurderWeapon().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "murderer" + "=" + (getMurderer() != null ? !getMurderer().equals(this)  ? getMurderer().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "board = "+(getBoard()!=null?Integer.toHexString(System.identityHashCode(getBoard())):"null");
  }
}