package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Konference;

public class StartWindow extends Application {
    public void init(){
        Controller.init();
    }

    public void start(Stage stage){
stage.setTitle("Konference Administrationssystem");
BorderPane pane = new BorderPane();
this.initContent(pane);

Scene scene = new Scene(pane, 800,500);
stage.setScene(scene);
stage.show();
    }
    //------------------------------------------
    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);

    // Tilføj Administration og Deltager knapper
    Button adminButton = new Button("Administration");
    Button participantButton = new Button("Ny deltager");

        participantButton.setOnAction(e -> {
            DeltagerRegistrationPane deltagerRegistrationPane = new DeltagerRegistrationPane();
            Scene deltagerScene = new Scene(deltagerRegistrationPane, 600, 400);
            Stage deltagerStage = new Stage();
            deltagerStage.setScene(deltagerScene);
            deltagerStage.setTitle("Deltager Registration");
            deltagerStage.show();
        });

    // Layout for knapper
        HBox buttonBox = new HBox(10); // Afstand mellem knapper
        buttonBox.setAlignment(Pos.CENTER); // Centrer indholdet
        buttonBox.setPadding(new Insets(10)); // Indstillinger for afstand fra kanten af panelet
        buttonBox.getChildren().addAll(adminButton, participantButton);

        pane.setCenter(buttonBox); // Tilføj HBox til midten af BorderPane
        pane.setBottom(tabPane); // Flyt TabPane til bunden af BorderPane
    }
private void initTabPane(TabPane tabPane) {
    tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
    // Tilføj eventuelle faneblade eller yderligere opsætning af tabPane
}



}
