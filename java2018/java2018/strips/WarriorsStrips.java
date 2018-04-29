import pmatch.*;
import sheffield.*;
import java.io.*;
import java.util.*;

public class WarriorsStrips{
  public static void main(String[] args) {
    EasyWriter scr=new EasyWriter();

    //Operater to lower the ladder into the pit if there is no snake
    StripsOp ladder = new StripsOp("lower ladder into P",
                                    "treasure available",
                                    "",
                                    "ladder in P|snake not in P|Warrior in P");

    //Operator to lower the (now joined) hook and rope into the pit if the ladder cannot be used as
    //there is a snake
    StripsOp hookRope = new StripsOp("lower hookHop into P",
                                    "treasure available",
                                    "",
                                    "hook created|hookRope in P|snake in P|Warrior in P");

    //Operator to move the Warrior from place 1 to place 2
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
                                    "treasure available");


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
