package application;
import java.util.ArrayList;
import java.util.List;

public class AvengerFactory {//temp class for producing pokemon for testing replace with database
  public static Avenger getIronMan(){
      ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getLightBlast());
      abilityList.add(AbilityFactory.artilleryBarrage());
      return new Avenger("IronMan",Type.FLYING, abilityList, "application/images/iron-man.png", "application/images/spiderman sideways.png");
  }
  
  public static Avenger getHulk(){
	  ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getHulkSmash());
      abilityList.add(AbilityFactory.getRage());

      return new Avenger("Hulk",Type.GROUNDED, abilityList, "application/images/hulk.png", "application/images/spiderman sideways.png");
  }

  public static Avenger getBlackWidow(){
	  ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getWidowsBite());
      abilityList.add(AbilityFactory.getStunBaton());

      return new Avenger("Black Widow",Type.GROUNDED, abilityList, "application/images/black-widow.png", "application/images/spiderman sideways.png");
  }
  
  public static Avenger getThor(){
	  ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getHammerThrow());
      abilityList.add(AbilityFactory.getThunderStorm());

      return new Avenger("Thor",Type.FLYING, abilityList, "application/images/thor.png", "application/images/spiderman sideways.png");
  }
  
  public static Avenger getSpiderman(){
	  ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getSpiderWeb());
      abilityList.add(AbilityFactory.getLeapingKick());

      return new Avenger("Spiderman",Type.GROUNDED, abilityList, "application/images/spidey-standing.png", "application/images/spiderman sideways.png");
  }
  
  public static Avenger getCaptainAmerica(){
	  ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getShieldBash());
      abilityList.add(AbilityFactory.getShieldThrow());

      return new Avenger("Captain America",Type.GROUNDED, abilityList,"application/images/captain-america.png", "application/images/spiderman sideways.png");
  }
  
}

