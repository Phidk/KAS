package gui;

import controller.Controller;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Konference;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreateKonferenceWindow  extends Stage {
    private Konference konference;
    private TextField txfNavn, txfAdresse, txfDagligPris, txfStartDato, txfSlutDato, txfDeadLine;
    private Label lblError;
    private DatePicker dtpStartDate, dtpEndDate, dtpDeadline;

    CreateKonferenceWindow(Konference konference) {

        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setTitle(String.format("%s konference - KAS", (konference != null) ? "Opdater" : "Opret"));

        this.konference = konference;

        GridPane pane = new GridPane();
        pane.setPrefSize(290, 325);
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    CreateKonferenceWindow() {
        this(null);
    }

    // -------------------------------------------------------------------------

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        // -------------------------------------------------------------------------

        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 0);

        Label lblAdresse = new Label("Adresse:");
        pane.add(lblAdresse, 0, 1);

        Label lblDagligPris = new Label("Konference afgift:");
        pane.add(lblDagligPris, 0, 2);

        Label lblStartDato = new Label("Startdato:");
        pane.add(lblStartDato, 0, 3);

        Label lblSlutDato = new Label("Slutdato:");
        pane.add(lblSlutDato, 0, 4);

        this.lblError = new Label();
        this.lblError.setTextFill(Color.RED);
        pane.add(this.lblError, 0, 5, 2, 1);

        this.txfNavn = new TextField();
        pane.add(this.txfNavn, 1, 0);

        this.txfAdresse = new TextField();
        pane.add(this.txfAdresse, 1, 1);

        this.txfDagligPris = new TextField();
        pane.add(this.txfDagligPris, 1, 2);

        this.dtpStartDate = new DatePicker();
        pane.add(this.dtpStartDate, 1, 3);
        this.restrictDatePicker(this.dtpStartDate, LocalDate.now(), true);

        this.dtpEndDate = new DatePicker();
        pane.add(this.dtpEndDate, 1, 4);
        this.restrictDatePicker(this.dtpEndDate, LocalDate.now(), true);

        // -------------------------------------------------------------------------

        Button btnCancel = new Button("Afslut");
        btnCancel.setOnAction(event -> this.cancelAction());
        pane.add(btnCancel, 0, 6);

        Button btnSaveCreate = new Button((this.konference != null) ? "Gem" : "Opret");
        btnSaveCreate.setOnAction(event -> this.saveCreateAction());
        pane.add(btnSaveCreate, 1, 6);

        // -------------------------------------------------------------------------

        if (this.konference != null) {
            this.initControls();
        }
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        this.hide();
    }

    private void saveCreateAction() {
        String name = this.txfNavn.getText().trim();
        String address = this.txfAdresse.getText().trim();
        String strDailyPrice = this.txfDagligPris.getText().trim();

        if (name.isEmpty() || address.isEmpty() || strDailyPrice.isEmpty()) {
            this.lblError.setText("Navn, adresse eller konference afgift er ikke angivet!");
            return;
        }

        int dailyPrice = Integer.parseInt(strDailyPrice);

        if (this.konference != null) {
            this.konference.setNavn(name);
            this.konference.setAdresse(address);
            this.konference.setKonferenceAfgift(dailyPrice);
            this.konference.setStartDato(this.dtpStartDate.getValue());
            this.konference.setSlutDate(this.dtpEndDate.getValue());
        } else {
            this.konference = Controller.createKonference(name, address, dailyPrice, this.dtpStartDate.getValue(), this.dtpEndDate.getValue());
        }

        this.hide();
    }
    private void initControls() {
        this.txfNavn.setText(this.konference.getNavn());
        this.txfAdresse.setText(this.konference.getAdresse());
        this.txfDagligPris.setText(this.konference.getKonferenceAfgift() + "");
        this.dtpStartDate.setValue(this.konference.getStartDato());
        this.dtpEndDate.setValue(this.konference.getSlutDate());
        this.restrictDatePicker(this.dtpEndDate, this.dtpStartDate.getValue(), true);
        //this.restrictDatePicker(this.dtpDeadline, LocalDate.now(), this.dtpStartDate.getValue());
    }
    // -------------------------------------------------------------------------

    public Konference getKonference() {
        return this.konference;
    }

    // -------------------------------------------------------------------------

    private void restrictDatePicker(DatePicker datePicker, LocalDate givenDate, boolean fromDate) {
        datePicker.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if (fromDate) {
                    setDisable(empty || date.compareTo(givenDate) < 0);
                } else {
                    setDisable(empty || date.compareTo(givenDate) > 0);
                }
            }
        });
    }
}





