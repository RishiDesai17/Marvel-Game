package application;

import java.util.ArrayList;


public class Avenger implements AvengerInterface{
	
	String name;
	private double currentHealth = AvengerInterface.MAX_HEALTH ;
	Type movementMode;
	ArrayList<Ability> abilityList;
	public final String frontImage;
    public final String actionImage;
    
	public Avenger(String name, Type movementMode, ArrayList<Ability> abilityList, String frontImage, String actionImage) {
		this.name = name;
		this.movementMode = movementMode;
		this.abilityList = abilityList;
		this.frontImage = frontImage;
		this.actionImage = actionImage;
	}
	
	public double getCurrentHealth() {
		return this.currentHealth;
	}
	
	@Override
	public void executeAbilityAnimation(boolean isPlayer1, int abilityNumber) {
		Ability selectedAbility = abilityList.get(abilityNumber);
		if(isPlayer1) {
			System.out.println("Player 1 animation goes off for ability : " + abilityList.get(abilityNumber).getName() + " from player 1 to player 2");
		}else {
			System.out.println("Player  animation goes off for ability : " + abilityList.get(abilityNumber).getName() + " from player 2 to player 1");
		}
	}
	
	@Override
	public ArrayList<Ability> getAbilities() {
		// TODO Auto-generated method stub
		return abilityList;
	}
	
	public void takeHit(Ability ability) {
		currentHealth -= ability.getBaseDamage();
		
	}
	
	public boolean isDead(){
        return currentHealth <=0;
    }
	
	 public Ability getAbility(int abilityNumber){
	        if(abilityNumber > abilityList.size() || abilityNumber <1)
	            abilityNumber = 1;
	        return  abilityList.get(abilityNumber-1);
	    }
	 
	public double getHealthRatio(){return  ((double)(currentHealth)) / AvengerInterface.MAX_HEALTH ;}
	
}
