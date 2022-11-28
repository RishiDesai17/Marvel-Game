package application;


public class AbilityFactory {
		// Hulk abilities
	 	public  static  Ability getHulkSmash(){
	        return new Ability("Hulk Smash", Type.PHYSICAL, 20);
	    }
	 	public  static  Ability getRage(){
	        return new Ability("Rage", Type.PHYSICAL, 0);
	    }
	 	
	 	// spiderman abilities
	    public static Ability getSpiderWeb(){
	        return new Ability("Spider Web", Type.GADGETS, 20);
	    }
	    public static Ability getLeapingKick(){
	        return new Ability("Leaping Kick", Type.PHYSICAL, 20);
	    }
	    
	    // black widow abilities
	    public static Ability getWidowsBite(){
	        return new Ability("Widows Bite", Type.GADGETS, 20);
	    }
	    public static Ability getStunBaton(){
	        return new Ability("Stun Baton", Type.GADGETS, 20);
	    }
	    
	    // thor abilities
	    public static Ability getHammerThrow(){
	        return new Ability("Hammer Throw", Type.PHYSICAL, 20);
	    }
	    public static Ability getThunderStorm(){
	        return new Ability("Thunder Storm", Type.LIGHTNING, 20);
	    }
	    
	    //iron man abilities
	    public static Ability getLightBlast(){
	        return new Ability("Light Blast", Type.LIGHT, 20);
	    }
	    public static Ability artilleryBarrage(){
	        return new Ability("Artilery Barrage", Type.GADGETS, 20);
	    }
	    
	    //captain america abilities
	    public static Ability getShieldBash(){
	        return new Ability("ShieldBash", Type.PHYSICAL, 20);
	    }
	    public static Ability getShieldThrow(){
	        return new Ability("ShieldThrow", Type.PHYSICAL, 20);
	    }
	    
}
