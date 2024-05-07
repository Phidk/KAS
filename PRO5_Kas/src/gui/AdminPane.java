
package gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AdminPane extends GridPane {

    private final TextField txfBrugerNavn;
    private final PasswordField txfKode;
    private final Label lblFejl;
    private final Button btnLogin;

    public AdminPane () {
        this.setPadding(new Insets(200, 400, 200, 400));
        this.setHgap(10);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        // --------------------------------------------------------------

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
            gui.AdminWindow adminWindow = new gui.AdminWindow();
            adminWindow.show();

            this.txfBrugerNavn.clear();
            this.txfBrugerNavn.clear();
            this.lblFejl.setText("");
        } else {
            this.lblFejl.setText("Brugernavn eller kode er forkert!");
        }
    }

}

