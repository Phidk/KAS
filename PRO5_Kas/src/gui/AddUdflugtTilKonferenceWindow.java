package gui;
import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Konference;
import model.Udflugt;

import java.util.ArrayList;
public class AddUdflugtTilKonferenceWindow extends Stage{

    private Konference konference;
    private ListView<Udflugt> lvwUdflugter;

    AddUdflugtTilKonferenceWindow(Konference konference){
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setTitle("Tilføj udflugt - KAS");

        this.konference = konference;

        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private void initContent (GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        // -------------------------------------------------------------------------

        this.lvwUdflugter = new ListView<>();
        this.lvwUdflugter.setPrefSize(300, 500);
        this.lvwUdflugter.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        pane.add(this.lvwUdflugter, 0, 0, 2, 1);

        // -------------------------------------------------------------------------

        Button btnCancel = new Button("Afslut");
        btnCancel.setOnAction(event -> this.cancelAction());
        pane.add(btnCancel, 0, 1);

        Button btnAdd = new Button("Tilføj");
        btnAdd.setOnAction(event -> this.addAction());
        pane.add(btnAdd, 1, 1);

        // -------------------------------------------------------------------------

        this.initControls();
    }

    // -------------------------------------------------------------------------

    private void initControls () {
        ArrayList<Udflugt> udflugter = Controller.getUdflugter();
        udflugter.removeAll(this.konference.getUdflugter());
        this.lvwUdflugter.getItems().setAll(udflugter);
    }

    // -------------------------------------------------------------------------

    private void cancelAction () {
        this.hide();
    }

    private void addAction () {
        for (Udflugt udflugt : this.lvwUdflugter.getSelectionModel().getSelectedItems()) {
            Controller.addUdflugtToKonfernece(this.konference, udflugt);
            //this.konference.addUdflugt(udflugt);
        }

        this.hide();
    }

}
