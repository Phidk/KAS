package gui;

import controller.*;
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

public class DeltagerRegistrationPane extends ScrollPane {

    private Konference konference;
    private Hotel hotel;

    private final GridPane deltagerGridPane;
    private GridPane ledsagerGridPane;
    private final GridPane hotelGridPane;

    private int currentPage = 1;
    private int totalPages = 4;
    private Label lblPageNumber;

    private ListView<Konference> lvwKonferencer;
    private ListView<Udflugt> lvwUdflugter;
    private ListView<Hotel> lvwHoteller;
    private ListView<Tillæg> lvwTillæg;

    private final TextField txfNavn, txfAdresse, txfBy, txfLand, txfFirmaNavn, txfLedsagerNavn;
    private final TextField txfTotalPris;
    private TextField txfForedragsholder, txfTlfNr, txfAnkomstDato, txfAfrejseDato, txfFirmaTlfNr;
    private final DatePicker dtpStart, dtpSlut;
    private Label lblName, lblAdresse, lblBy, lblLand, lblFirmaNavn, lblUdflugter;
    private Label lblForedragsholder, lblTlfNr, lblAnkomstDato, lblAfrejseDato, lblFirmaTlfNr;
    private final Label lblLedsagerNavn;
    private final Label lblHoteller;
    private final Label lblTillæg;
    private Label lblTotalPris;
    private final CheckBox chbForedragsholder, chbLedsager, chbHotel;
    private final Button btnClear, btnBekræft;

    private final VBox content;



    /**
     * Initialiserer deltagerens registrationspane
     */

