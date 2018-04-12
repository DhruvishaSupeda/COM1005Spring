import sheffield.*;
import java.util.*;

public class RunRamblersSearch{
  public static void main(String[] arg) {

    EasyWriter screen = new EasyWriter();

    TerrainMap map1= new TerrainMap("tmx.pgm");

    Coords start = new Coords(7,0);
    Coords goal = new Coords(5,8);
    //Gets initial cost from where it starts
    int[][] tmap = map1.getTmap();
    int initCost = tmap[start.gety()][start.getx()];
    //Initialises intitial estimated remaining cost to be passed into the initial state
    int initEstRemCost = 0;


    //Creates the new search and initial state
    RamblersSearch searcher = new RamblersSearch(map1,goal);
    SearchState initState = (SearchState) new RamblersState(start,initCost, initEstRemCost);

    //Runs the search
    String res_astar = searcher.runSearch(initState, "AStar");
    screen.println(res_astar);
  }
}
