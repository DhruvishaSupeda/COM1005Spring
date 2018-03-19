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
    Coords goal = new Coords(12,12);
    //Gets initial cost from where it starts
    int[][] tmap = map1.getTmap();
    int initCost = tmap[start.gety()][start.getx()];
    int estRemCost = (goal.getx()-start.getx())+(goal.gety()-start.gety()); //Manhattan Distance
    //Euclidean distance:
    //int estRemCost = (int)(Math.sqrt(java.lang.Math.pow(goal.getx()-start.getx(),2) + (java.lang.Math.pow(goal.getx()-start.getx(),2))));

    //int estRemCost = goal.getHeight()-coords.getHeight();

    RamblersSearch searcher = new RamblersSearch(map1,goal);
    SearchState initState = (SearchState) new RamblersState(start,initCost, estRemCost);

    String res_astar = searcher.runSearch(initState, "AStar");
    screen.println(res_astar);
  }
}
