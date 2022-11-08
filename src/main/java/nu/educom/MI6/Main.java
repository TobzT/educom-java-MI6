package nu.educom.MI6;


import nu.educom.MI6.data.Agent;

import nu.educom.MI6.data.Crud;
import nu.educom.MI6.data.LoginAttempt;

import java.util.*;

public class Main {

  static Timer timer = new Timer();
  static int interval;
  public static void main(String[] args){
    View view = new View();
    Crud crud = new Crud();
    Presenter presenter = new Presenter(view, crud);
    presenter.displayLogin();

  }


}
