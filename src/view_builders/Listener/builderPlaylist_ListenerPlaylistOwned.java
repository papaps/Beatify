package view_builders.Listener;

import com.jfoenix.controls.JFXPopup;
import controller.Listener.controllerPlaylist_ListenerAllPlaylists;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import view_builders.builderPlaylist;

import java.util.ArrayList;
import java.util.List;

public class builderPlaylist_ListenerPlaylistOwned extends builderPlaylist<AnchorPane> {

    private controllerPlaylist_ListenerAllPlaylists controller;

    public builderPlaylist_ListenerPlaylistOwned(controllerPlaylist_ListenerAllPlaylists controller) {
        this.controller = controller;
        this.listElements = controller.getModel().getLibraryModel().getFollowedPlaylists();
        this.listProducts = new ArrayList<>();
    }

    @Override
    public void build() {
        while(listElements.hasNext()) {
            JFXPopup popup = new JFXPopup();
            VBox content = new VBox();
            content.setPrefWidth(65);
            Button deleteButton = new Button("Delete");
            Button editButton = new Button("Edit");
            deleteButton.setMinWidth(content.getPrefWidth());
            editButton.setMinWidth(content.getPrefWidth());
            content.getChildren().addAll(deleteButton, editButton);
            popup.setPopupContent(content);

            deleteButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                }
            });

            editButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                }
            });
        }
    }

    @Override
    public List<AnchorPane> getProduct() {
        return listProducts;
    }
}