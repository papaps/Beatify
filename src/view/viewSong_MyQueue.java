package view;

import com.jfoenix.controls.JFXListView;
import controller.controllerDashboard;
import controller.controllerSong_MyQueue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import view_builders.Director;
import view_builders.builderSong;
import view_builders.builderSong_MyQueue;

import java.awt.*;
import java.io.IOException;

public class viewSong_MyQueue extends View{

    public controllerSong_MyQueue controller;

    @FXML AnchorPane mainPane;
    @FXML JFXListView contentListView;

    public viewSong_MyQueue(AnchorPane mainPane, controllerSong_MyQueue controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/fxml/templateSong.fxml"));
        loader.setController(this);
        contentListView = new JFXListView();
        try {
            mainPane.getChildren().setAll((AnchorPane) loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.model.getPlayerModel().Attach(this);
        initHeader();
        Update();
    }

    @Override
    public void Update(){


        contentListView.getItems().clear();


        builderSong builder = new builderSong_MyQueue(controller);
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();

        for (Object object : builder.getProduct()) {
            AnchorPane anchorPane = (AnchorPane) object;
            contentListView.getItems().add(anchorPane);
        }

    }

    public void initHeader(){
        mainPane.getStylesheets().add("view/theme.css");

        Label headerLbl = new Label("Queue List");

        headerLbl.setFont(Font.font("Comfortaa", 22));

        mainPane.setLeftAnchor(headerLbl, 250.0);
        mainPane.setTopAnchor(headerLbl, 40.0);

        mainPane.getChildren().add(headerLbl);
    }
}