    public DeltagerRegistrationPane() {

        //VBox content = new VBox();
        content = new VBox();
        this.deltagerGridPane = new GridPane();
        this.ledsagerGridPane = new GridPane();
        this.hotelGridPane = new GridPane();

        lblPageNumber = new Label("Side " + currentPage + "/" + totalPages);
        lblPageNumber.setFont(Font.font(12));


        GridPane konferencerGridPane = new GridPane();
        konferencerGridPane.setStyle("-fx-border-style: solid; -fx-border-width: 3; -fx-border-radius: 10;");
        konferencerGridPane.setPadding(new Insets(10));
        konferencerGridPane.setHgap(10);
        konferencerGridPane.setVgap(10);

        Label lblConferenceHeader = new Label("Vælg konference");
        lblConferenceHeader.setFont(new Font(15));
        GridPane.setHalignment(lblConferenceHeader, HPos.CENTER);
        konferencerGridPane.add(lblConferenceHeader, 0, 0);

        // changes
        this.lvwKonferencer = new ListView<>();
        ArrayList<Konference> konferencer = Controller.getKonferencer();

        this.lvwKonferencer.getItems().clear();
        this.lvwKonferencer.getItems().setAll(konferencer);
        this.lvwKonferencer.setPrefSize(800, 200);

        konferencerGridPane.add(this.lvwKonferencer, 0, 1);

//        this.lvwKonferencer = new ListView<>();
//        this.lvwKonferencer.getItems().setAll(Controller.getKonferencer());
//        this.lvwKonferencer.setPrefSize(800, 200);
//        konferencerGridPane.add(this.lvwKonferencer, 0, 1);

        ChangeListener<Konference> listener = (ov, oldKonference, newKonference) -> this.selectedKonferenceChanged(newKonference);
        this.lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(listener);
        content.getChildren().add(konferencerGridPane);

        konferencerGridPane.add(lblPageNumber, 0, 0);
        GridPane.setHalignment(lblPageNumber, HPos.RIGHT);

        //----------------------------------------

        this.deltagerGridPane.setStyle("-fx-border-style: solid; -fx-border-width: 3; -fx-border-radius: 10;");
        this.deltagerGridPane.setPadding(new Insets(10));
        this.deltagerGridPane.setHgap(10);
        this.deltagerGridPane.setVgap(10);
        this.deltagerGridPane.setDisable(false);
        content.getChildren().add(this.deltagerGridPane);


        Label lblHeader = new Label("Deltager information:");
        lblHeader.setFont(new Font(15));
        GridPane.setHalignment(lblHeader, HPos.CENTER);
        this.deltagerGridPane.add(lblHeader, 0, 0, 4, 1);

        Label lblNavn = new Label("Navn:");
        this.deltagerGridPane.add(lblNavn, 0, 1);

        this.txfNavn = new TextField();
        this.deltagerGridPane.add(this.txfNavn, 1, 1);

        Label lblForedragsholder = new Label("Foredragsholder");
        this.chbForedragsholder = new CheckBox();
        lblForedragsholder.setGraphic(this.chbForedragsholder);
        lblForedragsholder.setContentDisplay(ContentDisplay.RIGHT);
        this.chbForedragsholder.setOnAction(event -> this.checkboxForedragsholderAction());
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

        Label lblTlfNr = new Label("TlfNr:");
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

        Label lblFirmaTlfNr = new Label("FirmaTlfNr:");
        this.deltagerGridPane.add(lblFirmaTlfNr, 2, 6);

        this.txfFirmaTlfNr = new TextField();
        this.deltagerGridPane.add(this.txfFirmaTlfNr, 3, 6);

        lblPageNumber = new Label("Side 2/4");
        lblPageNumber.setFont(Font.font(12));
        deltagerGridPane.add(lblPageNumber, 3, 0);
        GridPane.setHalignment(lblPageNumber, HPos.RIGHT);
        //-----------------------------------------

        //this.ledsagerGridPane.setPrefWidth(500);
        this.ledsagerGridPane.setStyle("-fx-border-style: solid; -fx-border-width: 3; -fx-border-radius: 10;");
        this.ledsagerGridPane.setPadding(new Insets(10));
        this.ledsagerGridPane.setHgap(10);
        this.ledsagerGridPane.setVgap(10);
        this.ledsagerGridPane.setGridLinesVisible(false);
        this.ledsagerGridPane.setDisable(false);
        content.getChildren().add(this.ledsagerGridPane);

        Label lblLedsagerHeader = new Label("Ledsager:");
        lblLedsagerHeader.setFont(new Font(15));
        GridPane.setHalignment(lblLedsagerHeader, HPos.RIGHT);
        this.ledsagerGridPane.add(lblLedsagerHeader, 0, 0, 3, 1);

        Label lblLedsager = new Label("Ledsager medbringes:");
        this.chbLedsager = new CheckBox();
        this.chbLedsager.setOnAction(event -> this.checkboxLedsagerAction());
        lblLedsager.setGraphic(this.chbLedsager);
        lblLedsager.setContentDisplay(ContentDisplay.RIGHT);
        this.ledsagerGridPane.add(lblLedsager, 0, 1, 3, 1);

        this.lblLedsagerNavn = new Label("Ledsagerens navn:");
        this.lblLedsagerNavn.setDisable(true);
        this.ledsagerGridPane.add(this.lblLedsagerNavn, 0, 2, 3, 1);

        this.txfLedsagerNavn = new TextField();
        this.txfLedsagerNavn.setDisable(true);
        this.ledsagerGridPane.add(this.txfLedsagerNavn, 2, 2);

        this.lblUdflugter = new Label("Tilgængelige udflugter:");
        this.lblUdflugter.setFont(new Font(15));
        this.lblUdflugter.setDisable(true);
        this.ledsagerGridPane.add(this.lblUdflugter, 0, 3);

        this.lvwUdflugter = new ListView<>();
        this.lvwUdflugter.setPrefSize(400, 130);
        this.lvwUdflugter.setDisable(true);
        this.lvwUdflugter.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.ledsagerGridPane.add(this.lvwUdflugter, 0, 4, 4, 1);

        ChangeListener<Udflugt> listenerUdflugt = (ov, oldUdflugt, newUdflugt) -> this.selectedUdflugtChanged();
        this.lvwUdflugter.getSelectionModel().selectedItemProperty().addListener(listenerUdflugt);

        lblPageNumber = new Label("Side 3/4");
        lblPageNumber.setFont(Font.font(12));

        ledsagerGridPane.add(lblPageNumber, 19, 0);
        GridPane.setHalignment(lblPageNumber, HPos.RIGHT);

        //------------------------------------

        this.hotelGridPane.setStyle("-fx-border-style: solid; -fx-border-width: 3; -fx-border-radius: 10;");
        this.hotelGridPane.setPadding(new Insets(10));
        this.hotelGridPane.setHgap(10);
        this.hotelGridPane.setVgap(10);
        this.hotelGridPane.setDisable(false);
        content.getChildren().add(this.hotelGridPane);


        Label lblHotelHeader = new Label("Hotel:");
        lblHotelHeader.setFont(new Font(15));
        GridPane.setHalignment(lblHotelHeader, HPos.RIGHT);
        this.hotelGridPane.add(lblHotelHeader, 0, 0, 6, 1);

        Label lblHotel = new Label("Ønsker du at reservere et hotelværelse?:");
        this.chbHotel = new CheckBox();
        this.chbHotel.setOnAction(event -> this.checkboxHotelAction());
        lblHotel.setGraphic(this.chbHotel);
        lblHotel.setContentDisplay(ContentDisplay.RIGHT);
        GridPane.setHalignment(lblHotel, HPos.CENTER);
        this.hotelGridPane.add(lblHotel, 0, 1);

        this.lblHoteller = new Label("Tilgængelige hoteller");
        this.lblHoteller.setFont(new Font(14));
        this.lblHoteller.setDisable(true);
        this.hotelGridPane.add(this.lblHoteller, 0, 2);

        this.lvwHoteller = new ListView<>();
        this.lvwHoteller.setPrefSize(200, 175);
        this.lvwHoteller.setDisable(true);
        this.hotelGridPane.add(this.lvwHoteller, 0, 3);

        ChangeListener<Hotel> listenerHoteller = (ov, oldHotel, newHotel) -> this.selectedHotelChanged(newHotel);
        this.lvwHoteller.getSelectionModel().selectedItemProperty().addListener(listenerHoteller);

        this.lblTillæg = new Label("Tilgængelige tillæg:");
        this.lblTillæg.setFont(new Font(14));
        this.lblTillæg.setDisable(true);
        this.hotelGridPane.add(this.lblTillæg, 0, 4);

//        Label lblTotalPris = new Label("Samlet pris");
//        this.hotelGridPane.add(this.lblTotalPris, 0,5);

        this.lvwTillæg = new ListView<>();
        this.lvwTillæg.setPrefSize(200, 150);
        this.lvwTillæg.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.lvwTillæg.setDisable(true);
        this.hotelGridPane.add(this.lvwTillæg, 0, 5);

        ChangeListener<Tillæg> listenerTillægger = (ov, oldTillæg, newTillæg) -> this.selectedTillægChanged();
        this.lvwTillæg.getSelectionModel().selectedItemProperty().addListener(listenerTillægger);

        lblPageNumber = new Label("Side 4/4");
        lblPageNumber.setFont(Font.font(12));

        hotelGridPane.add(lblPageNumber, 27, 0);
        GridPane.setHalignment(lblPageNumber, HPos.RIGHT);
        this.lblTotalPris = new Label("Samlet pris");
        this.hotelGridPane.add(this.lblTotalPris, 0, 6);

        this.txfTotalPris = new TextField();
        this.txfTotalPris.setEditable(false); // Sørg for at tekstfeltet ikke er redigerbart
        HBox hboxTotalPris = new HBox(10); // Opretter en HBox til at indeholde label og tekstfelt
        hboxTotalPris.getChildren().addAll(lblTotalPris, this.txfTotalPris); // Tilføjer tekstfeltet og label til HBox
        this.hotelGridPane.add(hboxTotalPris, 0, 7); // Tilføjer HBox til hotelGridPane
        HBox buttonsBox = new HBox();
        buttonsBox.setAlignment(Pos.CENTER);
        buttonsBox.setSpacing(20);

        //----------------------
//        this.btnSlet = new Button("Start forfra");
//        this.btnSlet.setDisable(false);
//        this.btnSlet.setOnAction(event -> this.sletControls());
//        GridPane.setHalignment(this.btnSlet, HPos.CENTER);
//
//        HBox hbox = new HBox();
//
//        this.btnBekræft = new Button("Bekræft registration");
//        this.btnBekræft.setDisable(false);
//        this.btnBekræft.setOnAction(event -> this.bekræftAction());
//        hbox.getChildren().add(this.btnBekræft);
//
//        Label lblPris = new Label("Samlet pris: ");
//        hbox.getChildren().add(lblPris);
//
//        this.txfTotalPris = new TextField();
//        this.txfTotalPris.setEditable(false);
//        HBox hboxTotalPris = new HBox(3);
//        hboxTotalPris.getChildren().addAll(this.txfTotalPris, lblPris);
//
//        this.hotelGridPane.add(hboxTotalPris, 0, 13);
//
//        content.getChildren().addAll(this.btnSlet, this.btnBekræft, this.txfTotalPris);
//        this.setContent(content);
//        this.setFitToWidth(true);

        this.btnClear = new Button("Start forfra");
        this.btnClear.setDisable(true);
        this.btnClear.setOnAction(event -> this.clearControls());

        HBox hbox = new HBox();

        this.btnBekræft = new Button("Bekræft registration");
        this.btnBekræft.setDisable(true);
        this.btnBekræft.setOnAction(event -> this.bekræftAction());
        hbox.getChildren().add(this.btnBekræft);

        buttonsBox.getChildren().addAll(this.btnClear, this.btnBekræft);

        this.txfTotalPris.setEditable(false);

        this.hotelGridPane.add(buttonsBox, 0, 12, 6, 1); // Adding buttonsBox to hotelGridPane

        lblPageNumber = new Label("Side 4/4");
        lblPageNumber.setFont(Font.font(12));
        hotelGridPane.add(lblPageNumber, 27, 0);
        GridPane.setHalignment(lblPageNumber, HPos.RIGHT);

        content.getChildren().add(buttonsBox); // Adding buttonsBox and txfTotalPris to content
        content.setAlignment(Pos.CENTER);

        this.setContent(content);
        this.setFitToWidth(true);

        this.hotelGridPane.setDisable(true);
        this.ledsagerGridPane.setDisable(true);
        this.deltagerGridPane.setDisable(true);
    }

