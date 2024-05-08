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

public class HotelPane extends GridPane {
   private Hotel hotel;
   private Tillæg tillæg;

private ListView<Hotel> lvwHotels;
private ListView<Tillæg> lvwTillæg;
private TextField txfSinglePris, txfDoublePris, txfNavn;
private TextField txfAdresse;
private TextField txfLand;
private TextArea txaKonferencer, txaHotelVærelser;
private Button  btnSletHotel, btnRedigerHotel,btnSletTillæg, btnRedigerTillæg;

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

    this.txfLand = new TextField();
}
private void selectedHotelChanged(){
    
}





}
