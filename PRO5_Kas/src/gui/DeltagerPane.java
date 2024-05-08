package gui;

import controller.Controller;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import model.Deltager;
import javafx.scene.layout.GridPane;
import model.*;

import javafx.beans.value.ChangeListener;

public class DeltagerPane extends GridPane {

    private Deltager deltager;
    private ListView<Deltager> lvwDeltagere;
    private TextField txfNavn, txfAdresse,txfLand, txfBy, txfTlfNr;
    private TextArea txaRegistrationer;
    private Button btnSlet, btnRediger;

    DeltagerPane(){
        this.setPadding(new Insets(10));
        this.setHgap(10);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        //-----------------------------------------

        this.lvwDeltagere = new ListView<>();
        this.lvwDeltagere.setPrefSize(250,400);
        this.add(this.lvwDeltagere, 0,0,1,6);

        ChangeListener<Deltager> listener =  (ov, oldValue, newValue) -> this.selectedDeltagerChanged(newValue);
        this.lvwDeltagere.getSelectionModel().selectedItemProperty().addListener(listener);

        //-----------------------------------------------

        Label lblNavn = new Label("Navn:");
        this.add(lblNavn,1,0);

        Label lblAdresse = new Label("Adresse:");
        this.add(lblAdresse, 1,1);

        Label lblLand = new Label("Land:");
        this.add(lblLand,1,2);

        Label lblBy = new Label("By:");
        this.add(lblBy,1,3);

        Label lblTlfNr = new Label("TlfNr:");
        this.add(lblTlfNr,1,4);

        Label lblRegistrationer = new Label("Registrationer:");
        this.add(lblRegistrationer,1,5);

        this.txfNavn = new TextField();
        this.txfNavn.setEditable(false);
        this.add(this.txfNavn,2,0);

        this.txfAdresse = new TextField();
        this.txfAdresse.setEditable(false);
        this.add(txfAdresse,2,1);

        this.txfLand = new TextField();
        this.txfLand.setEditable(false);
        this.add(this.txfLand,2,2);

        this.txfBy = new TextField();
        this.txfBy.setEditable(false);
        this.add(this.txfBy, 2,3);

        this.txfTlfNr = new TextField();
        this.txfTlfNr.setEditable(false);
        this.add(this.txfTlfNr,2,4);

        this.txaRegistrationer = new TextArea();
        this.txaRegistrationer.setPrefSize(200,100);
        this.txaRegistrationer.setEditable(false);
        this.add(this.txaRegistrationer, 2,5);

        //-------------------------------------

        HBox hbox = new HBox(10);
        this.add(hbox, 0,6);

        this.btnSlet = new Button("Slet deltager");
        this.btnSlet.setOnAction(event -> this.deleteAction());
        hbox.getChildren().add(this.btnSlet);

        this.btnRediger = new Button("Rediger");
        this.btnRediger.setOnAction(event -> this.redigerAction());
        hbox.getChildren().add(this.btnRediger);

        //-------------------------------------

        this.updateDeltager();
        this.updateButtons();

    }

    private void selectedDeltagerChanged(Deltager deltager){
        this.deltager = deltager;

        this.updateControls();

    }
    //----------------------------------------
    private void updateControls(){
        if(this.deltager != null){
            this.txfNavn.setText(this.deltager.getNavn());
            this.txfAdresse.setText(this.deltager.getAdresse());
            this.txfLand.setText(this.deltager.getLand());
            this.txfBy.setText(this.deltager.getBy());
            this.txfTlfNr.setText(this.deltager.getTlfNr());

            StringBuilder registrationer = new StringBuilder();
            for (Registration registration : this.deltager.getRegistrationer()) {
                registrationer.append(registration.getKonference().getNavn()).append("\n");
            }
            this.txaRegistrationer.setText(registrationer.toString());
        }
        this.updateButtons();
    }

    private void updateButtons(){
        boolean deltager = this.deltager == null;
        this.btnSlet.setDisable(deltager);
        this.btnRediger.setDisable(deltager);
    }

    private void updateDeltager(){
        this.lvwDeltagere.getItems().setAll(Controller.getDeltagere());
    }

    private void clearTextFields(){
        this.txfNavn.clear();
        this.txfAdresse.clear();
        this.txfLand.clear();
        this.txfBy.clear();
        this.txfTlfNr.clear();
        this.txaRegistrationer.clear();

        this.updateButtons();

    }

    private void deleteAction(){
        Controller.removeDeltager(this.deltager);

        this.deltager = null;
        this.clearTextFields();
        this.updateDeltager();
    }

    private void redigerAction(){
        UpdateDeltagerWindow updateDeltagerWindow = new UpdateDeltagerWindow(this.deltager);
        updateDeltagerWindow.showAndWait();

        this.updateControls();
        this.updateDeltager();
    }



}
