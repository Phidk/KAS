package gui;

import java.time.format.DateTimeFormatter;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import model.Konference;
import model.Udflugt;


public class UdflugterPane extends GridPane {

    private Udflugt udflugt;
    private final ListView<Udflugt> lvwUdflugter;
    private TextField txfNavn, txfDato, txfPris, txfDestination;
    private CheckBox chbFrokost;
    private TextArea txaKonference;
    private Button btnSlet, btnOpdater;

    public UdflugterPane() {

        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        this.lvwUdflugter = new ListView<>();
        this.lvwUdflugter.setPrefSize(250, 400);
        this.add(this.lvwUdflugter, 0, 0, 1, 7);

        ChangeListener<Udflugt> listener = (ov, oldValue, newValue) -> this.selectedUdflugtChanged(newValue);
        this.lvwUdflugter.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblNavn = new Label("Navn:");
        this.add(lblNavn, 1, 0);

        Label lblDestination = new Label("Destination:");
        this.add(lblDestination, 1, 1);

        Label lblDato = new Label("Dato");
        this.add(lblDato, 1, 2);

        Label lblPris = new Label("Pris:");
        this.add(lblPris, 1, 3);

        Label lblFrokost = new Label("Frokost inkluderet:");
        this.add(lblFrokost, 1, 4);

        Label lblKonferencer = new Label("Konferencer:");
        this.add(lblKonferencer, 1, 6);

        this.txfNavn = new TextField();
        this.txfNavn.setEditable(false);
        this.add(this.txfNavn, 2, 0);

        this.txfDestination = new TextField();
        this.txfDestination.setEditable(false);
        this.add(this.txfDestination, 2, 1);

        this.txfDato = new TextField();
        this.txfDato.setEditable(false);
        this.add(this.txfDato, 2, 2);

        this.txfPris = new TextField();
        this.txfPris.setEditable(false);
        this.add(this.txfPris, 2, 3);

        this.chbFrokost = new CheckBox();
        this.chbFrokost.setDisable(true);
        this.chbFrokost.setOpacity(1);
        this.add(this.chbFrokost, 2, 4);

        this.txaKonference = new TextArea();
        this.txaKonference.setPrefSize(200, 100);
        this.txaKonference.setEditable(false);
        this.add(this.txaKonference, 2, 6);


        HBox hBox = new HBox(10);
        this.add(hBox, 0, 7);

        this.btnSlet = new Button("Slet");
        this.btnSlet.setOnAction(event -> this.deleteAction());
        hBox.getChildren().add(this.btnSlet);

        this.btnOpdater = new Button("Opdater");
        this.btnOpdater.setOnAction(event -> this.opdaterAction());
        hBox.getChildren().add(this.btnOpdater);

        Button btnCreate = new Button("Opret");
        btnCreate.setOnAction(event -> this.createAction());
        hBox.getChildren().add(btnCreate);


      this.opdaterUdflugter();
       this.opdaterButtons();

    }


    // -----------------------------------------------------

    private void selectedUdflugtChanged(Udflugt udflugter) {

        this.udflugt = udflugter;

        this.OpdaterControls();
    }

    // --------------------------------------------


    private void OpdaterControls () {
        this.clearControls();


        if (this.udflugt != null) {

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            this.txfNavn.setText(this.udflugt.getNavn());
            this.txfDestination.setText(this.udflugt.getDestination());
            this.txfDato.setText(this.udflugt.getDato().format(dtf));
            this.txfPris.setText(this.udflugt.getPris() + "");
            this.chbFrokost.setSelected(this.udflugt.frokost);

            StringBuilder konferencer = new StringBuilder();
            for (Konference konference : Controller.getKonferencer()) {
                if (konference.getUdflugter().contains(this.udflugt)) {
                    konferencer.append(konference.getNavn()).append("\n");

                }

            }
            this.txaKonference.setText(konferencer.toString());
        }

        this.opdaterButtons();
    }


    private void opdaterButtons() {

        boolean Udflugt = this.udflugt == null;

        this.btnSlet.setDisable(Udflugt);
        this.btnOpdater.setDisable(Udflugt);
    }

    private void opdaterUdflugter() {
        this.lvwUdflugter.getItems().setAll(Controller.getUdflugter());
    }

    private void clearControls () {

        this.txfNavn.clear();
        this.txfDestination.clear();
        this.txfPris.clear();
        this.txfDato.clear();
        this.chbFrokost.setSelected(false);
        this.txaKonference.clear();

        this.opdaterButtons();
    }



    private void createAction () {
        CreateUdflugterWindow createUdflugterWindow = new CreateUdflugterWindow();
        createUdflugterWindow.showAndWait();

        this.udflugt = createUdflugterWindow.getUdflugter();
        this.OpdaterControls();
        this.opdaterUdflugter();
    }

    private void opdaterAction () {
        CreateUdflugterWindow createUdflugterWindow = new CreateUdflugterWindow(this.udflugt);
        createUdflugterWindow.showAndWait();

        this.OpdaterControls();
        this.opdaterUdflugter();

    }

    private void deleteAction () {
        boolean udflugtExistsInAnyKonference = false;

        for (Konference konference : Controller.getKonferencer()) {
            if (konference.getUdflugter().contains(this.udflugt)) {
                udflugtExistsInAnyKonference = true;
            }
        }

        if (udflugtExistsInAnyKonference) {
            for (Konference konference : Controller.getKonferencer()) {
                Controller.removeUdflugt(konference, this.udflugt);
            }
        } else {
            Controller.removeUdflugt(this.udflugt);
        }

        this.udflugt = null;
        this.clearControls();
        this.opdaterUdflugter();
    }
}

