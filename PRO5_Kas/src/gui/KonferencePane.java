package gui;
import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Hotel;
import model.Konference;
import model.Registration;
import model.Udflugt;

import java.time.format.DateTimeFormatter;

public class KonferencePane extends GridPane {

    private Konference konference;
    private Hotel hotel;
    private Udflugt udflugt;

    private ListView<Konference> lvwKonferencer;
    private ListView<Hotel> lvwHoteller;
    private ListView<Udflugt> lvwUdflugter;
    private TextField txfNavn, txfAdresse, txfStartDato, txfSlutDato, txfDeadline;
    private TextField txfDagligpris;
    private TextArea txaRegistrationer;
    private Button btnSlet, btnUpdate, btnSletHotel, btnSletUdflugt, btnAddHotel, btnAddUdflugt;

    KonferencePane(){
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        // --------------------------------------------------------------

        this.lvwKonferencer = new ListView<>();
        this.lvwKonferencer.setPrefSize(250, 400);
        this.add(this.lvwKonferencer, 0, 0, 1, 7);

        ChangeListener<Konference> listener = (ov, oldValue, newValue) -> this.selectedConferenceChanged(newValue);
        this.lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(listener);

        // --------------------------------------------------------------

        Label lblName = new Label("Navn:");
        this.add(lblName, 1, 0);

        Label lblAddress = new Label("Adresse:");
        this.add(lblAddress, 1, 1);

        Label lblDailyPrice = new Label("Konference afgift:");
        this.add(lblDailyPrice, 1, 2);

        Label lblStartDate = new Label("Startdato:");
        this.add(lblStartDate, 1, 3);

        Label lblEndDate = new Label("Slutdato:");
        this.add(lblEndDate, 1, 4);

        Label lblHotels = new Label("Hoteller:");
        this.add(lblHotels, 1, 6);

        this.txfNavn = new TextField();
        this.txfNavn.setEditable(false);
        this.add(this.txfNavn, 2, 0);

        this.txfAdresse = new TextField();
        this.txfAdresse.setEditable(false);
        this.add(this.txfAdresse, 2, 1);

        this.txfDagligpris = new TextField();
        this.txfDagligpris.setEditable(false);
        this.add(this.txfDagligpris, 2, 2);

        this.txfStartDato = new TextField();
        this.txfStartDato.setEditable(false);
        this.add(this.txfStartDato, 2, 3);

        this.txfSlutDato = new TextField();
        this.txfSlutDato.setEditable(false);
        this.add(this.txfSlutDato, 2, 4);


        this.lvwHoteller = new ListView<>();
        this.lvwHoteller.setPrefSize(200, 100);
        this.add(this.lvwHoteller, 2, 6);

        ChangeListener<Hotel> listenerHotel = (ov, oldValue, newValue) -> this.selectedHotelChanged(newValue);
        this.lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listenerHotel);

        Label lblRegistrations = new Label("Registrationer:");
        this.add(lblRegistrations, 3, 0, 1, 6);

        Label lblExcursions = new Label("Udflugter:");
        this.add(lblExcursions, 3, 6);

        this.txaRegistrationer = new TextArea();
        this.txaRegistrationer.setPrefSize(200, 100);
        this.txaRegistrationer.setEditable(false);
        this.add(this.txaRegistrationer, 4, 0, 1, 6);

        this.lvwUdflugter = new ListView<>();
        this.lvwUdflugter.setPrefSize(200, 100);
        this.add(this.lvwUdflugter, 4, 6);

        ChangeListener<Udflugt> listenerExcursion = (ov, oldValue, newValue) -> this.selectedExcursionChanged(newValue);
        this.lvwUdflugter.getSelectionModel().selectedItemProperty().addListener(listenerExcursion);

        // --------------------------------------------------------------
        HBox hBoxConference = new HBox(10);
        this.add(hBoxConference, 0, 7);

        this.btnSlet = new Button("Slet");
        this.btnSlet.setOnAction(event -> this.deleteAction());
        this.btnSlet.setDisable(true);
        hBoxConference.getChildren().add(this.btnSlet);

        this.btnUpdate = new Button("Opdater");
        this.btnUpdate.setOnAction(event -> this.updateAction());
        this.btnUpdate.setDisable(true);
        hBoxConference.getChildren().add(this.btnUpdate);

        Button btnCreate = new Button("Opret");
        btnCreate.setOnAction(event -> this.createAction());
        hBoxConference.getChildren().add(btnCreate);

        HBox hBoxHotel = new HBox(10);
        this.add(hBoxHotel, 2, 7);

        this.btnSletHotel = new Button("Fjern hotel");
        this.btnSletHotel.setOnAction(event -> this.removeHotelAction());
        this.btnSletHotel.setDisable(true);
        hBoxHotel.getChildren().add(this.btnSletHotel);

