package view.Artist;

import com.jfoenix.controls.JFXListView;
import controller.Artist.controllerSong_ArtistShowArtistPlaylistSongs;
import controller.controllerDashboard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import object.Playlist;
import view.View;
import view_builders.Director;
import view_builders.builderSong;
import view_builders.builderSong_ArtistShowArtistPlaylistSongs;

import java.io.IOException;

public class viewSong_ArtistShowArtistPlaylistSongs extends View {

    //Songs inside the Playlist of a different Artist
    @FXML AnchorPane songsHeader;
    @FXML JFXListView songListView;
    private Label headerLabel;
    private Label subheaderLabel;
    private controllerSong_ArtistShowArtistPlaylistSongs controller;
    private Playlist selectedPlaylist;

    public viewSong_ArtistShowArtistPlaylistSongs (AnchorPane mainPane, controllerSong_ArtistShowArtistPlaylistSongs controller, controllerDashboard dashboardController){
        this.controller = controller;
        this.model = dashboardController.getModel();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/fxml/templateSearchable.fxml"));
        loader.setController(this);

        try {
            mainPane.getChildren().setAll((AnchorPane) loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        selectedPlaylist = model.getPeopleModel().getSelectedPlaylist();
        initHeader();
        Update();
    }

    @Override
    public void Update(){
        setSongs();
    }

    private void initHeader () {
        //INITIALIZES THE HEADER//
        String PLAYLISTNAME = selectedPlaylist.getName();
        String USERNAME = "Playlist by Artist "+ selectedPlaylist.getUser_id();
        headerLabel = new Label(PLAYLISTNAME);
        subheaderLabel = new Label(USERNAME);
        headerLabel.setFont(Font.font("Comfortaa", 18));
        subheaderLabel.setFont(Font.font("Comfortaa",12));
        songsHeader.setLeftAnchor(headerLabel, 285.0);
        songsHeader.setTopAnchor(headerLabel, 50.0);
        songsHeader.setLeftAnchor(subheaderLabel, 285.0);
        songsHeader.setTopAnchor(subheaderLabel, 70.0);
        songsHeader.getChildren().add(headerLabel);
        songsHeader.getChildren().add(subheaderLabel);
    }
    //BUILDER//
    private void setSongs () {
        songListView.getItems().clear();
        //SETS SONGS//
        builderSong builder = new builderSong_ArtistShowArtistPlaylistSongs(controller);
        Director director = Director.getInstance();
        director.setBuilder(builder);
        director.construct();

        for (Object object: builder.getProduct()){
            AnchorPane anchorPane = (AnchorPane) object;
            songListView.getItems().add(anchorPane);
        }
    }


}
