package gui;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Hotel;

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

        Tab tabDeltagere = new Tab("Deltagere");
        tabPane.getTabs().add(tabDeltagere);

        DeltagerPane deltagerPane = new DeltagerPane();
        tabDeltagere.setContent(deltagerPane);

        Tab tabHotel = new Tab("Hoteller");
        tabPane.getTabs().add(tabHotel);

        HotelPane hotelPane = new HotelPane();
        tabHotel.setContent(hotelPane);

        Tab tabKonferencer = new Tab("Konferencer");
        tabPane.getTabs().add(tabKonferencer);

        KonferencePane konferencePane = new KonferencePane();
        tabKonferencer.setContent(konferencePane);
    }

}


