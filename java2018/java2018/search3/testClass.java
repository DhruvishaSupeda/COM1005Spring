import java.util.*;

public class TestClass {

    public static void testCompareTo() {
      Coords coords1 = new Coords(3,4);
      Coords coords2 = new Coords(3,4);
      Coords coords3 = new Coords(5,7);
      RamblersState state = new RamblersState(coords1, 1);

      if (state.compareTo(coords2))
          System.out.println("Equal coords: true");
      else
          System.out.println("Equal coords: false");

      if (!(state.compareTo(coords3)))
          System.out.println("Not equal coords test: true");
      else
          System.out.println("Not equal coords test: false");
    }

    public static void testLocalCost() {
      Coords coords1 = new Coords(3,4);
      Coords coords2 = new Coords(5,7);
      Coords coords3 = new Coords(7,7);
      RamblersState state = new RamblersState(coords1, 1);
      TerrainMap map1= new TerrainMap("tmx.pgm");
      int[][] tmap = map1.getTmap();

      if (state.localCost(coords1,coords2,tmap) == 1)
        System.out.println("Local cost downhill: true");
      else
        System.out.println("Local cost downhill: false");

      if (state.localCost(coords1,coords3,tmap) != 1)
        System.out.println("Local cost uphill: true");
      else
        System.out.println("Local cost downhill: false");
    }


    public static void testSameState() {
      Coords coords1 = new Coords(3,4);
      Coords coords2 = new Coords(7,7);
      RamblersState state1 = new RamblersState(coords1, 1);
      RamblersState state2 = new RamblersState(coords1, 1);
      RamblersState state3 = new RamblersState(coords2, 7);

      if (state1.sameState(state2))
        System.out.println("Same state: true");
      else
        System.out.println("Same state: false");

      if (!(state1.sameState(state3)))
        System.out.println("Different state: true");
      else
        System.out.println("Different state: false");
    }

    public static void testGetSuccessors() {
      //ArrayList<SearchState> succs=new ArrayList<SearchState>();
      Coords coords1 = new Coords(3,4);
      Coords coords2 = new Coords(0,4);
      RamblersState state1 = new RamblersState(coords1, 1);
      RamblersState state2 = new RamblersState(coords2, 1);
      TerrainMap map1= new TerrainMap("tmx.pgm");
      RamblersSearch searcher = new RamblersSearch(map1,coords1);

      if ((state1.getSuccessors(searcher)).size() == 4)
        System.out.println("Get successors middle: true");
      else
        System.out.println("Get successors middle: true");

      if ((state2.getSuccessors(searcher)).size() == 3) {
        System.out.println("Get successors edge: true");
      }
      else
        System.out.println("Get successors edge: false");
    }

    public static void testGoalP() {
      Coords coords1 = new Coords(3,4);
      Coords coords2 = new Coords(0,4);
      RamblersState state1 = new RamblersState(coords1, 1);
      RamblersState state2 = new RamblersState(coords2, 1);
      TerrainMap map1= new TerrainMap("tmx.pgm");
      RamblersSearch searcher = new RamblersSearch(map1,coords1);

      if (state1.goalP(searcher))
        System.out.println("Goal equal: true");
      else
        System.out.println("Goal equal: false");

      if (!(state2.goalP(searcher)))
        System.out.println("Goal not equal: true");
      else
        System.out.println("Goal not equal: false");
    }

    public static void main(String[] arg) {
      testCompareTo();
      testLocalCost();
      testSameState();
      testGetSuccessors();
      testGoalP();
    }

}
