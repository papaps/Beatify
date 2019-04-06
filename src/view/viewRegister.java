package view;

import FileUploaderService.FileUploader;
import FileUploaderService.PhotoUploader;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import controller.Controller;
import controller.controllerLogin;
import controller.controllerRegister;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.File;

public class viewRegister extends View{

    private controllerRegister controller;

    public Circle imageCircle;
    public JFXButton uploadBtn;
    public JFXTextField firstNameField;
    public JFXTextField lastnameField;
    public JFXTextField usernameField;
    public JFXPasswordField passwordField;
    public JFXButton doneBtn;
    public JFXPasswordField confirmPassField;
    public JFXRadioButton listenerToggle;
    public JFXRadioButton artistToggle;
    public JFXButton backBtn;

    public viewRegister(Stage primaryStage, controllerRegister controller) {
        this.primaryStage = primaryStage;
        this.controller = controller;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/fxml/templateRegister.fxml"));
        loader.setController(this);

        sm = new StageManager(primaryStage);
        sm.loadScene(loader);
        sm.setWindowName("Register");
    }

    @Override
    public void Update() {

    }

    public void uploadPhoto(ActionEvent actionEvent) {
        FileUploader uploader = new PhotoUploader(primaryStage);
        File pic = uploader.getUploadedFile();
    }

    public void registerUser(ActionEvent actionEvent) {

    }

    public void changePane(ActionEvent actionEvent) {
        if (actionEvent.getSource() == backBtn) {
            Controller login = new controllerLogin(primaryStage);
        }
    }
}