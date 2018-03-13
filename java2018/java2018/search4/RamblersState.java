import java.util.*;

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

  public boolean compareTo(Coords coords2) {
    if (coords.getx() == coords2.getx()) {
      if (coords.gety() == coords2.gety())
        return true;
      else
        return false;
    }
    else {
      return false;
    }
  }

  // goalP
  public boolean goalP(Search searcher) {
    RamblersSearch rsearcher = (RamblersSearch) searcher;
    Coords tar = rsearcher.getGoal(); // get target
    return this.compareTo(tar);
  }

  // getSuccessors
  public ArrayList<SearchState> getSuccessors (Search searcher) {
    RamblersSearch rsearcher = (RamblersSearch)searcher;
    TerrainMap map = rsearcher.getMap();
    int[][] tmap = map.getTmap();
    ArrayList<SearchState> succs=new ArrayList<SearchState>();

//CHANGE UPSO NOT SIMILAR TO HARRISON
      for(int i=-1; i<2; i+=2) {
        Coords coords1 = new Coords(coords.getx()+i,coords.gety());
        Coords coords2 = new Coords(coords.getx(),coords.gety()+i);

        if (((coords1.getx()+i)>= 0 && (coords1.getx()+i)<map.getWidth()) && (coords1.gety()>=0 && coords1.gety()<map.getDepth())){
          RamblersState state1 = new RamblersState(coords1, tmap[coords.gety()][coords.getx()+i]);
        //  if (!sameState(state1)) {
            succs.add(state1);
      //    }
        }
        if ((coords2.getx()>= 0 && coords2.getx()<map.getWidth() && ((coords2.gety()+i)>=0 && (coords2.gety()+i)<map.getDepth()))){
          RamblersState state2 = new RamblersState(coords2, tmap[coords.gety()+i][coords.getx()]);
        //  if (!sameState(state2)) {
            succs.add(state2);
        //  }
        }
      }

    return succs;
  }


  // sameState
  public boolean sameState(SearchState s2) {
    RamblersState rs2= (RamblersState)s2;
    return this.compareTo(rs2.getCoords());
  }
}
