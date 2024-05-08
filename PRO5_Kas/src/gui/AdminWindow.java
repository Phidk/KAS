package gui;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AdminWindow extends Stage {

    AdminWindow () {
        this.setResizable(false);
        this.setTitle("Admin - KAS");

        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // --------------------------------------------------------------

    private void initContent (BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane (TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabParticipants = new Tab("Deltagere");
        tabPane.getTabs().add(tabParticipants);


    }

public class AdminWindow extends Stage {


}
}


