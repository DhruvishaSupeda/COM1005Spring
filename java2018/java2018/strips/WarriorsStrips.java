import pmatch.*;
import sheffield.*;
import java.io.*;
import java.util.*;

public class WarriorsStrips{
  public static void main(String[] args) {
    EasyWriter scr=new EasyWriter();

    //Ladder operator to lower the ladder into the pit P
    StripsOp ladder = new StripsOp("put ladder into P",
                                    "can pickup treasure",
                                    "",
                                    "snake not in P|ladder in P|Warrior in P");

    //hookRope operator to lower the now-joined hook and rope into the pit P
    StripsOp hookRope = new StripsOp("put hookRope into P",
                                    "can pickup treasure",
                                    "",
                                    "hook created|snake in P|hookRope in R|Warrior in R");

    //Move operator to move the Warrior from one place to another
    StripsOp move = new StripsOp("move from ?r1 to ?r2",
                                   "Warrior in ?r2",
                                   "Warrior in ?r1",
                                   "Warrior in ?r1");

    //Carry operator for the Warrior to carry one object from one place to another and remaining in that second place
    StripsOp carry = new StripsOp("carry ?obj from ?r1 to ?r2",
                                    "Warrior in ?r2|?obj in ?r2",
                                    "Warrior in ?r1|?obj in ?r1",
                                    "?obj in ?r1|Warrior in ?r1");

    //hookCreate operator to join the hook and rope to make one object
    StripsOp hookCreate = new StripsOp("create hookRope",
                                    "hook created|hookRope in R",
                                    "",
                                    "hook in R|rope in R|Warrior in R");
    StripsOp pickup = new StripsOp("pickup treasure",
                                    "picked up treasure",
                                    "can pickup treasure",
                                    "can pickup treasure");


    ArrayList<StripsOp> warriorOps = new ArrayList<StripsOp>();

    warriorOps.add(ladder);
    warriorOps.add(hookRope);
    warriorOps.add(move);
    warriorOps.add(carry);
    warriorOps.add(hookCreate);
    warriorOps.add(pickup);

    //create instance of Strips1, give it the operators, init state & goal state

    Strips1 str=new Strips1(warriorOps,
                            new MStringVector("Warrior in W|treasure in P|hook in H|rope in R|ladder in L|snake in P"),
                            new MStringVector("picked up treasure"));


    //run Strips
    boolean res=str.run();
    scr.println("Result is "+res); //result
    scr.println("Plan is   "+str.getPlan()); //plan

}
}
