package application;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class HomeController extends SceneController implements Initializable {
	
	private MediaPlayer mediaPlayer;
	
	@FXML
	private ImageView spiderman;
	
	@FXML
	private ImageView spiderWeb;
	
	@FXML
	private ImageView ironMan;
	
	@FXML
	private Circle ironManLight;
	
	@FXML
	private ImageView blackWidow;
	
	@FXML
	private Button startGameButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// Setup home screen music
		Media media = null;
		try {
			media = new Media(new File("src/application/media/avengers-theme-song-download.mp3").toURI().toURL().toString());
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setOnEndOfMedia(new Runnable() {
		       public void run() {
		         mediaPlayer.seek(Duration.ZERO);
		       }
		   });
		mediaPlayer.play();
		
		// on click of start game btn, stop home screen music
		startGameButton.setOnAction(e -> {
			mediaPlayer.stop();
			try {
				switchToGameScreen(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		spiderWeb.setDisable(true); // prevent web from obscuring start btn
		ironManLight.setDisable(true); // prevent light circle from obscuring start btn
		startGameButton.setDisable(true);
		TranslateTransition spiderManEntry = this.spiderManEntry();
		ScaleTransition spiderWebExpand = this.spiderWebExpand();
		FadeTransition spiderWebFadeOut = this.fadeOutSpiderWeb();
		TranslateTransition ironManEntry = this.ironManEntry();
		ScaleTransition ironManLightExpand = this.ironManLightExpand();
		FadeTransition ironManLightFadeOut = this.fadeOutIronManLight();
		TranslateTransition blackWidowEntry = this.blackWidowEntry();
		FadeTransition startGameButtonFadeIn = this.fadeInButton();
		
		SequentialTransition seqT = new SequentialTransition(spiderManEntry, spiderWebExpand, spiderWebFadeOut, ironManEntry, ironManLightExpand, ironManLightFadeOut, blackWidowEntry, startGameButtonFadeIn);
		seqT.play();
		seqT.setOnFinished(e -> startGameButton.setDisable(false));
	}
	
	private TranslateTransition spiderManEntry() {
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(spiderman);
		translate.setDuration(Duration.millis(2000));
		translate.setByY(655);
		return translate;
		
	}
	
	private TranslateTransition ironManEntry() {
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(ironMan);
		translate.setDuration(Duration.millis(1700));
		translate.setByY(450);
		return translate;
	}
	
	private TranslateTransition blackWidowEntry() {
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(blackWidow);
		translate.setDuration(Duration.millis(1200));
		translate.setByX(334);
		return translate;
	}
	
	private ScaleTransition spiderWebExpand() {
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(spiderWeb);
		scale.setDuration(Duration.millis(1500));
		scale.setByX(1800);
		scale.setByY(1800);
		return scale;
	}
	
	private ScaleTransition ironManLightExpand() {
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(ironManLight);
		scale.setDuration(Duration.millis(1200));
		scale.setByX(9000);
		scale.setByY(9000);
		return scale;
	}
	
	private FadeTransition fadeOutSpiderWeb() {
		FadeTransition fade = new FadeTransition();
		fade.setNode(spiderWeb);
		fade.setDuration(Duration.millis(700));
		fade.setFromValue(1);
		fade.setToValue(0);
		return fade;
	}
	
	private FadeTransition fadeOutIronManLight() {
		FadeTransition fade = new FadeTransition();
		fade.setNode(ironManLight);
		fade.setDuration(Duration.millis(800));
		fade.setFromValue(0.75);
		fade.setToValue(0);
		return fade;
	}
	
	private FadeTransition fadeInButton() {
		FadeTransition fade = new FadeTransition();
		fade.setNode(startGameButton);
		fade.setDuration(Duration.millis(1500));
		fade.setFromValue(0);
		fade.setToValue(1);
		return fade;
	}
	
}
