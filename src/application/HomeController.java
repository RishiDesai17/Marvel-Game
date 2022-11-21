package application;

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
import javafx.util.Duration;

public class HomeController extends SceneController implements Initializable {
	
	@FXML
	private ImageView spiderman;
	
	@FXML
	private ImageView spiderWeb;
	
	@FXML
	private Button startGameButton;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		TranslateTransition spiderManEntry = this.spiderManEntry();
		ScaleTransition spiderWebExpand = this.spiderWebExpand();
		FadeTransition spiderWebFadeOut = this.fadeOutSpiderWeb();
		FadeTransition startGameButtonFadeIn = this.fadeInButton();
		
		SequentialTransition seqT = new SequentialTransition(spiderManEntry, spiderWebExpand, spiderWebFadeOut, startGameButtonFadeIn);
		seqT.play();
	}
	
	public TranslateTransition spiderManEntry() {
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(spiderman);
		translate.setDuration(Duration.millis(2000));
		translate.setByY(655);
		return translate;
		
	}
	
	public ScaleTransition spiderWebExpand() {
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(spiderWeb);
		scale.setDuration(Duration.millis(1500));
		scale.setByX(1800);
		scale.setByY(1800);
		return scale;
	}
	
	public FadeTransition fadeOutSpiderWeb() {
		FadeTransition fade = new FadeTransition();
		fade.setNode(spiderWeb);
		fade.setDuration(Duration.millis(800));
		fade.setFromValue(1);
		fade.setToValue(0);
		return fade;
	}
	
	public FadeTransition fadeInButton() {
		FadeTransition fade = new FadeTransition();
		fade.setNode(startGameButton);
		fade.setDuration(Duration.millis(1500));
		fade.setFromValue(0);
		fade.setToValue(1);
		return fade;
	}
	
}
