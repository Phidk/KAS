package gui;


import controller.Controller;
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

public class DeltagerRegistrationPane extends GridPane {

//    private Konference konference;
//    private Hotel hotel;
//
//    private final GridPane deltagerGridpane;
//    private final GridPane ledsagerGridpane;
//    private final GridPane hotelGridpane;
//
//    private final ListView<Konference> lvwKonferencer;
//    private final ListView<Udflugt> lvwUdflugter;
//    private final ListView<Hotel> lvwHoteller;
//    private final ListView<Tillæg> lvwTilægger;
//
//    private final TextField txfNavn, txfAdresse, txfBy, txfLand, txfFirmaNavn;
//    private final TextField txfForedragsholder, txfTlfNr, txfAnkomstDato, txfAfrejseDato, txfFirmaTlfNr;
//
//    private final Label lblName, lblAdresse, lblBy, lblLand, lblFirmaNavn;
//    private final Label lblForedragsholder, lblTlfNr, lblAnkomstDato, lblAfrejseDato, lblFirmaTlfNr;
//
//    private final CheckBox chbForedragsholder, chbLedsager, chbHotel;
//    private final Button btnSlet, btnBekræft;
//
//    /**
//     * Initialiserer deltagerens registrationspane
//     */
//
//    public DeltagerRegistrationPane() {
//        this.setPadding(new Insets(10));
//        this.setHgap(10);
//        this.setVgap(10);
//        this.setGridLinesVisible(false);
//        //----------------------------------------
//        GridPane conferencesGridPane = new GridPane();
//        conferencesGridPane.setStyle("-fx-border-style: solid; -fx-border-width: 3; -fx-border-radius: 10;");
//        conferencesGridPane.setPadding(new Insets(10));
//        conferencesGridPane.setHgap(10);
//        conferencesGridPane.setVgap(10);
//        conferencesGridPane.setGridLinesVisible(false);
//        this.add(conferencesGridPane, 0, 0, 2, 1);
//
//        Label lblConferenceHeader = new Label("Vælg konference");
//        lblConferenceHeader.setFont(new Font(25));
//        GridPane.setHalignment(lblConferenceHeader, HPos.CENTER);
//        conferencesGridPane.add(lblConferenceHeader, 0, 0);
//
//        this.lvwKonferencer = new ListView<>();
//        this.lvwKonferencer.getItems().setAll(Controller.getKonferencer());
//        this.lvwKonferencer.setPrefSize(300, 300);
//
//
//        lvwRegistrationer = new ListView<>();
//        lvwUdflugter = new ListView<>();
//    }
//}
}