    /**
     * Når en deltager vælger en konference
     */
    private void selectedKonferenceChanged(Konference newKonference) {
        boolean isNull = newKonference == null;
        this.btnBekræft.setDisable(false);
        this.btnClear.setDisable(false);

        this.deltagerGridPane.setDisable(isNull);
        this.ledsagerGridPane.setDisable(isNull);
        this.hotelGridPane.setDisable(isNull);
        this.btnBekræft.setDisable(isNull);
        this.btnClear.setDisable(isNull);

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

    /**
     * Når en deltager har valgt tillæg
     */
    private void selectedTillægChanged() {
        this.updatePris();
    }

    /**
     * Når en ledsager har valgt en udflugt, opdateres prisen
     */
    private void selectedUdflugtChanged() {
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
            this.lvwTillæg.getItems().setAll(newHotel.getTillæg());
        } else {
            this.lvwTillæg.getItems().clear();
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
        this.lblTillæg.setDisable(!checked);
        this.lvwTillæg.setDisable(!checked);

        if (!checked) {
            this.lvwHoteller.getSelectionModel().clearSelection();
        }
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
        this.updatePris();
    }

    /**
     * Opdaterer den samlede pris
     */
    private void updatePris() {
        if (this.konference != null && this.dtpStart.getValue() != null && this.dtpSlut.getValue() != null) {
            int antalOpholdsDage = (int) ChronoUnit.DAYS.between(this.dtpStart.getValue(), this.dtpSlut.getValue());
            int konferencePris = 0;

            if (!this.chbForedragsholder.isSelected()) {
                konferencePris = this.konference.getKonferenceAfgift() * (antalOpholdsDage + 1);
            }
            int hotelPris = 0;
            if (this.hotel != null) {
                int tillægsPris = 0;
                for (Tillæg tillæg : this.lvwTillæg.getSelectionModel().getSelectedItems()) {
                    tillægsPris += tillæg.getPris();
                }
                if (this.chbLedsager.isSelected()) {
                    hotelPris = (hotel.getDoublePris() + tillægsPris) * antalOpholdsDage;
                } else {
                    hotelPris = (hotel.getSinglePris() + tillægsPris) * antalOpholdsDage;
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
     * Når en datepicker skifter værdi
     */
    private void datePickerChanged() {
        this.updatePris();
    }

    /**
     * Når det er valgt om man er foredragsholder
     */
    private void checkboxForedragsholderAction() {
        this.updatePris();
    }


    /**
     * Bekræfter registration af brugeren og opretter igennem controller
     */
    private void bekræftAction() {
        String navn = txfNavn.getText().trim();
        String adresse = txfAdresse.getText().trim();
        String land = txfLand.getText().trim();
        String by = txfBy.getText().trim();
        String tlfNr = txfTlfNr.getText().trim();
        EnumVærelser.Værelser værelseType = EnumVærelser.Værelser.SINGLE;

        Deltager deltager = Controller.createDeltager(navn, adresse, land, by, tlfNr);

        String firmaTlfNr = txfFirmaTlfNr.getText().trim();
        String firmaNavn = txfFirmaNavn.getText().trim();
        LocalDate ankomstDato = dtpStart.getValue();
        LocalDate afskedsdato = dtpSlut.getValue();
        boolean foredragsholder = this.chbForedragsholder.isSelected();

        Registration registration = Controller.createRegistration(firmaTlfNr, firmaNavn, ankomstDato, afskedsdato, foredragsholder, deltager, this.konference);

        if (this.chbLedsager.isSelected()) {
            String ledsagerNavn = txfLedsagerNavn.getText().trim();
            Ledsager ledsager = Controller.createLedsager(ledsagerNavn, registration);
            værelseType = EnumVærelser.Værelser.DOUBLE;

            for (Udflugt udflugt : this.lvwUdflugter.getSelectionModel().getSelectedItems()) {
                ledsager.addUdflugt(udflugt);
            }
        }

        if (this.chbHotel.isSelected()) {
            int maxVærelsesNr = 0;
            for (HotelBooking hotelBooking : this.hotel.getHotelBookinger()) {
                if (hotelBooking.getNummer() > maxVærelsesNr) {
                    maxVærelsesNr = hotelBooking.getNummer();
                }
            }

            int værelsesNr = maxVærelsesNr + 1;
            int pris = Integer.parseInt(txfTotalPris.getText());

            HotelBooking hotelBooking = Controller.createHotelBooking(værelsesNr, pris, værelseType, this.hotel);

            for (Tillæg tillæg : this.lvwTillæg.getSelectionModel().getSelectedItems()) {
                Controller.addTillægToHotelBooking(hotelBooking, tillæg);
            }
            Controller.setHotelVærelseOfRegistration(registration, hotelBooking);
        }

        this.clearControls();
        updatePris();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registrering gennemført!");
        alert.setHeaderText("Registrering gennemført!");
        alert.setContentText("Tak for at du registrerede dig til " + registration.getKonference().getNavn() + ", " + deltager.getNavn() +  "!\n Hav en fortsat god dag.");
        alert.showAndWait();

        System.out.println(Controller.getHoteller());

        System.out.println("Antal deltagere til alle konferencer: " + Controller.getDeltager().size());
        for (Konference konference : Controller.getKonferencer()) {
            System.out.println("Deltagere til konferencen " + konference.getNavn() + ": " + konference.listParticipantsForKonference());
        }
        System.out.println();

        System.out.println("Registrationsdetaljer for: " + deltager.getNavn());
        System.out.println("Konference: " + registration.getKonference().getNavn());
        System.out.println("Ankomst Dato: " + registration.getAnkomstDato());
        System.out.println("Afskeds Dato: " + registration.getAfstedsDato());
        System.out.println("Foredragsholder: " + registration.isForedragsholder());
        if (registration.getHotelVærelse() != null) {
            System.out.println("Hotel: " + registration.getHotelVærelse().getHotel().getNavn());
            System.out.println("Værelse Nummer: " + registration.getHotelVærelse().getNummer());
            System.out.println("Værelse Pris: " + registration.getHotelVærelse().calculateVærelsesPris());
        }
        if (registration.getLedsager() != null) {
            System.out.println("Ledsager: " + registration.getLedsager().getNavn());
            System.out.println("Udflugter:");
            for (Udflugt udflugt : registration.getLedsager().getUdflugter()) {
                System.out.println("- " + udflugt.getDestination() + " d. " + udflugt.getDato() + " med pris " + udflugt.getPris());
            }
        }
        System.out.println("Samlet pris: " + registration.calculateTotalPris());
        System.out.println("--------------------------------------");
        // ---------------- END


//        // Tjek om alle krævede felter er udfyldt, altså om de har "valid" css classen
//        ArrayList<TextField> errorableTextFields = new ArrayList<>(Arrays.asList(
//                this.txfNavn, this.txfAdresse, this.txfBy, this.txfLand, this.txfTlfNr));
//        for (TextField textField : errorableTextFields) {
//            if (!textField.getStyleClass().contains("valid")) {
//                return;
//            }
//        }
//
//        // Hvis enten firmanavn eller firma tlf. nr. er skrevet skal begge udfyldes
//        if (this.txfFirmaNavn.getText().trim().length() != 0 || this.txfFirmaTlfNr.getText().trim().length() != 0) {
//
//            if (!this.txfFirmaNavn.getStyleClass().contains("valid")) {
//                return;
//
//            } else if (!this.txfFirmaTlfNr.getStyleClass().contains("valid")) {
//                return;
//            }
//        }
//// Hvis medbring ledsager er valgt, så skal ledsager navn også være udfyldt,
//        if (this.chbLedsager.isSelected() && !this.txfFirmaNavn.getStyleClass().contains("valid")) {
//
//            return;
//        }
//
//        String navn = this.txfNavn.getText().trim();
//        String adresse = this.txfAdresse.getText().trim();
//        String by = this.txfBy.getText().trim();
//        String land = this.txfLand.getText().trim();
//        String telefon = this.txfTlfNr.getText().trim();
//        String firmaNavn = this.txfFirmaNavn.getText().trim();
//        String FirmaTlfNr = this.txfFirmaTlfNr.getText().trim();
//        String ledsagerNavn = this.txfFirmaNavn.getText().trim();
//
//        boolean foredragsholder = this.chbForedragsholder.isSelected();
//
//                LocalDate arrivalDate = this.dtpStart.getValue();
//                LocalDate departureDate = this.dtpSlut.getValue();
//        // Hvis deltager med samme navn og tlf. nr. findes, så tilføj registration til den deltager.
//        // Ellers lav en ny deltager.
//        Deltager deltager = null;
//        for (Deltager d : Controller.getDeltager()) {
//            if (navn.equalsIgnoreCase(d.getNavn()) && telefon.equalsIgnoreCase(d.getTlfNr())) {
//                deltager = d;
//                break;
//            }
//        }
//        if (deltager == null) {
//            deltager = Controller.createDeltager(navn, telefon, adresse, land, by);
//        }
//
//        Registration registration = Controller.createRegistration(FirmaTlfNr, firmaNavn, arrivalDate, departureDate, foredragsholder, deltager, this.konference);
//
//        // Hvis medbring ledsager er valgt, skal vi lave en ledsager på registrationen,
//        // samt udflugter til ledsageren.
//        if (this.chbLedsager.isSelected()) {
//            Ledsager ledsager = registration.createLedsager(this.txfLedsagerNavn.getText().trim());
//
//            for (Udflugt udflugt : this.lvwUdflugter.getSelectionModel().getSelectedItems()) {
//                ledsager.addUdflugt(udflugt);
//            }
//        }
//
//        // Hvis deltageren gerne vil ansøge om hotel gennem os, skal registrationen gives et hotelværelse,
//        // samt tilføje de valgte tillæg til hotelværelset.
//        if (this.chbHotel.isSelected()) {
//            HotelBooking hotelBooking = Controller.createHotelVærelse(101,200, EnumVærelser.Værelser.SINGLE, hotel);
//
//            for (Tillæg tillæg : this.lvwTilægger.getSelectionModel().getSelectedItems()) {
//                hotelBooking.addTillæg(tillæg);
//            }
//
//            registration.setHotelBooking(hotelBooking);
//        }
//
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Registrering gennemført!");
//        alert.setHeaderText("Registrering gennemført!");
//        alert.setContentText("Tak for at du registrerede dig til " + this.konference.getNavn() + " " + deltager.getNavn());
//        alert.showAndWait();
//        this.clearControls();
        // Tjek om alle krævede felter er udfyldt, altså om de har "valid" css classen
//        ArrayList<TextField> errorableTextFields = new ArrayList<>(Arrays.asList(
//                this.txfNavn, this.txfAdresse, this.txfBy, this.txfLand, this.txfTlfNr));
//        for (TextField textField : errorableTextFields) {
//            if (!textField.getStyleClass().contains("valid")) {
//                textField.getStyleClass().add("error");
//                return;
//            }
//        }
//
//        // Hvis enten firmanavn eller firma tlf. nr. er skrevet skal begge udfyldes
//        if (this.txfFirmaNavn.getText().trim().length() != 0 || this.txfFirmaTlfNr.getText().trim().length() != 0) {
//            if (!this.txfFirmaNavn.getStyleClass().contains("valid")) {
//                //App.addClass(this.txfFirmaNavn, "error");
//                return;
//            } else if (!this.txfFirmaTlfNr.getStyleClass().contains("valid")) {
//               //App.addClass(this.txfFirmaTlfNr, "error");
//                return;
//            }
//        }
//
//        // Hvis medbring ledsager er valgt, så skal ledsager navn også være udfyldt,
//        // ellers tilføj "error" css class til ledsager navn textfield
//        if (this.chbLedsager.isSelected() && !this.txfFirmaNavn.getStyleClass().contains("valid")) {
//           // App.addClass(this.txfFirmaNavn, "error");
//            return;
//        }
//
//        // --------------------------------------------------------------
//
//        String name = this.txfNavn.getText().trim();
//        String address = this.txfAdresse.getText().trim();
//        String city = this.txfBy.getText().trim();
//        String country = this.txfLand.getText().trim();
//        String telephone = this.txfTlfNr.getText().trim();
//        String companyName = this.txfFirmaNavn.getText().trim();
//        String companyTelephone = this.txfFirmaTlfNr.getText().trim();
//        String companionName = this.txfLedsagerNavn.getText().trim();
//
//
//        boolean speaker = this.chbForedragsholder.isSelected();
//
//        LocalDate arrivalDate = this.dtpStart.getValue();
//        LocalDate departureDate = this.dtpSlut.getValue();
//
//        // Hvis deltager med samme navn og tlf. nr. findes, så tilføj registration til den deltager.
//        // Ellers lav en ny deltager.
//        Deltager deltager = null;
//        for (Deltager d : Controller.getDeltager()) {
//            if (name.equalsIgnoreCase(d.getNavn()) && telephone.equalsIgnoreCase(d.getTlfNr())) {
//                deltager = d;
//                break;
//            }
//        }
//        if (deltager == null) {
//            deltager = Controller.createDeltager(name, telephone, address, country, city);
//        }
//
//        Registration registration = Controller.createRegistration(companyName, companyTelephone, arrivalDate, departureDate, speaker, deltager, this.konference);
//
//        // Hvis medbring ledsager er valgt, skal vi lave en ledsager på registrationen,
//        // samt udflugter til ledsageren.
//        if (this.chbLedsager.isSelected()) {
//            Ledsager ledsager = registration.createLedsager(companionName);
//
//            for (Udflugt udflugt : this.lvwUdflugter.getSelectionModel().getSelectedItems()) {
//                ledsager.addUdflugt(udflugt);
//            }
//        }
//
//        // Hvis deltageren gerne vil ansøge om hotel gennem os, skal registrationen gives et hotelværelse,
//        // samt tilføje de valgte tillæg til hotelværelset.
////        if (this.chbHotel.isSelected()) {
////            HotelBooking hotelBooking = Controller.createHotelVærelse(EnumVærelser.Værelser.SINGLE, hotel);
////
////            for (Tillæg tillæg : this.lvwTilægger.getSelectionModel().getSelectedItems()) {
////                hotelBooking.addTillæg(tillæg);
////            }
////
////            registration.setHotelBooking(hotelBooking);
////        }
//
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Registrering gennemført!");
//        alert.setHeaderText("Registrering gennemført!");
//        alert.setContentText("Tak for at du registrerede dig til " + this.konference.getNavn() + " " + deltager.getNavn() + "! Hav en god dag");
//        alert.showAndWait();
//
//        this.clearControls();
    }

        /**
         * Nulstiller alle kontrol textfielder, datepickers, labels og lister.
         */
        private void clearControls () {
            this.lvwKonferencer.getSelectionModel().clearSelection();
            this.lvwUdflugter.getItems().clear();
            this.lvwUdflugter.setDisable(true);
            this.lvwHoteller.getItems().clear();
            this.lvwHoteller.setDisable(true);
            this.lvwTillæg.getItems().clear();
            this.lvwTillæg.setDisable(true);

            this.chbHotel.setSelected(false);
            this.chbLedsager.setSelected(false);
            this.chbForedragsholder.setSelected(false);

            this.dtpStart.setValue(null);
            this.dtpSlut.setValue(null);

            this.txfNavn.clear();
            this.txfAdresse.clear();
            this.txfBy.clear();
            this.txfLand.clear();
            this.txfTlfNr.clear();
            this.txfFirmaNavn.clear();
            this.txfFirmaTlfNr.clear();
            this.txfFirmaNavn.clear();
            this.txfTotalPris.clear();
            this.txfLedsagerNavn.clear();

            this.lblHoteller.setDisable(true);
            this.lblUdflugter.setDisable(true);
            this.lblTillæg.setDisable(true);
            this.lblLedsagerNavn.setDisable(true);
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
