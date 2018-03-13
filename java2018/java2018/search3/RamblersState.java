import java.util.*;

public class RamblersState extends SearchState {
  private Coords coords1;
  private Coords coords2;
  private int localCost;

  public RamblersState(Coords c1, Coords c2, int lc){
    coords1=c1;
    coords2=c2;
    localCost=lc;
  }

  //accessor
  public int getLocalCost() {
    return localCost;
  }

  public Coords getCoords1(){
    return coords1;
  }

  public Coords getCoords2(){
    return coords2;
  }

  public boolean compareCoords(Coords coord1, Coords coord2) {
    if (coords1.getx() == coords2.getx()) {
      if (coords1.gety() == coords2.gety())
        return true;
    }
    else {
      return false;
  }
  }

  // goalP
  public boolean goalP(Search searcher) {
    RamblersSearch rsearcher = (RamblersSearch) searcher;
    Coords tar = rsearcher.getGoal(); // get target
    return compareCoords(coords1,tar);
  }

  // getSuccessors
  public ArrayList<SearchState> getSuccessors (Search searcher) {
    RamblersSearch rsearcher = (RamblersSearch) searcher;
    TerrainMap map = rsearcher.getMap();
  //  ArrayList<CoordsLink> links=map.getLinks(coords1);
    //int[][] links=map.getTmap();
    ArrayList<SearchState> succs=new ArrayList<SearchState>();

    //CoordsLink one = new CoordsLink();

    /*for (CoordsLink one: links) {
    	  Coords scoords;
        if (compareCoords(coords1, coords2)) {
          scoords=one.getCoords2();
        }
        else {
          scoords=one.getCoords1();};
          succs.add((SearchState)new RamblersState(scoords,coords1,one.getCost()));
        }*/
    return succs;
  }


  // sameState
  public boolean sameState(SearchState s2) {
    RamblersState rs2= (RamblersState)s2;
    return compareCoords(coords1, rs2.getCoords1());
  }
}
