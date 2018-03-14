public class CoordsLink {
  private Coords coords1;
  private Coords coords2;
  private int cost;

  public  CoordsLink(Coords c1, Coords c2, int c){
    coords1=c1;
    coords2=c2;
    cost=c;
  }
  
  public Coords getCoords1(){return coords1;}
  public Coords getCoords2(){return coords2;}
  public int getCost() {return cost;}

  public String toString() {return coords1+ " <--> "+coords2+" "+ cost;}

}
