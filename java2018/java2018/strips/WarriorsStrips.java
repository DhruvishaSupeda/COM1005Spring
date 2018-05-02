import pmatch.*;
import sheffield.*;
import java.io.*;
import java.util.*;

public class WarriorsStrips{
  public static void main(String[] args) {
    EasyWriter scr=new EasyWriter();


    StripsOp ladder = new StripsOp("put ladder into P",
                                    "can pickup treasure",
                                    "",
                                    "snake not in P|ladder in P|Warrior in P");
    StripsOp hookRope = new StripsOp("put hook and rope into P",
                                    "can pickup treasure",
                                    "",
                                    "hook created|snake in P|Warrior in R");
    StripsOp move = new StripsOp("move from ?r1 to ?r2",
                                   "Warrior in ?r2",
                                   "Warrior in ?r1",
                                   "Warrior in ?r1");

    //Operator to carry an object from place 1 to place 2, moving the Warrior in the process too
    StripsOp carry = new StripsOp("carry ?obj from ?r1 to ?r2",
                                    "Warrior in ?r2|?obj in ?r2",
                                    "Warrior in ?r1|?obj in ?r1",
                                    "?obj in ?r1|Warrior in ?r1");
    StripsOp hookCreate = new StripsOp("create hookRope",
                                    "hook created|hookRope in R",
                                    "",
                                    "hook in R|rope in R|Warrior in R");
    StripsOp pickup = new StripsOp("pickup treasure",
                                    "picked up treasure",
                                    "",
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
                            new MStringVector("Warrior in W|treasure in P|hook in H|rope in R|ladder in L|snake not in P"),
                            new MStringVector("picked up treasure"));//CHANGE GOAL STATE //Warrior in R|


    //run Strips
    boolean res=str.run();
    scr.println("Result is "+res); //result
    scr.println("Plan is   "+str.getPlan()); //plan

}
}
