package nu.educom.MI6;


import nu.educom.MI6.data.Agent;

import nu.educom.MI6.data.Crud;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args){
    View view = new View();
    Crud crud = new Crud();
    Presenter presenter = new Presenter(view, crud);
    presenter.displayLogin();
//    Crud crud = new Crud();
//    List<String> agentNumbers = new ArrayList<String>(Arrays.asList("002", "005", "030"));
////    Agent test = crud.readOneAgentRow("030");
//    List<Agent> test = crud.readManyAgentRows(agentNumbers);
//    for (Agent agent : test) {
//      agent.read();
//    }



  }
}
