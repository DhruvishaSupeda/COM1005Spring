public class RamblersSearch extends Search {

  private TerrainMap map; //map we're searching
  private Coords goal; //goal coords

  public TerrainMap getMap(){
    return map;
  }
  public int getGoalX(){
    return goal.getx();
  }
  public int getGoalY(){
    return goal.gety();
  }
  public Coords getGoal(){
    return goal;
  }

  public RamblersSearch(TerrainMap m, Coords g){
    map=m;
    goal=g;
  }

}
