/**
  *RamblersSearch.java
*/

public class RamblersSearch extends Search {

  private TerrainMap map; //map we're searching
  private Coords goal; //goal coords

  /**
    *Accessor returning the map
  */
  public TerrainMap getMap(){
    return map;
  }

  /**
    *Accessor returning the goal of the search
  */
  public Coords getGoal(){
    return goal;
  }

  /**
    *Constructor for the class RamblersSearch
  */
  public RamblersSearch(TerrainMap m, Coords g){
    map=m;
    goal=g;
  }

}
