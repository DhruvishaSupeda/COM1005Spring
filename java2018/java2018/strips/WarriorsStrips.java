import pmatch.*;
import sheffield.*;
import java.io.*;
import java.util.*;

public class WarriorsStrips{
  public static void main(String[] args) {
    EasyWriter scr=new EasyWriter();

    StripsOp move = new StripsOp("move from ?p1 to ?p2",
                                   "Warrior in ?p2",
                                   "Warrior in ?p1",
                                   "Warrior in ?p1");
    StripsOp carry = new StripsOp("carry ?obj from ?p1 to ?p2",
                                    "Warrior in ?p2|?obj in ?p2",
                                    "Warrior in ?P1|?obj in ?p1",
                                    "Warrior in ?P1|?obj in ?p1|not carrying any object?????"); //HOW TO REPRESENT???
    //StripsOp ladder = new StripsOp~("")

    ArrayList<StripsOp> warriorOps = new ArrayList<StripsOp>();
    warriorOps.add(move);
    warriorOps.add(carry);

    //create instance of Strips1, give it the operators, init state & goal state

    Strips1 str=new Strips1(warriorOps,
                            new MStringVector("Warrior in W|treasure in P|snake in P"),
                            new MStringVector("Warrior in P"));


    //run Strips
    boolean res=str.run();
    scr.println("Result is "+res); //result
    scr.println("Plan is   "+str.getPlan()); //plan

}
}
