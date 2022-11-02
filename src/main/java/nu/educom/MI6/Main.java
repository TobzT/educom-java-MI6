package nu.educom.MI6;


import java.sql.ResultSet;
import java.util.List;

public class Main {

  public static void main(String[] args){
    View view = new View();
    Presenter presenter = new Presenter(view);
    presenter.displayLogin();
    Crud crud = new Crud();
    Agent test = crud.readOneRow("SELECT * FROM agents WHERE userNumber = ?", "002");
    test.read();


  }
}
