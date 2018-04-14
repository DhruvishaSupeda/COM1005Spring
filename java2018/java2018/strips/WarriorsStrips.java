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
                                    "Warrior in ?p1|?obj in ?p1",
                                    "Warrior in ?p1|?obj in ?p1");
    StripsOp ladder = new StripsOp("pickup treasure in P using ladder",
                                    "pickup treasure in P",
                                    "treasure in P",
                                    "Warrior in P|treasure in P|snake notin P");//Dudt carry object?
    StripsOp hookRope = new StripsOp("pickup treasure in P using rope",
                                    "pickup treasure in P",
                                    "treasure in P",
                                    "Warrior in R|treasure in P|hook in R|rope in R|snake in P");//Dudt carry object?

    ArrayList<StripsOp> warriorOps = new ArrayList<StripsOp>();
    warriorOps.add(move);
    warriorOps.add(carry);
    warriorOps.add(ladder);
    warriorOps.add(hookRope);

    //create instance of Strips1, give it the operators, init state & goal state

    Strips1 str=new Strips1(warriorOps,
                            new MStringVector("Warrior in W|treasure in P|snake in P|hook in H|rope in R"),
                            new MStringVector("Warrior in R|pickup treasure in P"));//CHANGE GOAL STATE


    //run Strips
    boolean res=str.run();
    scr.println("Result is "+res); //result
    scr.println("Plan is   "+str.getPlan()); //plan

}
}
