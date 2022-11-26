package application;
import java.util.ArrayList;
import java.util.List;

public class AvengerFactory {//temp class for producing pokemon for testing replace with database
  public static Avenger getIronMan(){
      ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getLightBlast());
      abilityList.add(AbilityFactory.artilleryBarrage());
      return new Avenger("IronMan",Type.FLYING, abilityList, "images/iron-man.png","images/iron-man-2.png");
  }
  
  public static Avenger getHulk(){
	  ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getHulkSmash());
      abilityList.add(AbilityFactory.getRage());

      return new Avenger("Hulk",Type.GROUNDED, abilityList, "images/hulk.png","images/hulk-p2.png");
  }

  public static Avenger getBlackWidow(){
	  ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getWidowsBite());
      abilityList.add(AbilityFactory.getStunBaton());

      return new Avenger("Black Widow",Type.GROUNDED, abilityList, "images/black-widow.png","images/black-widow_p2.png");
  }
  
  public static Avenger getThor(){
	  ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getHammerThrow());
      abilityList.add(AbilityFactory.getThunderStorm());

      return new Avenger("Thor",Type.FLYING, abilityList, "images/thor.png","images/thor.png");
  }
  
  public static Avenger getSpiderman(){
	  ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getSpiderWeb());
      abilityList.add(AbilityFactory.getLeapingKick());

      return new Avenger("Spiderman",Type.GROUNDED, abilityList, "images/spidey.png","images/spidey-p2.png");
  }
  
  public static Avenger getCaptainAmerica(){
	  ArrayList<Ability> abilityList = new ArrayList<>();
      abilityList.add(AbilityFactory.getShieldBash());
      abilityList.add(AbilityFactory.getShieldThrow());

      return new Avenger("Captain America",Type.GROUNDED, abilityList,"images/captain-america.png","images/captain-america-p2.png");
  }
  
}

