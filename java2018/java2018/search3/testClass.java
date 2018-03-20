

public class testClass {

    public void testCompareTo() {
      Coords coords1 = new Coords(3,4);
      Coords coords2 = new Coords(3,4);
      Coords coords3 = new Coords(5,7);
      RamblersState state = new RamblersState(coords1, 1);

      System.out.println("Equal coords test: " + coords1.compareTo(coords2));
      System.out.println("Not equal coords test: " + coords1.compareTo(coords3));

    }

    public static void main(String[] arg) {
      testCompareTo();
    }

}
