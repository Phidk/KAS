package gui;

import javafx.application.Application;
import controller.Controller;
import model.*;

import static controller.Controller.initStorage;

public class App {
    public static void main(String[] args){
        initStorage();
        Application.launch(gui.App.class);
    }
    public static void initStorage(){

    }
}
