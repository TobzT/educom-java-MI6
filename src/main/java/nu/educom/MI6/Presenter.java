package nu.educom.MI6;


public class Presenter implements IPresenter {

    private View view;
    private Model model = new Model();
    private String userNumber;
    private String secretSentence;



    public Presenter(View view) {
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
            String msg = "ACCESS GRANTED";
            view.displaySuccess(msg);
        } else {
            String errMsg = model.getErrors().get("validation");
            view.displayError(errMsg);
        }
    }

    public void triggerBack() {
        view.displayLogin();
    }


}
