/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.32.1.6535.66c005ced modeling language!*/


import java.util.*;

// line 106 "model.ump"
// line 250 "model.ump"
public class Board
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Board Associations
  private List<Tile> tiles;
  private List<Player> players;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Board(Player... allPlayers)
  {
    tiles = new ArrayList<Tile>();
    players = new ArrayList<Player>();
    boolean didAddPlayers = setPlayers(allPlayers);
    if (!didAddPlayers)
    {
      throw new RuntimeException("Unable to create Board, must have 3 to 4 players. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Tile getTile(int index)
  {
    Tile aTile = tiles.get(index);
    return aTile;
  }

  public List<Tile> getTiles()
  {
    List<Tile> newTiles = Collections.unmodifiableList(tiles);
    return newTiles;
  }

  public int numberOfTiles()
  {
    int number = tiles.size();
    return number;
  }

  public boolean hasTiles()
  {
    boolean has = tiles.size() > 0;
    return has;
  }

  public int indexOfTile(Tile aTile)
  {
    int index = tiles.indexOf(aTile);
    return index;
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
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTiles()
  {
    return 0;
  }
  /* Code from template association_AddManyToOptionalOne */
  public boolean addTile(Tile aTile)
  {
    boolean wasAdded = false;
    if (tiles.contains(aTile)) { return false; }
    Board existingBoard = aTile.getBoard();
    if (existingBoard == null)
    {
      aTile.setBoard(this);
    }
    else if (!this.equals(existingBoard))
    {
      existingBoard.removeTile(aTile);
      addTile(aTile);
    }
    else
    {
      tiles.add(aTile);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeTile(Tile aTile)
  {
    boolean wasRemoved = false;
    if (tiles.contains(aTile))
    {
      tiles.remove(aTile);
      aTile.setBoard(null);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTileAt(Tile aTile, int index)
  {  
    boolean wasAdded = false;
    if(addTile(aTile))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTiles()) { index = numberOfTiles() - 1; }
      tiles.remove(aTile);
      tiles.add(index, aTile);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTileAt(Tile aTile, int index)
  {
    boolean wasAdded = false;
    if(tiles.contains(aTile))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTiles()) { index = numberOfTiles() - 1; }
      tiles.remove(aTile);
      tiles.add(index, aTile);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTileAt(aTile, index);
    }
    return wasAdded;
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

  public void delete()
  {
    while( !tiles.isEmpty() )
    {
      tiles.get(0).setBoard(null);
    }
    players.clear();
  }

  // line 111 "model.ump"
   public void initialize(){
    for(int y = 0; y < 24; y++){
      for(int x = 0; x < 24; x++){
        
        Tile t = new Tile(x, y, assignLetter(x, y));
        t = assignPlayer(x, y, 14, 1, 0, t);
        t = assignPlayer(x, y, 1, 9, 1, t);
        t = assignPlayer(x, y, 9, 22, 2, t);
        t = assignPlayer(x, y, 22, 14, 3, t);
        addTile(t);
      }
    }
  }

  // line 125 "model.ump"
   public Tile assignPlayer(int X, int Y, int x, int y, int n, Tile t){
    if(X == x && Y == y){
      Player p = getPlayer(n);
      t.setLetter(p.getName().toCharArray()[0]); 
      p.setLocation(t);
    }
    return t;
  }

  // line 134 "model.ump"
   public char assignLetter(int x, int y){
    if(x > 1 && x < 7 && y > 1 && y < 7){
      return 'H';
    }
    if(x > 16 && x < 22 && y > 1 && y < 7){
      return 'M';
    }
    if(x > 1 && x < 7 && y > 16 && y < 22){
      return 'C';
    }
    if(x > 16 && x < 22 && y > 16 && y < 22){
      return 'P';
    }
    if(x > 8 && x < 15 && y > 9 && y < 14){
        return 'V';  
    }
    if((x > 4 && x < 7 && y > 10 && y < 13) ||
       (x > 16 && x < 19 && y > 10 && y < 13) ||
       (x > 10 && x < 13 && y > 4 && y < 7) ||
       (x > 10 && x < 13 && y >16 && y < 19)){
         return 'G'; 
    }
    return ' ';
  }

  // line 159 "model.ump"
   public void draw(){
    System.out.println("<----------------------MAP---------------------->\n");
    
    for(int z = 0; z < 25; z++) { System.out.print("__"); }
    System.out.println();
    
        for(int y = 0; y < 24; y++){
       for(int x = 0; x < 24; x++){
         
         if(x == 0){ System.out.print("|"); }
         
         Tile t = getTile((y * 24) + x);
         System.out.print(t + "|");
       }
       System.out.println();
     }
  }

}