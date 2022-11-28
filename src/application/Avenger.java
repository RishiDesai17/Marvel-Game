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
	
	public double[] takeHit(Ability ability) {
		double[] damageTaken = calculateEffectiveDamage(ability);
		currentHealth -= (damageTaken[0] + damageTaken[1]);
		return damageTaken;
	}
	
	public double[] getHitDamage(Ability ability) {
		double[] damageTaken = calculateEffectiveDamage(ability);
		return damageTaken;
	}
	
	private double[] calculateEffectiveDamage(Ability ability) {
		switch(ability.getName()) {
			/* Spiderman */
			// Ability : web
			case "Spider Web":
				//strong against
				if(name.equals("IronMan")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				//weak against
				if(name.equals("Hulk") || name.equals("Thor")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
			
			// Ability : Leaping Kick
			case "Leaping Kick":
				// strong against
				if(name.equals("Black Widow")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// weak against
				if(name.equals("Hulk") || name.equals("Captain America")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
			
			/* Hulk */
			// Ability : Hulk Smash
			case "Hulk Smash":
				// strong against
				if(name.equals("Captain America")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// weak against
				if(name.equals("Spiderman") || name.equals("Black Widow")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
			
			// Ability : Rage
			case "Rage":
				// no damage interaction; return
				return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
			
			/* Black Widow */
			// Ability : Widows Bite
			case "Widows Bite":
				// strong against
				if(name.equals("Thor")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// no weak against
				break;
			
			// Ability : Stun Baton
			case "Stun Baton":
				// strong against
				if(name.equals("Spiderman")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// weak against
				if(name.equals("Hulk") || name.equals("Thor") || name.equals("Ironman")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
			
			/* Thor */
			// Ability : Thunder Storm
			case "Thunder Storm":
				// strong against
				if(name.equals("Ironman") || name.equals("Hulk")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// weak against
				if(name.equals("Captain America")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
			
			// Ability : Hammer Throw
			case "Hammer Throw":
				// strong against
				if(name.equals("Black Widow")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// weak against
				if(name.equals("Spiderman") || name.equals("Black Widow")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
			
			/* Ironman */
			// Ability : Light Blast
			case "Light Blast":
				// strong against
				if(name.equals("Captain America") || name.equals("Hulk")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// no weak against
				break;
			
			// Ability : Artilery Barrage
			case "Artilery Barrage":
				// strong against
				if(name.equals("Spiderman")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// weak against
				if(name.equals("Captain America") || name.equals("Hulk")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
			
			/* Captain America */
			// Ability : ShieldBash
			case "ShieldBash":
				// strong against
				if(name.equals("Spiderman")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// weak against
				if(name.equals("Hulk")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
			
			// Ability : Shield Throw
			case "ShieldThrow":
				// strong against
				if(name.equals("Thor")) {
					return new double[] {ability.getBaseDamage(),ability.getBaseDamage()*0.5};
				}
				// weak against
				if(name.equals("Spiderman") || name.equals("Black Widow")) {
					return new double[] {ability.getBaseDamage(),-ability.getBaseDamage()*0.5};
				}
				break;
		}
		return new double[] {ability.getBaseDamage(), 0};
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
