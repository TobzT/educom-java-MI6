package nu.educom.MI6;


public class Main {

  public static void main(String[] args){
    View view = new View();
    Presenter presenter = new Presenter(view);
    presenter.displayLogin();
  }
}