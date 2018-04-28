import pmatch.*;
import sheffield.*;
import java.io.*;
import java.util.*;

public class WarriorsStrips{
  public static void main(String[] args) {
    EasyWriter scr=new EasyWriter();


    StripsOp ladder = new StripsOp("pickup treasure in P using ladder",
                                    "pickup treasure in ",
                                    "treasure in P",
                                    "ladder in P|treasure in P|snake not in P|Warrior in P");//Dudt carry object?*/
    StripsOp hookRope = new StripsOp("pickup treasure in P using rope and hook",
                                    "pickup treasure in P",
                                    "treasure in P",
                                    "hook created");//Dudt carry object?
    StripsOp move = new StripsOp("move from ?r1 to ?r2",
                                   "Warrior in ?r2",
                                   "Warrior in ?r1",
                                   "Warrior in ?r1");
    StripsOp carry = new StripsOp("carry ?obj from ?r1 to ?r2",
                                    "Warrior in ?r2|?obj in ?r2",
                                    "Warrior in ?r1|?obj in ?r1",
                                    "Warrior in ?r1|?obj in ?r1");
    StripsOp hookCreate = new StripsOp("create hook",
                                    "hook created",
                                    "",
                                    "hook in R|rope in R|snake in P|Warrior in H");


    ArrayList<StripsOp> warriorOps = new ArrayList<StripsOp>();

    warriorOps.add(ladder);
    warriorOps.add(hookRope);
    warriorOps.add(move);
    warriorOps.add(carry);
    warriorOps.add(hookCreate);

    //create instance of Strips1, give it the operators, init state & goal state

    Strips1 str=new Strips1(warriorOps,
                            new MStringVector("Warrior in W|treasure in P|hook in H|ladder in L|rope in R|snake in P"),
                            new MStringVector("pickup treasure in P"));//CHANGE GOAL STATE //Warrior in R|


    //run Strips
    boolean res=str.run();
    scr.println("Result is "+res); //result
    scr.println("Plan is   "+str.getPlan()); //plan

}
}
