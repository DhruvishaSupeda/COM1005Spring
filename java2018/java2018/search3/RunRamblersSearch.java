import sheffield.*;
import java.util.*;


public class RunRamblersSearch{
  public static void main(String[] arg) {

    // create an EasyWriter

    EasyWriter screen = new EasyWriter();

    TerrainMap map1= new TerrainMap("tmc.pgm");
    //map1.mapFromFile("tmc.pgm");
    //screen.println(map1.toString());
    //screen.println(map1.getLinks("Start"));

    Coords start = new Coords(0,7);
    Coords end = new Coords(200,200);
    Coords goal = new Coords(100,100);
    RamblersSearch searcher = new RamblersSearch(map1,goal);
    SearchState initState = (SearchState) new RamblersState(start,end,7);

    //change from search1 - specify strategy
    //String res_df = searcher.runSearch(initState, "breadthFirst");
    //screen.println(res_df);
    //String res_bf = searcher.runSearch(initState, "depthFirst");
    //screen.println(res_bf);
    String res_bb = searcher.runSearch(initState, "branchAndBound");
    screen.println(res_bb);
  }
}
