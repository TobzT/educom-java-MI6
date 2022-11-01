package nu.educom.MI6;

public class Presenter implements IPresenter {

    private View view;
    private Model model;
    private String userNumber;
    private String secretSentence;


    public Presenter(View view) {
        this.view = view;
        this.model = new Model();
        this.view.setControlInterface(this);

    }

    public void displayLogin() {
        this.view.displayLogin();
    }

    public void triggerLogin() {
        userNumber = view.getUserNumber();
        secretSentence = view.getSecretSentence();
    }

}
