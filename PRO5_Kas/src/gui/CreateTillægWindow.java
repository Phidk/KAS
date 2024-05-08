package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Hotel;
import model.Tillæg;

public class CreateTillægWindow extends Stage {

    private final Hotel hotel;
    private Tillæg tillæg;

    private TextField txfNavn, txfPris;
    private Label lblError;

    CreateTillægWindow (Hotel hotel, Tillæg tillæg) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setTitle(String.format("%s tillæg - KAS", (tillæg != null) ? "Opdater" : "Opret"));

        this.hotel = hotel;
        this.tillæg = tillæg;

        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    CreateTillægWindow (Hotel hotel) {
        this(hotel, null);
    }

    // -------------------------------------------------------------------------

    private void initContent (GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        // -------------------------------------------------------------------------

        Label lblName = new Label("Navn:");
        pane.add(lblName, 0, 0);

        Label lblPrice = new Label("Pris:");
        pane.add(lblPrice, 0, 1);

        this.lblError = new Label();
        this.lblError.setTextFill(Color.RED);
        pane.add(this.lblError, 0, 2, 2, 1);

        this.txfNavn = new TextField();
        pane.add(this.txfNavn, 1, 0);

        this.txfPris = new TextField();
        pane.add(this.txfPris, 1, 1);

        // -------------------------------------------------------------------------

        Button btnCancel = new Button("Afslut");
        btnCancel.setOnAction(event -> this.cancelAction());
        pane.add(btnCancel, 0, 3);

        Button btnSaveCreate = new Button((this.tillæg != null) ? "Gem" : "Opret");
        btnSaveCreate.setOnAction(event -> this.saveCreateAction());
        pane.add(btnSaveCreate, 1, 3);

        // -------------------------------------------------------------------------

        if (this.tillæg != null) {
            this.initControls();
        }
    }

    // -------------------------------------------------------------------------

    private void initControls () {
        this.txfNavn.setText(this.tillæg.getNavn());
        this.txfPris.setText(this.tillæg.getPris() + "");
    }

    // -------------------------------------------------------------------------

    private void cancelAction () {
        this.hide();
    }

    private void saveCreateAction () {
        String name = this.txfNavn.getText().trim();

        String strPrice = this.txfPris.getText().trim();
        int price;
        if (!strPrice.isEmpty()) {
            price = Integer.parseInt(strPrice);
        } else {
            this.lblError.setText("Pris er ikke angivet!");
            return;
        }

        if (this.tillæg != null) {
            this.tillæg.setName(name);
            this.tillæg.setPris(price);
        } else {
            this.tillæg = Controller.createTillæg(name, price, hotel);
        }

        this.hide();
    }

    // -------------------------------------------------------------------------

    public Tillæg getTillæg () {
        return this.tillæg;

    }



}
