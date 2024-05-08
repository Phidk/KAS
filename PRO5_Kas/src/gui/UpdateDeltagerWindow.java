package gui;

import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import model.Deltager;


public class UpdateDeltagerWindow extends Stage {

    private Deltager deltager;

    private TextField txfNavn, txfAdresse, txfLand, txfBy, txfTlfNr;


    UpdateDeltagerWindow(Deltager deltager){
        this.initStyle(StageStyle.DECORATED);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setTitle("Rediger deltager");

        this.deltager = deltager;

        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }
        //---------------------------------------
    private void initContent(GridPane pane){
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        //---------------------------------------

        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0,1);

        Label lblAdresse = new Label("Adresse:");
        pane.add(lblAdresse, 0,2);

        Label lblLand = new Label("Land:");
        pane.add(lblLand,0,3);

        Label lblBy = new Label("By:");
        pane.add(lblBy, 0,4);

        Label lblTlfNr = new Label("TlfNr:");
        pane.add(lblTlfNr,0,5);

        this.txfNavn = new TextField();
        pane.add(this.txfNavn,1,1);

        this.txfAdresse = new TextField();
        pane.add(this.txfAdresse,1,2);

        this.txfLand = new TextField();
        pane.add(this.txfLand, 1,3);

        this.txfBy = new TextField();
        pane.add(this.txfBy,1,4);

        this.txfTlfNr = new TextField();
        pane.add(this.txfTlfNr, 1,5);

        //-------------------------------------
        Button btnAnnuller = new Button("Annuller");
        btnAnnuller.setOnAction(event -> this.annullerAction());
        pane.add(btnAnnuller, 0,6);

        Button btnGem = new Button("Gem");
        btnGem.setOnAction(event -> this.gemAction());
        pane.add(btnGem, 1,6);

        this.initControls();
    }
    private void initControls () {
        txfNavn.setText(deltager.getNavn());
        txfAdresse.setText(this.deltager.getAdresse());
        txfLand.setText(this.deltager.getLand());
        txfBy.setText(this.deltager.getBy());
        txfTlfNr.setText(this.deltager.getTlfNr());
    }

    private void gemAction () {
        String navn = this.txfNavn.getText().trim();
        String adresse = this.txfAdresse.getText().trim();
        String land = this.txfLand.getText().trim();
        String by = this.txfBy.getText().trim();
        String tlfNr= this.txfTlfNr.getText().trim();

        this.deltager.setNavn(navn);
        this.deltager.setAdresse(adresse);
        this.deltager.setLand(land);
        this.deltager.setBy(by);
        this.deltager.setTlfNr(tlfNr);

        this.hide();
    }
    private void annullerAction(){
        this.hide();
    }
}
