import java.util.*;

public class RamblersState extends SearchState {
  private Coords coords;
  private Coords coords1;
  private Coords coords2;
  private int localCost;

  public RamblersState(Coords ncoords, Coords c1, Coords c2, int lc){
    coords = ncoords;
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

  // goalP
  public boolean goalP(Search searcher) {
    RamblersSearch rsearcher = (RamblersSearch) searcher;
    String tar = rsearcher.getGoal(); // get target
    return (coords.compareTo(tar)== 0);
  }

  // getSuccessors
  public ArrayList<SearchState> getSuccessors (Search searcher) {
    RamblersSearch rsearcher = (RamblersSearch) searcher;
    TerrainMap map = rsearcher.getMap();
    ArrayList<CoordsLink> links=map.getLinks(coords);
    ArrayList<SearchState> succs=new ArrayList<SearchState>();

  //  CoordsLink one = new CoordsLink();

    for (CoordsLink one: links) {
    	String scoords;
        if (coords.compareTo(one.getCoords1())==0) {
          scoords=one.getCoords2();
        }
        else {
          scoords=one.getCoords1();};
          succs.add((SearchState)new RamblersState(scoords,one.getLocalCost()));
        }
    return succs;
    }

  // sameState

  public boolean sameState(SearchState s2) {
    RamblersState rs2= (RamblersState) s2;
    return (coords.compareTo(rs2.getCoords())==0);
  }
}
