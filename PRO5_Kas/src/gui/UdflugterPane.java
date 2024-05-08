package gui;

import java.time.LocalDate;
import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Konference;
import model.Udflugt;


public class UdflugterPane extends Stage {

    private TextField txfNavn, txfDato, txfPris, txfDestination, txfFrokost;
    private ListView<Konference> lvwKonferencer = new ListView<>();

    private Udflugt udflugt;

    public UdflugterPane (String title) {
            this.initStyle(StageStyle.UTILITY);
            this.initModality(Modality.APPLICATION_MODAL);
            this.setResizable(false);
            this.setTitle(String.format("%s udflugt - KAS", (udflugt != null) ? "Opdater" : "Opret"));

            this.udflugt = Udflugt;

            GridPane pane = new GridPane();
            this.initContent(pane);

            Scene scene = new Scene(pane);
            this.setScene(scene);
        }


        private void initContent(GridPane pane) {
            pane.setPadding(new Insets(20));
            pane.setHgap(10);
            pane.setVgap(10);
            pane.setGridLinesVisible(false);

            VBox vBox = new VBox();
            pane.add(vBox, 0, 0, 2, 1);

            Label lblTitel = new Label("Navn");
            pane.add(lblTitel,0,1);

            txfNavn = new TextField();
            pane.add(txfNavn,1,0,2,1);
            txfNavn.setPrefWidth(200);

            Label lblDato = new Label("Dato (yyyy-mm-dd)");
            pane.add(lblDato,0,1);

            txfDato = new TextField();
            pane.add(txfDato,1,1,2,1);
            txfDato.setPrefWidth(200);

            Label lblPris = new Label("Pris");
            pane.add(lblPris,0,2);

            txfPris = new TextField();
            pane.add(txfPris,1,2,2,1);
            txfPris.setPrefWidth(200);

            Label lblKonference = new Label("Vælg konference");
            pane.add(lblKonference,0,3);


            lvwKonferencer.setEditable(false);
            lvwKonferencer.setPrefHeight(150);
            lvwKonferencer.getItems().setAll(Controller.getKonferencer());
            pane.add(lvwKonferencer,1,3,2,1);

            Button btnCreate = new Button("Opret");
            pane.add(btnCreate,1,5);
            btnCreate.setOnAction(event -> this.createAction());

            Button btnCancel = new Button("Fortryd");
            pane.add(btnCancel,2,5);
            btnCancel.setOnAction(event -> this.cancelAction());
        }


    private void cancelAction() {
        this.hide();
    }


    private void createAction() {
        String navn = txfNavn.getText().trim();
        String destination = txfDestination.getText().trim();
        LocalDate dato = LocalDate.parse(txfDato.getText());
        int pris = Integer.valueOf(txfPris.getText()); // ikke sikker på om det skal være int eller double og valueof
        boolean frokost = Boolean.getBoolean(txfFrokost.getText()); // ikke sikker
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        if (navn.length() > 0 && dato.isAfter(LocalDate.now())) {
            Controller.createUdflugt(destination, dato, pris, frokost, konference); // hjælp
            this.hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Opret arrangement");
            alert.setHeaderText("Alle informationer skal være gylidge!");
            alert.showAndWait();
        }
    }
}