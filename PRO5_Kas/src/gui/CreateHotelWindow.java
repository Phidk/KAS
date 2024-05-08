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


public class CreateHotelWindow extends Stage {

    private Hotel hotel;
private Label lblError;
private TextField txfDoublePris, txfNavn, txfAdresse;
    private TextField txfSinglePris;


    CreateHotelWindow(Hotel hotel) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setTitle(String.format("%s hotel - KAS", (hotel != null) ? "Opdater" : "Opret"));

        this.hotel = hotel;

        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

    }

    CreateHotelWindow() {
        this(null);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);
        Label lblName = new Label("Navn:");
        pane.add(lblName, 0, 0);

        Label lblAdresse = new Label("Adresse:");
        pane.add(lblAdresse, 0, 1);

        Label lblSinglePris = new Label("Enkeltværelsespris:");
        pane.add(lblSinglePris, 0, 2);

        Label lblDoublePris = new Label("Doubleværelsespris:");
        pane.add(lblDoublePris, 0, 3);

        this.lblError = new Label();
        this.lblError.setTextFill(Color.RED);
        pane.add(this.lblError, 0, 4, 2, 1);

        this.txfNavn = new TextField();
        pane.add(this.txfNavn, 1, 0);

        this.txfAdresse = new TextField();
        pane.add(this.txfAdresse, 1, 1);

        this.txfSinglePris = new TextField();
        pane.add(this.txfSinglePris, 1, 2);

        this.txfDoublePris = new TextField();
        pane.add(this.txfDoublePris, 1, 3);

        Button btnCancel = new Button("Afslut");
        btnCancel.setOnAction(event -> this.annullerAction());
        pane.add(btnCancel, 0, 5);

        Button btnSaveCreate = new Button((this.hotel != null) ? "Gem" : "Opret");
        btnSaveCreate.setOnAction(event -> this.gemCreateAction());
        pane.add(btnSaveCreate, 1, 5);

        if (this.hotel != null) {
            this.initControls();
        }
    }

        private void initControls() {
            this.txfNavn.setText(this.hotel.getName());
            this.txfAdresse.setText(this.hotel.getAdresse());
            this.txfSinglePris.setText(this.hotel.getSinglePris() + "");
            this.txfDoublePris.setText(this.hotel.getDoublePris() + "");
        }
    private void annullerAction () {
        this.hide();
    }
    private void gemCreateAction () {
        String name = this.txfNavn.getText().trim();
        String address = this.txfAdresse.getText().trim();

        String strSinglePris = this.txfSinglePris.getText().trim();
        String strDoublePris = this.txfDoublePris.getText().trim();
        int singlePris, doublePris;
        if (!strSinglePris.isEmpty() && !strDoublePris.isEmpty()) {
            singlePris = Integer.parseInt(strSinglePris);
            doublePris = Integer.parseInt(strDoublePris);
        } else {
            this.lblError.setText("Pris er ikke angivet!");
            return;
        }

        if (this.hotel != null) {
            this.hotel.setName(name);
            this.hotel.setSinglePris(singlePris);
            this.hotel.setDoublePris(doublePris);
        } else {
            this.hotel = Controller.createHotel(name, singlePris, doublePris);
        }

        this.hide();
    }

    // -------------------------------------------------------------------------

    public Hotel getHotel () {
        return this.hotel;
    }




}
