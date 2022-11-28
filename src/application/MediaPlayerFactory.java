package application;

import java.io.File;
import java.net.MalformedURLException;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class MediaPlayerFactory {
	public static MediaPlayer getMediaPlayerFor(String abilityName) {
		switch(abilityName) {
		case "Spider Web":
			return getSpiderWebPlayer();
			
		case "Leaping Kick":
			return getLeapingKickPlayer();
			
		case "Rage":
			return getRagePlayer();
		
		case "Hulk Smash":
			return getHulkSmashPlayer();
		
		case "Widows Bite":
			return getWidowsBitePlayer();
		
		case "Stun Baton":
			return getStunBatonPlayer();
			
		case "Hammer Throw":
			return getHammerThrowPlayer();
			
		case "Thunder Storm":
			return getThunderStormPlayer();
			
		case "Light Blast":
			return getLightBlastPlayer();
			
		case "Artilery Barrage":
			return getArtileryBarragePlayer();
			
		case "ShieldBash":
			return getShieldBashPlayer();
			
		case "ShieldThrow":
			return getShieldThrowPlayer();	
		
		default:
			return null;
		}
	}
	private static MediaPlayer createMediaPlayer(String mediaPath) {
		Media media = null;
		try {
			media = new Media(new File(mediaPath).toURI().toURL().toString());
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		return new MediaPlayer(media); 
	}
	
	private static MediaPlayer getHulkSmashPlayer() {
		String path = "src/application/media/Hulk smash!.mp3";
		MediaPlayer player = createMediaPlayer(path);
		player.setStartTime(Duration.seconds(2));
		player.setStopTime(Duration.seconds(4));
		return player;
	}
	private static MediaPlayer getRagePlayer() {
		String path = "src/application/media/Hulk rage.mp3";
		MediaPlayer player = createMediaPlayer(path);
		player.setStartTime(Duration.seconds(0));
		player.setStopTime(Duration.seconds(2));
		return player;
	}
	private static MediaPlayer getSpiderWebPlayer() {
		String path = "src/application/media/spider-web.mp3";
		return createMediaPlayer(path);
	}
	private static MediaPlayer getLeapingKickPlayer() {
		String path = "src/application/media/leaping-kick.mp3";
		return createMediaPlayer(path);
	}
	private static MediaPlayer getWidowsBitePlayer() {
		String path = "src/application/media/Black Widow_ Electric Taser Supercut.mp3";
		MediaPlayer player = createMediaPlayer(path);
		player.setStartTime(Duration.seconds(93));
		player.setStopTime(Duration.seconds(96));
		return player;
	}
	private static MediaPlayer getStunBatonPlayer() {
		String path = "src/application/media/Black Widow_ Electric Taser Supercut.mp3";
		MediaPlayer player = createMediaPlayer(path);
		player.setStartTime(Duration.seconds(26));
		player.setStopTime(Duration.seconds(29));
		return player;
	}
	private static MediaPlayer getLightBlastPlayer() {
		String path = "src/application/media/light-blast.mp3";
		MediaPlayer player = createMediaPlayer(path);
		player.setStartTime(Duration.seconds(0));
		player.setStopTime(Duration.seconds(2));
		return player;
	}
	private static MediaPlayer getArtileryBarragePlayer() {
		String path = "src/application/media/artilery-barrage.mp3";
		return createMediaPlayer(path);
	}
	private static MediaPlayer getThunderStormPlayer() {
		String path = "src/application/media/thunder-sound-effect.mp3";
		MediaPlayer player = createMediaPlayer(path);
		player.setStartTime(Duration.seconds(0));
		player.setStopTime(Duration.seconds(2));
		return player;
	}
	private static MediaPlayer getHammerThrowPlayer() {
		String path = "src/application/media/hammer_1.mp3";
		MediaPlayer player = createMediaPlayer(path);
		player.setStartTime(Duration.seconds(0));
		player.setStopTime(Duration.seconds(2));
		return player;
	}
	private static MediaPlayer getShieldThrowPlayer() {
		String path = "src/application/media/shield-throw.mp3";
		return createMediaPlayer(path);
	}
	private static MediaPlayer getShieldBashPlayer() {
		String path = "src/application/media/shield-bash.mp3";
		return createMediaPlayer(path);
	}
}