        this.btnAddHotel = new Button("Tilføj hotel");
        this.btnAddHotel.setOnAction(event -> this.addHotelAction());
        this.btnAddHotel.setDisable(true);
        hBoxHotel.getChildren().add(this.btnAddHotel);

        HBox hBoxExcursion = new HBox(10);
        this.add(hBoxExcursion, 4, 7);

        this.btnSletUdflugt = new Button("Fjern udflugt");
        this.btnSletUdflugt.setOnAction(event -> this.removeUdflugtAction());
        this.btnSletUdflugt.setDisable(true);
        hBoxExcursion.getChildren().add(this.btnSletUdflugt);

        this.btnAddUdflugt = new Button("Tilføj udflugt");
        this.btnAddUdflugt.setOnAction(event -> this.addUdflugtAction());
        this.btnAddUdflugt.setDisable(true);
        hBoxExcursion.getChildren().add(this.btnAddUdflugt);

        // --------------------------------------------------------------

        this.updateConferences();
    }
    // --------------------------------------------------------------

    private void selectedConferenceChanged (Konference konference) {
        this.konference = konference;

        this.updateControls();
    }

    private void selectedHotelChanged (Hotel hotel) {
        this.hotel = hotel;

        this.updateButtons();
    }

    private void selectedExcursionChanged (Udflugt udflugt) {
        this.udflugt = udflugt;

        this.updateButtons();
    }

    // --------------------------------------------------------------

    private void updateControls () {
        if (this.konference != null) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM-yyyy");

            this.txfNavn.setText(this.konference.getNavn());
            this.txfAdresse.setText(this.konference.getAdresse());
            this.txfDagligpris.setText(this.konference.getKonferenceAfgift() + "");
            this.txfStartDato.setText(this.konference.getStartDato().format(dtf));
            this.txfSlutDato.setText(this.konference.getSlutDate().format(dtf));
            this.lvwHoteller.getItems().setAll(this.konference.getHoteller());
            this.lvwUdflugter.getItems().setAll(this.konference.getUdflugter());

            StringBuilder registrationer = new StringBuilder();
            for (Registration registration : this.konference.getRegistrationer()) {
                registrationer.append(registration.getDeltager().getNavn()).append(" | ");
                registrationer.append(registration.getDeltager().getTlfNr()).append("\n");
            }
            this.txaRegistrationer.setText(registrationer.toString());
        }

        this.updateButtons();
    }

    private void updateButtons () {
        boolean konference = this.konference == null;
        boolean hotel = this.hotel == null;
        boolean udflugt = this.udflugt == null;

        this.btnUpdate.setDisable(konference);
        this.btnSlet.setDisable(konference);
        this.btnAddHotel.setDisable(konference);
        this.btnAddUdflugt.setDisable(konference);

        this.btnSletHotel.setDisable(hotel);
        this.btnSletUdflugt.setDisable(udflugt);
    }

    private void clearControls () {
        this.txfNavn.clear();
        this.txfAdresse.clear();
        this.txfDagligpris.clear();
        this.txfStartDato.clear();
        this.txfSlutDato.clear();
        this.lvwHoteller.getItems().clear();
        this.lvwUdflugter.getItems().clear();
        this.txaRegistrationer.clear();

        this.updateButtons();
    }

    private void updateConferences () {
        this.lvwKonferencer.getItems().setAll(Controller.getKonferencer());
    }

    // --------------------------------------------------------------

    private void createAction () {
        CreateKonferenceWindow createKonferenceWindow = new CreateKonferenceWindow();
        createKonferenceWindow.showAndWait();

        this.konference = createKonferenceWindow.getKonference();
        this.updateControls();
        this.updateConferences();
    }

    private void updateAction () {
        CreateKonferenceWindow createKonferenceWindow = new CreateKonferenceWindow(this.konference);
        createKonferenceWindow.showAndWait();

        this.updateControls();
        this.updateConferences();
    }

    private void deleteAction () {
        Controller.removeKonference(this.konference);

        this.konference = null;
        this.clearControls();
        this.updateConferences();
    }

    // --------------------------------------------------------------

    private void removeHotelAction () {
        this.konference.removeHotel(this.hotel);

        this.hotel = null;
        this.updateControls();
    }

    private void addHotelAction () {
        AddHotelWindow addHotelWindow = new AddHotelWindow(this.konference);
        addHotelWindow.showAndWait();

        this.updateControls();
    }

    // --------------------------------------------------------------

    private void removeUdflugtAction () {
        this.konference.removeUdflugt(udflugt);
        this.udflugt = null;
        this.updateControls();
    }

    private void addUdflugtAction () {
        AddUdflugtTilKonferenceWindow addUdflugtTilKonferenceWindow = new AddUdflugtTilKonferenceWindow(this.konference);
        addUdflugtTilKonferenceWindow.showAndWait();

        this.updateControls();
    }


}
