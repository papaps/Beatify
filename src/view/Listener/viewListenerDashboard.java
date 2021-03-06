package view.Listener;

import controller.*;
import controller.Artist.controllerNotifs_ArtistNotifications;
import controller.Listener.*;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import view.viewDashboard;

public class viewListenerDashboard extends viewDashboard {

	public viewListenerDashboard (Stage primaryStage, controllerDashboard controller) {
		super(primaryStage, controller);
		sm.setWindowName("Beatify");

		currentPaneController = new controllerSong_ListenerAllSongs(centerCurrentAnchor, controller);
		controller.setCurrentPane(currentPaneController);
	}

	public void changePane(ActionEvent actionEvent) {

		if (actionEvent.getSource() == searchBtn) {
			currentPaneController = new controllerSearchables_ListenerAllSearchResults(centerCurrentAnchor, controller);
		}
		else if (actionEvent.getSource() == songsBtn) {
			currentPaneController = new controllerSong_ListenerAllSongs(centerCurrentAnchor, controller);
		}
		else if (actionEvent.getSource() == artistBtn) {
			currentPaneController = new controllerArtists_ListenerFollowedArtists(centerCurrentAnchor, controller);
		}
		else if (actionEvent.getSource() == listenersBtn) {
			currentPaneController = new controllerListener_ListenerFollowedListeners(centerCurrentAnchor,controller);
		}
		else if (actionEvent.getSource() == albumsBtn) {
			currentPaneController = new controllerAlbum_ListenerFollowedAlbums(centerCurrentAnchor, controller);
		}
		else if (actionEvent.getSource() == playlistsBtn) {
			currentPaneController = new controllerPlaylist_ListenerAllPlaylists(centerCurrentAnchor, controller);
		}
		else if (actionEvent.getSource() == profileBtn) {
			currentPaneController = new controllerUser_ListenerMyProfile(centerCurrentAnchor, controller, primaryStage);
		}
		else if (actionEvent.getSource() == queueBtn) {
			currentPaneController = new controllerSong_MyQueue(centerCurrentAnchor, controller);
		}
		else if (actionEvent.getSource() == notificationsBtn){
			currentPaneController = new controllerNotifs_ListenerNotifications(centerCurrentAnchor, controller);
			unshowNotifCue();
		}

		controller.setCurrentPane(currentPaneController);
	}

	@Override
	public void Update() {

	}
}
