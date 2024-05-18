package gui;

 import model.*;
 import controller.*;
 import javafx.beans.value.ChangeListener;
 import javafx.geometry.HPos;
 import javafx.geometry.Insets;
 import javafx.scene.control.*;
 import javafx.scene.layout.GridPane;
 import javafx.scene.layout.HBox;
import java.util.ArrayList;
 import javafx.stage.Stage;

public class HotelPane extends GridPane {
   private Hotel hotel;
   private Tillæg tillæg;

private ListView<Hotel> lvwHotels;
private ListView<Tillæg> lvwTillæg;
private TextField txfSinglePris, txfDoublePris, txfNavn;
private TextField txfAdresse;
private TextField txfLand;
private TextArea txaKonferencer, txaHotelVærelser;
private Button  btnSletHotel, btnRedigerHotel,btnSletTillæg, btnRedigerTillæg, btnCreateTillæg, btnCreateHotel;

HotelPane(){
    this.setPadding(new Insets(10));
    this.setHgap(10);
    this.setVgap(10);
    this.setGridLinesVisible(false);
    //-----------------------------

    this.lvwHotels = new ListView<>();
    this.lvwHotels.setPrefSize(250,400);
    this.add(this.lvwHotels,0,0,1,5);

    ChangeListener<Hotel> listener = (ov, oldValue, newValue) -> this.selectedHotelChanged(newValue);
    this.lvwHotels.getSelectionModel().selectedItemProperty().addListener(listener);

    //--------------------------------
    Label lblNavn = new Label("Navn");
    this.add(lblNavn,1,0);

    Label lblAdresse = new Label("Adresse");
    this.add(lblAdresse,1,1);

    Label lblSinglePris = new Label("Enkeltværelsespris:");
    this.add(lblSinglePris,1,2);

    Label lblDoublePris = new Label("Doubleværelsespris:");
    this.add(lblDoublePris,1,3);

    Label lblTillæg = new Label("Tillæg");

    this.txfNavn = new TextField();
    this.txfNavn.setEditable(false);
    this.add(this.txfNavn,2,0);

    this.txfAdresse = new TextField();
    this.txfAdresse.setEditable(false);
    this.add(this.txfAdresse,2,1);

    this.txfSinglePris = new TextField();
    this.txfSinglePris.setEditable(false);
    this.add(txfSinglePris,2,2);

    this.txfDoublePris = new TextField();
    this.txfDoublePris.setEditable(false);
    this.add(this.txfDoublePris,2,3);

    this.lvwTillæg = new ListView<>();
    this.lvwTillæg.setPrefSize(200,100);
    this.add(this.lvwTillæg,2,4);

    ChangeListener<Tillæg> listenerTillæg = (ov, oldValue, newValue) -> this.selectedTillægChanged(newValue);
    this.lvwTillæg.getSelectionModel().selectedItemProperty().addListener(listenerTillæg);

    Label lblKonferencer = new Label("Konferencer:");
    this.add(lblKonferencer, 3,0,1,4);

    Label lblHotelVærelser = new Label("Hotelværelser:");
    this.add(lblHotelVærelser, 3,4);

    this.txaKonferencer = new TextArea();
    this.txaKonferencer.setPrefSize(200, 100);
    this.txaKonferencer.setEditable(false);
    this.add(this.txaKonferencer, 4, 0, 1, 4);

    this.txaHotelVærelser = new TextArea();
    this.txaHotelVærelser.setPrefSize(200, 100);
    this.txaHotelVærelser.setEditable(false);
    this.add(this.txaHotelVærelser, 4, 4);

    // --------------------------------------------------------------

    HBox hBoxHotels = new HBox(10);
    this.add(hBoxHotels, 0, 5);

    this.btnSletHotel = new Button("Slet hotel");
    this.btnSletHotel.setOnAction(event -> this.deleteHotelAction());
    hBoxHotels.getChildren().add(this.btnSletHotel);

    this.btnRedigerHotel = new Button("Opdater hotel");
    this.btnRedigerHotel.setOnAction(event -> this.updateHotelAction());
    hBoxHotels.getChildren().add(this.btnRedigerHotel);

    this.btnCreateHotel = new Button("Opret hotel");
    this.btnCreateHotel.setOnAction(event -> this.createHotelAction());
    hBoxHotels.getChildren().add(this.btnCreateHotel);

    HBox hBoxAddOns = new HBox(10);
    this.add(hBoxAddOns, 2, 5);

    this.btnSletTillæg = new Button("Slet tillæg");
    this.btnSletTillæg.setOnAction(event -> this.deleteTillægAction());
    hBoxAddOns.getChildren().add(this.btnSletTillæg);

    this.btnRedigerTillæg = new Button("Opdater tillæg");
    this.btnRedigerTillæg.setOnAction(event -> this.updateTillægAction());
    hBoxAddOns.getChildren().add(this.btnRedigerTillæg);

    this.btnCreateTillæg = new Button("Opret tillæg");
    this.btnCreateTillæg.setOnAction(event -> this.createTillægAction());
    hBoxAddOns.getChildren().add(this.btnCreateTillæg);

    // --------------------------------------------------------------

    this.updateHotels();
    this.updateButtons();

}
    private void selectedHotelChanged (Hotel hotel) {
        this.hotel = hotel;

        this.updateControls();
    }

