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
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Konference;
import model.Udflugt;


public class CreateUdflugterWindow extends Stage {

    private Udflugt udflugter;

    private TextField txfNavn, txfPris, txfDestination;
    private DatePicker dtpDato;
    private CheckBox chbFrokost;
    private Label lblFejl;

    public CreateUdflugterWindow(Udflugt udflugter) {
            this.initStyle(StageStyle.UTILITY);
            this.initModality(Modality.APPLICATION_MODAL);
            this.setTitle(String.format("%s udflugt - KAS", (udflugter != null) ? "Opdater" : "Opret"));

            this.udflugter = udflugter;

            GridPane pane = new GridPane();
            this.initContent(pane);

            Scene scene = new Scene(pane);
            this.setScene(scene);
        }

        CreateUdflugterWindow() {this(null);}


    // ----------------------------------------------------------------------------------

        private void initContent(GridPane pane) {
            pane.setPadding(new Insets(10));
            pane.setHgap(10);
            pane.setVgap(10);
            pane.setGridLinesVisible(false);


            VBox vBox = new VBox();
            pane.add(vBox, 0, 0, 2, 1);

            Label lblNavn = new Label("Navn");
            pane.add(lblNavn,0,1);

            this.txfNavn = new TextField();
            pane.add(this.txfNavn,1,1);
            txfNavn.setPrefWidth(200);

            Label lblPris = new Label("Pris");
            pane.add(lblPris,0,2);

            this.txfPris = new TextField();
            pane.add(this.txfPris,1,2);
            txfPris.setPrefWidth(200);

            Label lblDestination = new Label("Destination:");
            pane.add(lblDestination,0,3);

            this.txfDestination = new TextField();
            pane.add(this.txfDestination,1,3);
            txfDestination.setPrefWidth(200);

            Label lblDato = new Label("Dato:");
            pane.add(lblDato,0,4);

            this.dtpDato = new DatePicker();
            pane.add(this.dtpDato,1,4);

            Label lblFrokost = new Label("Frokost inkluderet:");
            pane.add(lblFrokost, 0, 5);

            this.chbFrokost = new CheckBox();
            pane.add(this.chbFrokost,1,5);


            this.lblFejl = new Label();
            this.lblFejl.setTextFill(Color.RED);
            pane.add(this.lblFejl, 0, 8, 2, 1);

//------------------------------------------------------------

 Button btnCancel = new Button("Afslut");
        btnCancel.setOnAction(event -> this.cancelAction());
        pane.add(btnCancel, 0, 6);

        Button btnSaveCreate = new Button((this.udflugter != null) ? "Gem" : "Opret");
        btnSaveCreate.setOnAction(event -> this.CreateAction());
        pane.add(btnSaveCreate, 1, 6);
//------------------------------------------------------------

        if (this.udflugter != null){
            this.initControls();
        }

        }
//--------------------------------------------------------------
    private void initControls() {

        this.txfNavn.setText(this.udflugter.getNavn());
        this.txfDestination.setText(this.udflugter.getDestination());
        this.dtpDato.setValue(this.udflugter.getDato());
        this.txfPris.setText(this.udflugter.getPris() + "");
        this.chbFrokost.setSelected(this.udflugter.frokost);

    }
//--------------------------------------------------------------
    private void cancelAction() {this.hide();}

    private void CreateAction() {

        String navn = this.txfNavn.getText().trim();
        String destination = this.txfDestination.getText().trim();
        LocalDate dato = this.dtpDato.getValue();
        int pris = Integer.parseInt(txfPris.getText());
        boolean frokost = this.chbFrokost.isSelected();

        String strPris = this.txfPris.getText().trim();

        if (!strPris.isEmpty()){
            pris = Integer.parseInt(this.txfPris.getText().trim());
        }else {
            this.lblFejl.setText("Pris er ikke angivet");
            return;
        }

        if (this.udflugter != null){
            this.udflugter.setNavn(navn);
            this.udflugter.setDestination(destination);
            this.udflugter.setDato(dato);
            this.udflugter.setPris(pris);
            this.udflugter.setFrokost(frokost);
        }else {

            Konference konference = null;
            this.udflugter = Controller.createUdflugt(navn, destination,dato, pris,frokost, konference);
        }

        this.hide();

    }
//----------------------------------------------------------

    public Udflugt getUdflugter() {return this.udflugter;}
}




