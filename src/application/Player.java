package application;

import java.util.ArrayList;
import java.util.List;

public class Player {

	String name;
	ArrayList<Avenger> party = new ArrayList<>();;
	private Avenger stagedAvenger = null;
	protected  BattleSlot ownedSlot;
    protected BattleSlot enemySlot;
    private boolean canCancelSwap = true;
    
	 protected Player(String _name,List<Avenger> avengers) {
	        name = _name;
	        for (Avenger a: avengers) {
	            party.add(a);
	        }
	    }
	 	
	 public void prepTurn() {
	        canCancelSwap = true;
	        if (ownedSlot.getCurAvenger().isDead()){
	            canCancelSwap = false;
	        }
	    }
	 
	    public Avenger getStagedAvenger(){
	        return stagedAvenger;
	    }

	    public boolean canFight() {
	        for (Avenger a:party) {
	            if(!a.isDead())
	                return true;
	        }
	        return false;
	    }

	    public boolean canSwap(){
	        for (Avenger a:party) {
	            if(!a.isDead() && a != getStagedAvenger())
	                return  true;
	            else{
	                System.out.println(a.name + " is fainted or is already in battle");
	            }
	        }
	        return  false;
	    }
	    
	    public boolean canCancelSwap(){
	        return canCancelSwap;
	    }
	    
	    public void tryToSwap(Avenger avengerToSwapWith){
	        if(canSwap()){
	            if(getStagedAvenger() != avengerToSwapWith){
	                swapAvenger(avengerToSwapWith);
	            }else{
	                System.out.println(avengerToSwapWith.name + " has already been sent out");
	            }
	        }else{
	            System.out.println(name+" can't swap");
	        }
	    }
	    
	    public void swapAvenger(){
	        System.out.println(getStagedAvenger().name + " was recalled");
	        Avenger avengerToSwapWith = sendOutFirstAvailableAvenger();
	        swapAvenger(avengerToSwapWith);
	    }

	    public void swapAvenger(Avenger avengerToSwapWith ){
	        if(avengerToSwapWith == null)
	            System.out.println("swap failed");
	        else{
	            stagedAvenger = avengerToSwapWith;
	            ownedSlot.setAvenger(stagedAvenger);
	        }
	    }

	    public Avenger sendOutFirstAvailableAvenger(){
	        for (Avenger a :party) {
	            if(!a.isDead() && stagedAvenger != a) {
	                return a;
	            }
	        }
	        return  null;
	    }

	    public Avenger stageFirstAvailableAvenger(){
	        Avenger a = sendOutFirstAvailableAvenger();
	        stagedAvenger = a;
	        System.out.println(name+"sending avenger "+ a.name);
	        return stagedAvenger;
	    }
	    
	    
	    public void prepareForBattle(BattleSlot ownedSlot,BattleSlot enemySlot){
	        this.ownedSlot = ownedSlot;
	        this.enemySlot = enemySlot;
	        
	        ownedSlot.setAvenger(stageFirstAvailableAvenger());
	    }
	    
	    
	
}
