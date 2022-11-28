package application;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

// need to return sequential transition end product back to gameController
public class AnimationFactory {
	 public static SequentialTransition getSpiderWeb(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/spidey.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		
		Image superpowerObject = new Image("application/images/spider web.png");
		player1SideAnimationView.setImage(superpowerObject);
		 
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(300);
		scale.setByY(270);
		
		FadeTransition fade = new FadeTransition();
		fade.setNode(player1SideAnimationView);
		fade.setDuration(Duration.millis(1500));
		fade.setFromValue(1);
		fade.setToValue(0.5);
		 
	 	return new SequentialTransition(scale, fade);
	 }

	 public static SequentialTransition getLeapingKick(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/spidey-kick.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/kick-effect-spidey.png");
		player1SideAnimationView.setImage(superpowerObject);
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(200);
		scale.setByY(200);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getHulkSmash(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View){
	 	Image imageObject = new Image("application/images/hulk-sideways.png");
	 	if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/hulk-smash.png");
		player1SideAnimationView.setImage(superpowerObject);
		if(!isPlayer1) {
			Rotate flipRotation = new Rotate(180,Rotate.Y_AXIS);
			player1SideAnimationView.getTransforms().add(flipRotation);
			player1SideAnimationView.setTranslateX(200);
		}
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(200);
		scale.setByY(200);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
    }
	 
	 public static SequentialTransition getRage(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/hulk-sideways.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/hulk-rage.png");
		player1SideAnimationView.setImage(superpowerObject);
		if(!isPlayer1) {
			Rotate flipRotation = new Rotate(180,Rotate.Y_AXIS);
			player1SideAnimationView.getTransforms().add(flipRotation);
			player1SideAnimationView.setTranslateX(200);
		}
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(200);
		scale.setByY(200);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getWidowsBite(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/black widow sideways.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/widows-bite.png");
		player1SideAnimationView.setImage(superpowerObject);
		if(!isPlayer1) {
			Rotate flipRotation = new Rotate(180,Rotate.Y_AXIS);
			player1SideAnimationView.getTransforms().add(flipRotation);
			player1SideAnimationView.setTranslateX(200);
		}
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(200);
		scale.setByY(200);
		
		
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	 	
	 	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getStunBaton(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/black widow sideways.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/stun-baton.png");
		player1SideAnimationView.setImage(superpowerObject);
		if(!isPlayer1) {
			Rotate flipRotation = new Rotate(180,Rotate.Y_AXIS);
			player1SideAnimationView.getTransforms().add(flipRotation);
			player1SideAnimationView.setTranslateX(200);
		}
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(200);
		scale.setByY(200);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getHammerThrow(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/thor sideways.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/thor-hammer.png");
		player1SideAnimationView.setImage(superpowerObject);
		if(!isPlayer1) {
			Rotate flipRotation = new Rotate(180,Rotate.Y_AXIS);
			player1SideAnimationView.getTransforms().add(flipRotation);
			player1SideAnimationView.setTranslateX(200);
		}
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(200);
		scale.setByY(200);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getThunderStorm(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/thor sideways.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/thor-thunderstorm.png");
		player1SideAnimationView.setImage(superpowerObject);
		if(!isPlayer1) {
			Rotate flipRotation = new Rotate(180,Rotate.Y_AXIS);
			player1SideAnimationView.getTransforms().add(flipRotation);
			player1SideAnimationView.setTranslateX(200);
		}
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(200);
		scale.setByY(200);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getLightBlast(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/iron-man-sideways.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/white-circle.png");
		player1SideAnimationView.setOpacity(0.7);
		player1SideAnimationView.setImage(superpowerObject);
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(1200));
		scale.setByX(1200);
		scale.setByY(1200);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(0.7);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 public static SequentialTransition getArtileryBarrage(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/iron-man-sideways.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/artilery-barrage.png");
		player1SideAnimationView.setImage(superpowerObject);
		if(!isPlayer1) {
			Rotate flipRotation = new Rotate(180,Rotate.Y_AXIS);
			player1SideAnimationView.getTransforms().add(flipRotation);
			player1SideAnimationView.setTranslateX(200);
		}
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(200);
		scale.setByY(200);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getShieldBash(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/captain-america-sideways.png");
		
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}

		Image superpowerObject = new Image("application/images/shield-bash.png");
		player1SideAnimationView.setImage(superpowerObject);
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(200);
		scale.setByY(200);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getShieldThrow(boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
		Image imageObject = new Image("application/images/captain-america-sideways.png");
		if (isPlayer1) {
			player1View.setImage(imageObject);
		}
		else {
			player2View.setImage(imageObject);
		}
		 
		Image superpowerObject = new Image("application/images/flying-shield.png");
		player1SideAnimationView.setImage(superpowerObject);
		
		if(!isPlayer1) {
			Rotate flipRotation = new Rotate(180,Rotate.Y_AXIS);
			player1SideAnimationView.getTransforms().add(flipRotation);
			player1SideAnimationView.setTranslateX(200);
		}
		
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(player1SideAnimationView);
		scale.setDuration(Duration.millis(800));
		scale.setByX(400);
		scale.setByY(400);
	 	
	 	FadeTransition fadeOut = new FadeTransition();
	 	fadeOut.setNode(player1SideAnimationView);
	 	fadeOut.setDuration(Duration.millis(1500));
	 	fadeOut.setFromValue(1);
	 	fadeOut.setToValue(0);
	
		return new SequentialTransition(scale, fadeOut);
	 }
	 
	 public static SequentialTransition getAnimationFor(String abilityName, boolean isPlayer1, ImageView player1View, ImageView player1SideAnimationView, ImageView player2View) {
	    	switch(abilityName) {
	    		case "Spider Web":
	    			return getSpiderWeb(isPlayer1, player1View, player1SideAnimationView, player2View);
	    			
	    		case "Leaping Kick":
	    			return getLeapingKick(isPlayer1, player1View, player1SideAnimationView, player2View);
	    			
	    		case "Rage":
	    			return getRage(isPlayer1, player1View, player1SideAnimationView, player2View);
	    		
	    		case "Hulk Smash":
	    			return getHulkSmash(isPlayer1, player1View, player1SideAnimationView, player2View);
	    		
	    		case "Widows Bite":
	    			return getWidowsBite(isPlayer1, player1View, player1SideAnimationView, player2View);
	    		
	    		case "Stun Baton":
	    			return getStunBaton(isPlayer1, player1View, player1SideAnimationView, player2View);
	    			
	    		case "Hammer Throw":
	    			return getHammerThrow(isPlayer1, player1View, player1SideAnimationView, player2View);
	    			
	    		case "Thunder Storm":
	    			return getThunderStorm(isPlayer1, player1View, player1SideAnimationView, player2View);
	    			
	    		case "Light Blast":
	    			return getLightBlast(isPlayer1, player1View, player1SideAnimationView, player2View);
	    			
	    		case "Artilery Barrage":
	    			return getArtileryBarrage(isPlayer1, player1View, player1SideAnimationView, player2View);
	    			
	    		case "ShieldBash":
	    			return getShieldBash(isPlayer1, player1View, player1SideAnimationView, player2View);
	    			
	    		case "ShieldThrow":
	    			return getShieldThrow(isPlayer1, player1View, player1SideAnimationView, player2View);	
	    		
	    		default:
	    			return null;
	    	}
	    }
	 
}
