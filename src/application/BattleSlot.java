package application;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class BattleSlot{
    private Avenger avenger=null;
    private BattleUIHolder slotUI=null;
    private ImageView animationViewer=null;
    public Avenger getCurAvenger(){
        return avenger;
    }
    
    public void setAvenger(Avenger a){
        avenger = a;
        if(slotUI != null){
            slotUI.load(avenger);
        }else{
            System.out.println("slot ui is null for" + avenger.name);
        }
    }
    public void setSlotUI(BattleUIHolder slotUI){
        System.out.println("slot ui set");
        this.slotUI = slotUI;
    }

    public ImageView getAnimationViewer() {
        return animationViewer;
    }

    public void setAnimationViewer(ImageView animationViewer) {
        this.animationViewer = animationViewer;
    }

    public  boolean isEmpty(){
        return avenger == null;
    }

    public double[] takeHit(Ability ability){
        double[] damageTaken = avenger.takeHit(ability);
        slotUI.setHealth(avenger.getCurrentHealth(),AvengerInterface.MAX_HEALTH);
        return damageTaken;
    }
    
    public double[] getHitDamage(Ability ability) {
    	double[] damageTaken = avenger.getHitDamage(ability);
    	return damageTaken;
    }

    public BattleSlot(Avenger avenger) {
        setAvenger(avenger);
    }

    public BattleSlot(BattleUIHolder slotUI, ImageView animationViewer) {
        this.slotUI = slotUI;
        this.animationViewer = animationViewer;
    }

}
