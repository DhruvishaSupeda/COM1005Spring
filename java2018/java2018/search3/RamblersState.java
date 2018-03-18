import java.util.*;
/**
*RamblersState.java
*/
public class RamblersState extends SearchState {
  private Coords coords;
  private int localCost;

  public RamblersState(Coords c, int lc){
    coords=c;
    localCost=lc;
  }

  //accessor
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
  *Adds a state to the ArrayList of states if in range and not previously visited
  *@param i the current value needing to be added to the coordinates
  *@param succs the ArrayList of succcessors
  *@param nap the TerrainMap being searched
  *@param tmap the array of the local costs of the map
  */
  public void addToState(int i, ArrayList<SearchState> succs, TerrainMap map, int[][] tmap) {
    //Initialises the coordinates to be checked and added
    Coords coords1 = new Coords(coords.getx()+i,coords.gety());
    Coords coords2 = new Coords(coords.getx(),coords.gety()+i);

    //Checks if the coordinates are in range
    if (((coords1.getx()+i)>= 0 && (coords1.getx()+i)<map.getWidth()) && (coords1.gety()>=0 && coords1.gety()<map.getDepth())){
      //Makes a new state with the coordinates and local cost
      RamblersState state1 = new RamblersState(coords1, tmap[coords.gety()][coords.getx()+i]);
      //Adds the state to the ArrayList
      succs.add(state1);
    }

    if (((coords2.getx()>= 0 && coords2.getx()<map.getWidth()) && ((coords2.gety()+i)>=0 && (coords2.gety()+i)<map.getDepth()))){
      RamblersState state2 = new RamblersState(coords2, tmap[coords.gety()+i][coords.getx()]);
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
}
