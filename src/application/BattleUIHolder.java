package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class BattleUIHolder {
    private Label NameLabel;
    private ProgressBar HpBar;
    private Label HpLabel;
    private ImageView imageView;
    private boolean shoudUseFrontImage;
    public BattleUIHolder(Label nameLabel, ProgressBar hpBar, Label hpLabel, ImageView imageView,boolean shoudUseFrontImage) {
        NameLabel = nameLabel;
        HpBar = hpBar;
        HpLabel = hpLabel;
        this.imageView = imageView;
        this.shoudUseFrontImage = shoudUseFrontImage;
    }
    
    public void load(Avenger avenger){
        if(avenger == null)
            System.out.println("avenger null");
        HpBar.setProgress(avenger.getHealthRatio());
        HpLabel.setText(String.format("%.0f",avenger.getCurrentHealth()) + " / " + String.format("%.0f",AvengerInterface.MAX_HEALTH));
        System.out.println ( " ANswer : " + "file:" + avenger.frontImage);
        imageView.setImage( new Image(shoudUseFrontImage?getClass().getResourceAsStream(avenger.frontImage):  getClass().getResourceAsStream(avenger.backImage)));
        NameLabel.setText(avenger.name);
        
    }

    public void setHealth(double curHealth, double maxHealth){
        if(curHealth > 0) {
            HpLabel.setText(String.format("%.0f", curHealth) + " / " + String.format("%0.f", maxHealth));
            HpBar.setProgress(((double) curHealth) / maxHealth);
        }else{
            HpLabel.setText(0 + " / " + maxHealth);
            HpBar.setProgress(((double) 0) / maxHealth);
        }
    }

}

