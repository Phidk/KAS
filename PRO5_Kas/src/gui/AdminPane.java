
package gui;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class AdminPane extends GridPane {

    private TextField txfBrugerNavn;
  private PasswordField txfKode;
    private Label lblFejl;
    private Button btnLogin;

    public AdminPane (TextField txfPasswordField) {
        this.txfBrugerNavn = txfPasswordField;
        this.setPadding(new Insets(200, 400, 200, 400));

    TextField txfBrugerNavn;
    PasswordField txfPassword;
    Label lblError;
    Button btnLogin;

    public AdminPane(){
        this.setPadding(new Insets(20));
        this.setHgap(10);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        GridPane pane = new GridPane();
        pane.setStyle("-fx-border-style: solid; -fx-border-width: 3; -fx-border-radius: 10;");
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);
        this.add(pane, 0, 0);

        Label lblUsername = new Label("Brugernavn:");
        pane.add(lblUsername, 0, 0);

        this.txfBrugerNavn = new TextField();
        pane.add(this.txfBrugerNavn, 1, 0);

        Label lblBrugerNavn = new Label("Kode:");
        pane.add(lblBrugerNavn, 0, 1);

        this.txfKode = new PasswordField();
        pane.add(this.txfBrugerNavn, 1, 1);

        this.lblFejl = new Label();
        this.lblFejl.setStyle("-fx-text-fill: red;");
        pane.add(this.lblFejl, 0, 2, 2, 1);

        this.btnLogin = new Button("Log in");
        this.btnLogin.setOnAction(event -> this.loginAction());
        this.btnLogin.setDefaultButton(true);
        GridPane.setHalignment(this.btnLogin, HPos.CENTER);
        pane.add(this.btnLogin, 0, 3, 2, 1);
    }

    // --------------------------------------------------------------

    private void loginAction () {
        if (this.txfBrugerNavn.getText().trim().equals("hav") && this.txfBrugerNavn.getText().trim().equals("hav")) {
            AdminWindow adminWindow = new AdminWindow();
            adminWindow.show();

            this.txfBrugerNavn.clear();
            this.txfBrugerNavn.clear();
            this.lblFejl.setText("");
        } else {
            this.lblFejl.setText("Brugernavn eller kode er forkert!");
            Node Pane = null;
            this.add(Pane,15,10,2,2);

        Label lblBrugernavn = new Label("Brugernavn:");
        this.add(lblBrugernavn,0,0);

        this.txfBrugerNavn = new TextField();
        this.add(txfBrugerNavn, 1,0);

        Label lblPassword = new Label("Kode:");
        this.add(lblPassword, 0,1);

        this.txfBrugerNavn = new PasswordField(); //
        pane.add(this.txfPassword, 1,1);

        this.lblError = new Label();
        this.lblError.setStyle("-fx-text-fill: red;");
        pane.add(this.lblError,0,2,2,1);

        this.btnLogin = new Button("Log ind");
        this.btnLogin.setOnAction(event -> this.loginAction());
        this.btnLogin.setDefaultButton(true);
        GridPane.setHalignment(this.btnLogin, HPos.CENTER);
        pane.add(this.btnLogin, 0,3,2,1);
    }
    //------------------------------
    private void loginAction(){
        if(this.txfBrugerNavn.getText().trim().equals("KAS") && this.txfPassword.getText().trim().equals("KAS")) {
            AdminWindow adminWindow = new AdminWindow();
            adminWindow.show();

            this.txfBrugerNavn.clear();
            this.txfPassword.clear();
            this.lblError.setText("");
        }else{
            this.lblError.setText("Brugernavn eller kode er forkert. Hint: Begge er KAS");
        }
    }

}

