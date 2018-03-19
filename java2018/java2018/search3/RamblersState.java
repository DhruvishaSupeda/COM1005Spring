import java.util.*;

/**
*RamblersState.java
*/
public class RamblersState extends SearchState {
  private Coords coords;
  private int localCost;

  //Constructor
  public RamblersState(Coords c, int lc){
    coords=c;
    localCost=lc;
  }

  //Accessors
  public int getLocalCost() {
    return localCost;
  }

  public Coords getCoords(){
    return coords;
  }

  /**
  *Compares two coordinate objects
  *Returns true if they are equal, otherwise returns false
  *@param coords2 the second pair of coordinates being compared
  */
  public boolean compareTo(Coords coords2) {
    return (coords.getx() == coords2.getx()) && (coords.gety() == coords2.gety());
  }

  /**
  * Gets the goal and compares it to the target of the search1
  *@param searcher
  */
  public boolean goalP(Search searcher) {
    RamblersSearch rsearcher = (RamblersSearch) searcher;
    Coords tar = rsearcher.getGoal(); // get target
    return this.compareTo(tar);
  }

  /**
  * Works out the local cost of moving from one coordinate to another
  *@param coords1 the current coordinates
  *@param coords2 the coordinate that can be added to the succcessors
  *@param tmap the array of local costs on the map
  */
  public int localCost(Coords coords1, Coords coords2, int[][] tmap) {
    //If the height decreases, the cost is 1
    if ((coords2.getx()<=coords1.getx()) && (coords2.gety()<=coords1.gety())) {
      return 1;
    }
    else
    //Otherwise, the cost is 1 plus the height difference
      return 1 + Math.abs(tmap[coords2.gety()][coords2.getx()]-tmap[coords1.gety()][coords1.getx()]);
  }

  /**
  *Adds a state to the ArrayList of states if in range and not previously visited
  *@param i the current value needing to be added to the coordinates
  *@param succs the ArrayList of successors
  *@param nap the TerrainMap being searched
  *@param tmap the array of the local costs of the map
  */
  public void addToState(int i, ArrayList<SearchState> succs, TerrainMap map, int[][] tmap) {
    //Initialises the coordinates to be checked and added
    Coords coords1 = new Coords(coords.gety()+i,coords.getx());
    Coords coords2 = new Coords(coords.gety(),coords.getx()+i);

    //Checks if the coordinates are in range
    if (((coords1.getx())>=0 && coords1.getx()<map.getWidth()) && (coords1.gety()>=0 && coords1.gety()<map.getDepth())){
      //Makes a new state with the coordinates and local cost
      RamblersState state1 = new RamblersState(coords1, localCost(coords,coords1,tmap));
      //Adds the state to the ArrayList
      succs.add(state1);
    }

    if (((coords2.getx()>= 0 && coords2.getx()<map.getWidth()) && ((coords2.gety())>=0 && (coords2.gety())<map.getDepth()))){
      RamblersState state2 = new RamblersState(coords2, localCost(coords,coords2,tmap));
      succs.add(state2);
    }
  }

  /**
  *Gets successors of the current state and adds it to the ArrayList of successors
  *@param searcher
  */
  public ArrayList<SearchState> getSuccessors (Search searcher) {
    //Initialises map and ArrayList
    RamblersSearch rsearcher = (RamblersSearch)searcher;
    TerrainMap map = rsearcher.getMap();
    int[][] tmap = map.getTmap();
    ArrayList<SearchState> succs=new ArrayList<SearchState>();

    //Sets values of i to be added to coordinates and calles addToState
    int i=-1;
    addToState(i,succs,map,tmap);
    i=1;
    addToState(i,succs,map,tmap);

    return succs;
  }


  /**
  *Checks if two states are the same
  *@param s2 the second state to be compared
  */
  public boolean sameState(SearchState s2) {
    RamblersState rs2= (RamblersState)s2;
    return this.compareTo(rs2.getCoords());
  }

  public String toString() {
    return ("Location:" + coords.gety() + ", " + coords.getx());
  }
}
