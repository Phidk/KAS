package gui;

import controller.Controller;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Deltager;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import model.*;
import java.time.LocalDate;

public class DeltagerPane extends Application {

    private final ListView<Konference> lvwKonferencer = new ListView<>();
    private final ListView<Udflugt> lvwUdflugter = new ListView<>();
    private final ListView<Hotel> lvwHoteller = new ListView<>();

    


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

        lvwKonferencer.setPrefSize(300, 200);
        Label lblKonference = new Label(" Tilgængelige Konferencer");
        pane.add(lblKonference, 0, 0);
        pane.add(lvwKonferencer, 0, 1);
        lvwKonferencer.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

        });

        lvwHoteller.setPrefSize(300, 200);
        Label lblKunder = new Label("Kunder");
        pane.add(lblKunder, 1, 0);
        pane.add(lvwKunde, 1, 1);

    }

    private void opdaterKonferencer() {
    }


    private void opdaterUdflugter() {
    }

    private void opdaterHoteller() {
    }


}
