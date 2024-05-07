package gui;


import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;

public class DeltagerRegistrationPane extends ScrollPane {

    private Konference konference;
    private Hotel hotel;

    private GridPane deltagerGridPane;
    private GridPane ledsagerGridPane;
    private GridPane hotelGridPane;
    private int currentPage = 1;
    private int totalPages = 4;
    private Label lblPageNumber;

    private ListView<Konference> lvwKonferencer;
    private ListView<Udflugt> lvwUdflugter;
    private ListView<Hotel> lvwHoteller;
    private ListView<Tillæg> lvwTilægger;

    private TextField txfNavn, txfAdresse, txfBy, txfLand, txfFirmaNavn, txfLedsagerNavn;
    private TextField txfTotalPris;
    private TextField txfForedragsholder, txfTlfNr, txfAnkomstDato, txfAfrejseDato, txfFirmaTlfNr;
    private DatePicker dtpStart, dtpSlut;
    private Label lblName, lblAdresse, lblBy, lblLand, lblFirmaNavn, lblUdflugter;
    private Label lblForedragsholder, lblTlfNr, lblAnkomstDato, lblAfrejseDato, lblFirmaTlfNr;
    private Label lblLedsagerNavn;
    private Label lblHoteller;
    private Label lblTillægger;
    private CheckBox chbForedragsholder, chbLedsager, chbHotel;
    private Button btnSlet, btnBekræft;

    private VBox content;

    /**
     * Initialiserer deltagerens registrationspane
     */

