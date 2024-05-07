package gui;

import javafx.application.Application;
import controller.Controller;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.stage.Stage;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class App{
    public static void main(String[] args){
        Application.launch(StartWindow.class);
    }
    public static void addClass (Node node, String strClass) {
        ObservableList<String> styleClass = node.getStyleClass();
        if (!styleClass.contains(strClass)) {
            styleClass.add(strClass);
        }
    }

    public static void removeClass (Node node, String strClass) {
        ObservableList<String> styleClass = node.getStyleClass();
        styleClass.remove(strClass);
    }
}
