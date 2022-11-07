package nu.educom.MI6;


import nu.educom.MI6.data.Agent;
import nu.educom.MI6.data.Crud;
import nu.educom.MI6.data.LoginAttempt;

import java.awt.*;
import java.util.List;

public class Presenter implements IPresenter {

    private View view;
    private Crud crud;
    private Model model;
    private String userNumber;
    private String secretSentence;



    public Presenter(View view, Crud crud) {
        this.crud = crud;
        this.model = new Model(crud);
        this.view = view;
        this.view.setControlInterface(this);
        this.view.setLoginHandler();
        this.view.setBackHandler();

    }

    public void displayLogin() {
        this.view.displayLogin();
    }

    public void triggerLogin() {
        userNumber = view.getUserNumber();
        secretSentence = view.getSecretSentence();
        if(model.validateLogin(userNumber, secretSentence)) {
            Agent agent = crud.readOneAgentRow(userNumber);
            String msg = agent.getDetails();
            view.displayText(msg, Color.BLACK);
        } else {
            String errMsg = model.getErrors().get("validation");
            view.displayError(errMsg);
        }
    }

    public void triggerBack() {
        view.displayLogin();
    }
}