    public DeltagerRegistrationPane() {
//        this.setPadding(new Insets(10));
//        this.setHgap(10);
//        this.setVgap(10);
//        this.setGridLinesVisible(false);
        //----------------------------------------
        //Løsning til scrollpane
        //VBox content = new VBox();
        content = new VBox();
        this.deltagerGridPane = new GridPane();
        this.ledsagerGridPane = new GridPane();
        this.hotelGridPane = new GridPane();

        lblPageNumber = new Label("Side " + currentPage + "/" + totalPages);
        lblPageNumber.setFont(Font.font(12));

//        this.setContent(content);
//        this.setFitToWidth(true);
        GridPane konferencerGridPane = new GridPane();
        konferencerGridPane.setStyle("-fx-border-style: solid; -fx-border-width: 3; -fx-border-radius: 10;");
        konferencerGridPane.setPadding(new Insets(10));
        konferencerGridPane.setHgap(10);
        konferencerGridPane.setVgap(10);
        //konferencerGridPane.setAlignment(Pos.CENTER_LEFT);
//        konferencerGridPane.setGridLinesVisible(false);
//        this.add(konferencerGridPane, 0, 0, 2, 1);

        Label lblConferenceHeader = new Label("Vælg konference");
        lblConferenceHeader.setFont(new Font(15));
        GridPane.setHalignment(lblConferenceHeader, HPos.CENTER);
        konferencerGridPane.add(lblConferenceHeader, 0, 0);

        this.lvwKonferencer = new ListView<>();
        this.lvwKonferencer.getItems().setAll(Controller.getKonferencer());
        this.lvwKonferencer.setPrefSize(800, 200);
        konferencerGridPane.add(this.lvwKonferencer, 0, 1);

        ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> this.selectedKonferenceChanged(newKonference);
        this.lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(listener);
        content.getChildren().add(konferencerGridPane);

        konferencerGridPane.add(lblPageNumber, 0, 0);
        GridPane.setHalignment(lblPageNumber, HPos.RIGHT);

        //----------------------------------------

        //this.deltagerGridPane = new GridPane();
        this.deltagerGridPane.setStyle("-fx-border-style: solid; -fx-border-width: 3; -fx-border-radius: 10;");
        this.deltagerGridPane.setPadding(new Insets(10));
        this.deltagerGridPane.setHgap(10);
        this.deltagerGridPane.setVgap(10);
        this.deltagerGridPane.setDisable(false);
        content.getChildren().add(this.deltagerGridPane);
//        this.add(this.deltagerGridPane, 2,0);

        Label lblHeader = new Label("Deltager information:");
        lblHeader.setFont(new Font(15));
        GridPane.setHalignment(lblHeader, HPos.RIGHT);
        this.deltagerGridPane.add(lblHeader, 0, 0, 2, 1);

        Label lblNavn = new Label("Navn:");
        this.deltagerGridPane.add(lblNavn, 0, 1);

        this.txfNavn = new TextField();
        this.deltagerGridPane.add(this.txfNavn, 1, 1);

        Label lblForedragsholder = new Label("Foredragsholder");
        this.chbForedragsholder = new CheckBox();
        lblForedragsholder.setGraphic(this.chbForedragsholder);
        lblForedragsholder.setContentDisplay(ContentDisplay.RIGHT);
        this.deltagerGridPane.add(lblForedragsholder, 2, 1, 2, 1);

        Label lblAdresse = new Label("Adresse:");
        this.deltagerGridPane.add(lblAdresse, 0, 2);

        this.txfAdresse = new TextField();
        this.deltagerGridPane.add(this.txfAdresse, 1, 2);

        Label lblBy = new Label("By:");
        this.deltagerGridPane.add(lblBy, 2, 2);

        this.txfBy = new TextField();
        this.deltagerGridPane.add(this.txfBy, 3, 2);

        Label lblLand = new Label("Land:");
        this.deltagerGridPane.add(lblLand, 0, 3);

        this.txfLand = new TextField();
        this.deltagerGridPane.add(this.txfLand, 1, 3);

        Label lblTlfNr = new Label("Telefonnummer:");
        this.deltagerGridPane.add(lblTlfNr, 2, 3);

        this.txfTlfNr = new TextField();
        this.deltagerGridPane.add(this.txfTlfNr, 3, 3);

        Label lblStartDato = new Label("Ankomstdato:");
        this.deltagerGridPane.add(lblStartDato, 0, 4);

        this.dtpStart = new DatePicker();
        this.dtpStart.valueProperty().addListener((ov, oldValue, newValue) -> this.datePickerChanged());
        this.deltagerGridPane.add(this.dtpStart, 1, 4);

        Label lblAfrejseDato = new Label("Afrejsedato:");
        this.deltagerGridPane.add(lblAfrejseDato, 2, 4);

        this.dtpSlut = new DatePicker();
        this.dtpSlut.valueProperty().addListener((ov, oldValue, newValue) -> this.datePickerChanged());
        this.deltagerGridPane.add(this.dtpSlut, 3, 4);

        Label lblFirma = new Label("Deltager du igennem dit arbejde, udfyld de nederste felter");
        this.deltagerGridPane.add(lblFirma, 0, 5);

        Label lblFirmaNavn = new Label("Firma navn:");
        this.deltagerGridPane.add(lblFirmaNavn, 0, 6);

        this.txfFirmaNavn = new TextField();
        this.deltagerGridPane.add(this.txfFirmaNavn, 1, 6);

        Label lblFirmaTlfNr = new Label("Firma telefonnummer:");
        this.deltagerGridPane.add(lblFirmaTlfNr, 2, 6);

        this.txfFirmaTlfNr = new TextField();
        this.deltagerGridPane.add(this.txfFirmaTlfNr, 3, 6);

        lblPageNumber = new Label("Side 2/4");
        lblPageNumber.setFont(Font.font(12));
        deltagerGridPane.add(lblPageNumber, 3, 0);
        GridPane.setHalignment(lblPageNumber, HPos.RIGHT);
        //-----------------------------------------
        this.ledsagerGridPane = new GridPane();
        this.ledsagerGridPane.setPrefWidth(500);
        this.ledsagerGridPane.setStyle("-fx-border-style: solid; -fx-border-width: 3; -fx-border-radius: 10;");
        this.ledsagerGridPane.setPadding(new Insets(10));
        this.ledsagerGridPane.setHgap(10);
        this.ledsagerGridPane.setVgap(10);
        this.ledsagerGridPane.setGridLinesVisible(false);
        this.ledsagerGridPane.setDisable(false);
//        this.add(this.ledsagerGridPane,2,1);

        Label lblLedsagerHeader = new Label("Ledsager:");
        lblLedsagerHeader.setFont(new Font(15));
        GridPane.setHalignment(lblLedsagerHeader, HPos.CENTER);
        this.ledsagerGridPane.add(lblLedsagerHeader, 0, 0, 3, 1);

        Label lblLedsager = new Label("Ledsager medbringes:");
        this.chbLedsager = new CheckBox();
        this.chbLedsager.setOnAction(event -> this.checkboxLedsagerAction());
        lblLedsager.setGraphic(this.chbLedsager);
        lblLedsager.setContentDisplay(ContentDisplay.RIGHT);
        this.ledsagerGridPane.add(lblLedsager, 0, 1, 3, 1);

        this.lblLedsagerNavn = new Label("Ledsagerens navn:");
        this.lblLedsagerNavn.setDisable(false);
        this.ledsagerGridPane.add(this.lblLedsagerNavn, 1, 2);

        this.txfLedsagerNavn = new TextField();
        this.txfLedsagerNavn.setDisable(false);
        this.ledsagerGridPane.add(this.txfLedsagerNavn, 2, 2);

        this.lblUdflugter = new Label("Tilgængelige udflugter:");
        this.lblUdflugter.setFont(new Font(15));
        this.lblUdflugter.setDisable(false);
        this.ledsagerGridPane.add(this.lblUdflugter, 1, 3);

        this.lvwUdflugter = new ListView<>();
        this.lvwUdflugter.setPrefSize(400, 130);
        this.lvwUdflugter.setDisable(false);
        this.ledsagerGridPane.add(this.lvwUdflugter, 0, 4, 4, 1);

        ChangeListener<Udflugt> listenerUdflugt = (ov, oldUdflugt, newUdflugt) -> this.selectedUdflugtChanged();
        this.lvwUdflugter.getSelectionModel().selectedItemProperty().addListener(listenerUdflugt);

        lblPageNumber = new Label("Side 3/4");
        lblPageNumber.setFont(Font.font(12));

        ledsagerGridPane.add(lblPageNumber, 6, 0);
        GridPane.setHalignment(lblPageNumber, HPos.RIGHT);
        //------------------------------------
        //this.hotelGridPane = new GridPane();
        this.hotelGridPane.setStyle("-fx-border-style: solid; -fx-border-width: 3; -fx-border-radius: 10;");
        this.hotelGridPane.setPadding(new Insets(10));
        this.hotelGridPane.setHgap(10);
        this.hotelGridPane.setVgap(10);
        this.hotelGridPane.setDisable(false);
//        this.add(this.hotelGridPane,2,2);

        Label lblHotelHeader = new Label("Hotel");
        lblHotelHeader.setFont(new Font(15));
        GridPane.setHalignment(lblHotelHeader, HPos.CENTER);
        this.hotelGridPane.add(lblHotelHeader, 0, 0);

        Label lblHotel = new Label("Ønsker du at reservere et hotelværelse?:");
        this.chbHotel = new CheckBox();
        this.chbHotel.setOnAction(event -> this.checkboxHotelAction());
        lblHotel.setGraphic(this.chbHotel);
        lblHotel.setContentDisplay(ContentDisplay.RIGHT);
        GridPane.setHalignment(lblHotel, HPos.CENTER);
        this.hotelGridPane.add(lblHotel, 0, 1);

        this.lblHoteller = new Label("Tilgængelige hoteller");
        this.lblHoteller.setFont(new Font(15));
        this.lblHoteller.setDisable(false);
        this.hotelGridPane.add(this.lblHoteller, 0, 2);

        this.lvwHoteller = new ListView<>();
        this.lvwHoteller.setPrefSize(200, 175);
        this.lvwHoteller.setDisable(false);
        this.hotelGridPane.add(this.lvwHoteller, 0, 3);

        ChangeListener<Hotel> listenerHoteller = (ov, oldHotel, newHotel) -> this.selectedHotelChanged(newHotel);
        this.lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listenerHoteller);

