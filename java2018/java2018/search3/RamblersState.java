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
    }
    else {
      return false;
    }
  }

  // goalP
  public boolean goalP(Search searcher) {
    RamblersSearch rsearcher = (RamblersSearch) searcher;
    Coords tar = rsearcher.getGoal(); // get target
    return compareTo(tar);
  }

  // getSuccessors
  public ArrayList<SearchState> getSuccessors (Search searcher) {
    RamblersSearch rsearcher = (RamblersSearch) searcher;
    TerrainMap map = rsearcher.getMap();
    int[][] tmap = map.getTmap();
    ArrayList<SearchState> succs=new ArrayList<SearchState>();

    Coords coords1 = new Coords(0,0);
    Coords coords2 = new Coords(0,0);

      for(int i=-1; i<2; i+=2){
        coords1 = new Coords(coords.getx()+i,coords.gety());
        coords2 = new Coords(coords.getx(),coords.gety()+i);

        if ((coords1.getx()>= 0 && coords1.getx()<=15) && (coords1.gety()>=0 && coords1.gety()<=15)){
          RamblersState state1 = new RamblersState(coords1, tmap[coords.gety()][coords.getx()+i]);
          if (!sameState(state1)) {
            succs.add(state1);
          }
        }
        if ((coords2.getx()>= 0 && coords2.getx()<=15) && (coords2.gety()>=0 && coords2.gety()<=15)){
          RamblersState state2 = new RamblersState(coords2, tmap[coords.gety()+i][coords.getx()]);
          if (!sameState(state2)) {
            succs.add(state2);
          }
        }

        //succs.add(new RamblersState(new Coords(coords.getx()+i, coords.gety(),  map[coords.gety()][coords.getx()+i)]));
        //succs.add(new RamblersState(new Coords(coords.getx(), coords.gety()+i,  map[coords.gety()+i][coords.getx())]));
      }

    return succs;
  }


  // sameState
  public boolean sameState(SearchState s2) {
    RamblersState rs2= (RamblersState)s2;
    return this.compareTo(rs2.getCoords());
  }
}
