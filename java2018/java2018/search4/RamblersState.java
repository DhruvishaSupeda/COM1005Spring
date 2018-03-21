import java.util.*;

/**
*RamblersState.java
*/
public class RamblersState extends SearchState {
  private Coords coords;
  private int localCost;

  //Constructor
  public RamblersState(Coords c, int lc, int erc){
    coords=c;
    localCost=lc;
    estRemCost=erc;
  }

  //Accessors
  public int getLocalCost() {
    return localCost;
  }

  public Coords getCoords(){
    return coords;
  }

  /*public int getEstCost() {
    return estRemCost;
  }*/

  /**
  *Compares two coordinate objects
  *Returns true if they are equal, otherwise returns false
  *@param coords2 the second pair of coordinates being compared
  */
  public boolean compareTo(Coords coords2) {
    return (coords.getx() == coords2.getx()) && (coords.gety() == coords2.gety());
  }

  /**
  * Gets the goal and compares it to the target of the search
  *@param searcher
  */
  public boolean goalP(Search searcher) {
    RamblersSearch rsearcher = (RamblersSearch)searcher;
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
    if (tmap[coords2.gety()][coords2.getx()] <= tmap[coords1.gety()][coords1.getx()]) {
      return 1;
    }
    else
    //Otherwise, the cost is 1 plus the height difference
      return 1 + Math.abs(tmap[coords2.gety()][coords2.getx()]-tmap[coords1.gety()][coords1.getx()]);
  }

  public int estRemCost(Coords goal, Coords coords4, int[][] tmap){
    //Manhattan
    //return Math.abs(goal.getx()-coords.getx()) + Math.abs(goal.gety()-coords.gety());

    //Euclidaifod'l
    //return (int)(Math.sqrt(Math.pow(goal.gety()-coords.gety(),2) + (Math.pow(goal.getx()-coords.getx(),2))));
    //int euclidian = (int)(Math.sqrt(Math.pow(goal.gety()-coords.gety(),2) + (Math.pow(goal.getx()-coords.getx(),2))));

    //Height difference
    //System.out.println("HELP" + Math.abs(tmap[coords4.gety()][coords4.getx()] - tmap[goal.gety()][goal.getx()]));
    return Math.abs(tmap[coords4.gety()][coords4.getx()] - tmap[goal.gety()][goal.getx()]);
    return localCost(coords,goal,tmap);
    //int height = Math.abs(tmap[coords.gety()][coords.getx()] - tmap[goal.gety()][goal.getx()]);

    //return (int)Math.sqrt(Math.pow(goal.gety()-coords.gety(),2) + Math.pow(goal.getx()-coords.getx(),2) +
    //  Math.pow(tmap[coords.gety()][coords.getx()] - tmap[goal.gety()][goal.getx()],2) );
    //return (int)Math.sqrt(Math.pow(euclidian,2)+ Math.pow(height,2));

    //return Math.abs(goal.getx()-coords.getx()) + Math.abs(goal.gety()-coords.gety() +
    //  (tmap[coords.gety()][coords.getx()] - tmap[goal.gety()][goal.getx()]));
  }

  /**
  *Adds a state to the ArrayList of states if in range and not previously visited
  *@param i the current value needing to be added to the coordinates
  *@param succs the ArrayList of succcessors
  *@param map the TerrainMap being searched
  *@param tmap the array of the local costs of the map
  */
  public void addToState(int i, ArrayList<SearchState> succs, TerrainMap map, int[][] tmap,RamblersSearch rsearcher) {
    //Initialises the coordinates and goal to be checked and added
    Coords coords1 = new Coords(coords.gety()+i,coords.getx());
    Coords coords2 = new Coords(coords.gety(),coords.getx()+i);
    Coords goal = rsearcher.getGoal();

    //Checks if the coordinates are in range
    if (((coords1.getx()+i)>= 0 && (coords1.getx()+i)<map.getWidth()) && (coords1.gety()>=0 && coords1.gety()<map.getDepth())){
      RamblersState state1 = new RamblersState(coords1, localCost(coords,coords1,tmap), estRemCost(goal, coords1,tmap));
      //Adds the state to the ArrayList
      succs.add(state1);
    }
    if (((coords2.getx()>= 0 && coords2.getx()<map.getWidth()) && ((coords2.gety()+i)>=0 && (coords2.gety()+i)<map.getDepth()))){
      RamblersState state2 = new RamblersState(coords2, localCost(coords,coords2,tmap), estRemCost(goal, coords2,tmap));
        succs.add(state2);
    }
  }

  /**
  *Gets successors of the current state and adds it to the ArrayList of successors
  *@param searcher
  */
  public ArrayList<SearchState> getSuccessors (Search searcher) {
    RamblersSearch rsearcher = (RamblersSearch)searcher;
    TerrainMap map = rsearcher.getMap();
    int[][] tmap = map.getTmap();
    ArrayList<SearchState> succs=new ArrayList<SearchState>();

    int i=-1;
    addToState(i,succs,map,tmap,rsearcher);
    i=1;
    addToState(i,succs,map,tmap,rsearcher);

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