        this.lblTillægger = new Label("Tilgængelig tillæg:");
        this.lblTillægger.setFont(new Font(15));
        this.lblTillægger.setDisable(false);
        this.hotelGridPane.add(this.lblTillægger, 0, 4);


        this.lvwTilægger = new ListView<>();
        this.lvwTilægger.setPrefSize(200, 150);
        this.lvwTilægger.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.lvwTilægger.setDisable(false);
        this.hotelGridPane.add(this.lvwTilægger, 0, 5);

        ChangeListener<Tillæg> listenerTillægger = (ov, oldTillæg, newTillæg) -> this.selectedTillægChanged();
        this.lvwTilægger.getSelectionModel().selectedItemProperty().addListener(listenerTillægger);

        lblPageNumber = new Label("Side 4/4");
        lblPageNumber.setFont(Font.font(12));

        hotelGridPane.add(lblPageNumber, 7, 0);
        GridPane.setHalignment(lblPageNumber, HPos.RIGHT);

        //----------------------
        this.btnSlet = new Button("Start forfra");
        this.btnSlet.setDisable(false);
        this.btnSlet.setOnAction(event -> this.sletControls());
        GridPane.setHalignment(this.btnSlet, HPos.RIGHT);
        //this.add(this.btnSlet,0,3);