    private void selectedTillægChanged (Tillæg tillæg) {
        this.tillæg = tillæg;

        this.updateButtons();
    }

    // --------------------------------------------------------------

    private void updateControls () {
        this.clearControls();

        if (this.hotel != null) {
            this.txfNavn.setText(this.hotel.getNavn());
            this.txfAdresse.setText(this.hotel.getAdresse());
            this.txfSinglePris.setText(this.hotel.getSinglePris() + "");
            this.txfDoublePris.setText(this.hotel.getDoublePris() + "");

            StringBuilder konferencer = new StringBuilder();
            for (Konference konference : this.hotel.getKonferencer()) {
                konferencer.append(konference.getNavn()).append("\n");
            }
            this.txaKonferencer.setText(konferencer.toString());

            this.lvwTillæg.getItems().setAll(this.hotel.getTillæg());

            StringBuilder hotelBookinger = new StringBuilder();
            for (HotelBooking hotelBooking: this.hotel.getHotelBookinger()) {
                hotelBookinger.append(hotelBooking.getNummer()).append(" ").append((true) ? "Enkeltværelse " : "Doubleværelse ");

                ArrayList<String> tillægsNavne = new ArrayList<>();
                for (Tillæg tillæg : hotelBooking.getTillæg()) {
                    tillægsNavne.add(tillæg.getNavn());
                }
                hotelBookinger.append("(").append(String.join(", ", tillægsNavne)).append(")\n");
            }
            this.txaHotelVærelser.setText(hotelBookinger.toString());
        }

        this.updateButtons();
    }

    private void updateButtons () {
        boolean hotel = this.hotel == null;
        boolean addOn = this.tillæg == null;

        this.btnSletHotel.setDisable(hotel);
        this.btnRedigerHotel.setDisable(hotel);
        this.btnCreateTillæg.setDisable(hotel);
        this.btnCreateHotel.setDisable(hotel);

        this.btnRedigerTillæg.setDisable(addOn);
        this.btnSletTillæg.setDisable(addOn);
    }

    private void clearControls () {
        this.txfNavn.clear();
        this.txfAdresse.clear();
        this.txfSinglePris.clear();
        this.txfDoublePris.clear();
        this.txaKonferencer.clear();
        this.lvwTillæg.getItems().clear();
        this.txaHotelVærelser.clear();

        this.tillæg = null;

        this.updateButtons();
    }

    private void updateHotels () {
        this.lvwHotels.getItems().setAll(Controller.getHoteller());
    }

    // --------------------------------------------------------------

    private void createHotelAction () {
        CreateHotelWindow createHotelWindow = new CreateHotelWindow();
        createHotelWindow.showAndWait();

        this.hotel = createHotelWindow.getHotel();
        this.updateControls();
        this.updateHotels();

    }

    private void updateHotelAction () {
        CreateHotelWindow adminCreateHotelWindow = new CreateHotelWindow(this.lvwHotels.getSelectionModel().getSelectedItem());
        adminCreateHotelWindow.showAndWait();

        this.updateControls();
        this.updateHotels();
    }

    private void deleteHotelAction () {
        Controller.removeHotel(this.hotel);

        this.hotel = null;
        this.clearControls();
        this.updateHotels();
    }

//    // --------------------------------------------------------------

    private void createTillægAction () {
        CreateTillægWindow createTillægWindow = new CreateTillægWindow(this.hotel);
        createTillægWindow.showAndWait();

        this.tillæg = createTillægWindow.getTillæg();
        this.updateControls();
    }
//
    private void updateTillægAction () {
        CreateTillægWindow createAddOnWindow = new CreateTillægWindow(this.hotel, this.tillæg);
        createAddOnWindow.showAndWait();

        this.updateControls();
    }
//
    private void deleteTillægAction () {
        this.hotel.removeTillæg(this.tillæg);

        this.tillæg = null;
        this.updateControls();
    }

}

