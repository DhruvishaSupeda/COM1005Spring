import sheffield.*;
import java.util.*;

public class RunRamblersSearch{
  public static void main(String[] arg) {

    // create an EasyWriter

    EasyWriter screen = new EasyWriter();

    TerrainMap map1= new TerrainMap("tmx.pgm");
    //map1.mapFromFile("tmc.pgm");
    //screen.println(map1.toString());
    //screen.println(map1.getLinks("Start"));


    Coords start = new Coords(3,5);
    Coords goal = new Coords(7,14);
    //Gets initial cost from where it starts
    int[][] tmap = map1.getTmap();
    int initCost = tmap[start.gety()][start.getx()];

    RamblersSearch searcher = new RamblersSearch(map1,goal);
    SearchState initState = (SearchState) new RamblersState(start,initCost);

    //change from search1 - specify strategy
    //String res_df = searcher.runSearch(initState, "breadthFirst");
    //screen.println(res_df);
    //String res_bf = searcher.runSearch(initState, "depthFirst");
    //screen.println(res_bf);
    //String res_bb = searcher.runSearch(initState, "branchAndBound");
  //  screen.println(res_bb);

    String res_astar = searcher.runSearch(initState, "AStar");
    screen.println(res_astar);
  }
}
