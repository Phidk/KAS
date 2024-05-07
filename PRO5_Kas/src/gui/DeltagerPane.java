package gui;

import controller.Controller;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Deltager;
import javafx.scene.layout.GridPane;
import model.*;
import java.time.LocalDate;

public class DeltagerPane extends Application {

    private final ListView<Konference> lvwKonferencer = new ListView<>();
    private final ListView<Udflugt> lvwUdflugter = new ListView<>();
    private final ListView<Hotel> lvwHoteller = new ListView<>();

    private final TextField txfKonferenceNavn = new TextField();
    private final TextField txfUdflugtNavn = new TextField();
    private final TextField txfHotelNavn = new TextField();

    @Override
    public void start(Stage stage) {
        stage.setTitle(" KAS Projekt");

        opdaterKonferencer();
        opdaterUdflugter();
        opdaterHoteller();

        GridPane pane = new GridPane();
        pane.setHgap(20);
        pane.setVgap(20);
        pane.setPadding(new Insets(20));
        pane.setGridLinesVisible(false);

                                                  // Konferencer//
        //--------------------------------------------------------------------------------------------------//

        lvwKonferencer.setPrefSize(300, 200);
        Label lblKonference = new Label(" Tilgængelige Konferencer");
        pane.add(lblKonference, 0, 0);
        pane.add(lvwKonferencer, 0, 1);
        lvwKonferencer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

        });
        // Udflugter//
        //--------------------------------------------------------------------------------------------------//

        lvwUdflugter.setPrefSize(300, 200);
        Label lblUdflugt = new Label("Pladser");
        pane.add(lblUdflugt, 2, 0);
        pane.add(lvwUdflugter, 2, 1);

        // Hoteller//
        //--------------------------------------------------------------------------------------------------//

        lvwHoteller.setPrefSize(300, 200);
        Label lblHotel = new Label(" Tilgængelige Hoteller");
        pane.add(lvwHoteller, 1, 0);
        //,pane.add(lvwHoteller, 1, 1);


        VBox Konference = new VBox();
        Konference.setSpacing(10);
        txfKonferenceNavn.setPromptText("Forestillingens Navn");
        Button btnOpretKonference = new Button("Opret Forestilling");
        btnOpretKonference.setOnAction(event -> opretKonferenceAction());
        pane.add(Konference, 0, 2);


        VBox Udflugt = new VBox();
        Udflugt.setSpacing(10);
        txfUdflugtNavn.setPromptText(" Udflugter");
        Button btnOpretUdflugt = new Button(" Opret Udflugter");
        btnOpretUdflugt.setOnAction(event -> opretUdflugtAction());
        Udflugt.getChildren().addAll(txfUdflugtNavn, txfKonferenceNavn, btnOpretUdflugt);
        pane.add(Udflugt, 1, 2);


    }

    private void opretUdflugtAction() {




    }

    private void opretKonferenceAction() {




    }

    private void opdaterKonferencer() {
    }


    private void opdaterUdflugter() {
    }

    private void opdaterHoteller() {
    }



}