        HBox hbox = new HBox();
//        this.add(hbox,1,3);

        this.btnBekræft = new Button("Bekræft registration");
        this.btnBekræft.setDisable(false);
        this.btnBekræft.setOnAction(event -> this.bekræftAction());
        hbox.getChildren().add(this.btnBekræft);

        Label lblPris = new Label("Samlet pris: ");
        hbox.getChildren().add(lblPris);

        this.txfTotalPris = new TextField();
        this.txfTotalPris.setEditable(false);
        HBox hboxTotalPris = new HBox(3);
        hboxTotalPris.getChildren().addAll(this.txfTotalPris, lblPris);


        this.hotelGridPane.add(hboxTotalPris, 0, 13);

        content.getChildren().addAll(this.ledsagerGridPane, this.hotelGridPane, this.btnSlet, this.btnBekræft, this.txfTotalPris);
        this.setContent(content);
        this.setFitToWidth(true);

    }

    /**
     * Når en deltager har valgt tillæg
     */
    private void selectedTillægChanged() {
        this.updatePris();
    }

    /**
     * Når deltageren vælger et hotel
     *
     * @param newHotel
     */
    private void selectedHotelChanged(Hotel newHotel) {
        this.hotel = newHotel;
        if (newHotel != null) {
            this.lvwTilægger.getItems().setAll(newHotel.getTillæg());
        } else {
            this.lvwTilægger.getItems().clear();
        }
        this.updatePris();

    }

    /**
     * Når en bruger vælger et hotel
     */
    private void checkboxHotelAction() {
        boolean checked = this.chbHotel.isSelected();

        this.lvwHoteller.setDisable(!checked);
        this.lblHoteller.setDisable(!checked);
        this.lblTillægger.setDisable(!checked);
        this.lvwTilægger.setDisable(!checked);

        if (!checked) {
            this.lvwHoteller.getSelectionModel().clearSelection();
        }
    }

    /**
     * Når en ledsager har valgt en udflugt, opdateres prisen
     */

    private void selectedUdflugtChanged() {
        this.updatePris();
    }

    /**
     * Når en deltager trykker ja til at en ledsager medbringes
     */
    private void checkboxLedsagerAction() {
        boolean checked = this.chbLedsager.isSelected();
        this.lblLedsagerNavn.setDisable(!checked);
        this.txfLedsagerNavn.setDisable(!checked);
        this.lblUdflugter.setDisable(!checked);
        this.lvwUdflugter.setDisable(!checked);

        if (!checked) {
            this.lvwUdflugter.getSelectionModel().clearSelection();
        }
    }

    /**
     * Når en datepicker skifter værdi
     */
    private void datePickerChanged() {
        this.updatePris();
    }

    /**
     * Når en deltager vælger en konference
     */
    private void selectedKonferenceChanged(Konference newKonference) {
        boolean isNull = newKonference == null;

        this.deltagerGridPane.setDisable(isNull);
        this.ledsagerGridPane.setDisable(isNull);
        this.hotelGridPane.setDisable(isNull);
        this.btnBekræft.setDisable(isNull);
        this.btnSlet.setDisable(isNull);

        this.konference = newKonference;

        if (!isNull) {
            this.dtpStart.setValue(this.konference.getStartDato());
            this.dtpSlut.setValue(this.konference.getSlutDate());
            this.restrictDatePicker(this.dtpStart, this.konference.getStartDato(), this.konference.getSlutDate());
            this.restrictDatePicker(this.dtpSlut, this.konference.getStartDato(), this.konference.getSlutDate());

            this.lvwUdflugter.getItems().setAll(this.konference.getUdflugter());
            this.lvwHoteller.getItems().setAll(this.konference.getHoteller());
        }
        this.updatePris();
    }

    private void sletControls() {
        this.content.getChildren().removeAll(this.ledsagerGridPane, this.hotelGridPane);
        this.txfNavn.clear();
    }

    private void bekræftAction() {
        // Tjek om alle krævede felter er udfyldt, altså om de har "valid" css classen
        ArrayList<TextField> errorableTextFields = new ArrayList<>(Arrays.asList(
                this.txfNavn, this.txfAdresse, this.txfBy, this.txfLand, this.txfTlfNr));
        for (TextField textField : errorableTextFields) {
            if (!textField.getStyleClass().contains("valid")) {
                return;
            }
        }

        // Hvis enten firmanavn eller firma tlf. nr. er skrevet skal begge udfyldes
        if (this.txfFirmaNavn.getText().trim().length() != 0 || this.txfFirmaTlfNr.getText().trim().length() != 0) {

            if (!this.txfFirmaNavn.getStyleClass().contains("valid")) {
                return;

            } else if (!this.txfFirmaTlfNr.getStyleClass().contains("valid")) {
                return;

            }

        }
// Hvis medbring ledsager er valgt, så skal ledsager navn også være udfyldt,

        if (this.chbLedsager.isSelected() && !this.txfFirmaNavn.getStyleClass().contains("valid")) {

            return;
        }

        String name = this.txfNavn.getText().trim();
        String address = this.txfAdresse.getText().trim();
        String city = this.txfBy.getText().trim();
        String country = this.txfLand.getText().trim();
        String telephone = this.txfTlfNr.getText().trim();
        String companyName = this.txfFirmaNavn.getText().trim();
        String companyTelephone = this.txfFirmaTlfNr.getText().trim();
        String companionName = this.txfFirmaNavn.getText().trim();

        boolean speaker = this.chbForedragsholder.isSelected();

                LocalDate arrivalDate = this.dtpStart.getValue();
                LocalDate departureDate = this.dtpSlut.getValue();
    }
        /**
         * Opdaterer den samlede pris
         */
        private void updatePris () {
            if (this.konference != null && this.dtpStart.getValue() != null && this.dtpSlut.getValue() != null) {
                int antalOpholdsDage = (int) ChronoUnit.DAYS.between(this.dtpStart.getValue(), this.dtpSlut.getValue());
                int konferencePris = 0;

                if (!this.chbForedragsholder.isSelected()) {
                    konferencePris = this.konference.getKonferenceAfgift() * (antalOpholdsDage + 1);
                }
                int hotelPris = 0;
                if (this.hotel != null) {
                    int tillægsPris = 0;
                    for (Tillæg tillæg : this.lvwTilægger.getSelectionModel().getSelectedItems()) {
                        tillægsPris += tillæg.getPris();
                    }
                    if (this.chbLedsager.isSelected()) {
                        hotelPris = (hotelPris + tillægsPris) * antalOpholdsDage;
                    }
                }
                int udflugtsPris = 0;
                if (this.chbLedsager.isSelected()) {
                    for (Udflugt udflugt : this.lvwUdflugter.getSelectionModel().getSelectedItems()) {
                        udflugtsPris += udflugt.getPris();
                    }
                }
                this.txfTotalPris.setText(konferencePris + hotelPris + udflugtsPris + "");
            }
        }

        /**
         * Begrænser en datepicker til to localdate objekter
         */
        private void restrictDatePicker (DatePicker datePicker, LocalDate startDato, LocalDate slutDato){
            datePicker.setDayCellFactory(picker -> new DateCell() {

                public void updateItem(LocalDate date, boolean tom) {
                    super.updateItem(date, tom);
                    setDisable(tom || date.compareTo(startDato) < 0 || date.compareTo(slutDato) > 0);
                }
            });
        }

    }









