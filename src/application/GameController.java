package application;
import application.AvengerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class GameController extends SceneController implements Initializable {
	
    @FXML
    private Label player2AvengerLabel;
    @FXML
    private Label player1AvengerLabel;
    @FXML
    private ProgressBar player2HpBar;
    @FXML
    private ProgressBar player1HpBar;
    @FXML
    private Label player2HpLabel;
    @FXML
    private Label player1HpLabel;
    @FXML
    private ImageView player1ImageView;
    @FXML
    private ImageView player2ImageView;
    @FXML
    private ImageView player1SideAnimationView;
    @FXML
    private ImageView player2SideAnimationView;
    @FXML
    private GridPane playerAbilityBox;
    @FXML
    private Button abilityBtn1;
    @FXML
    private Button abilityBtn2;
    @FXML
    private Button swapBtn;
    @FXML
    private Button cancelSwapBtn;
    @FXML
    private FlowPane PartySwapPane;
    @FXML
    private Button Avenger1Btn;
    @FXML
    private Button Avenger2Btn;
    @FXML
    private Pane dialogBox;
    @FXML
    private Text dialogText;
    @FXML
    private Text Winner;

    private BattleUIHolder player1UI;
    private BattleUIHolder player2UI;
    private BattleSlot player1Slot;
    private BattleSlot player2Slot;
    private Player p1;
    private Player p2;
    boolean isP1Turn = true;
    
    public class UI{

        public  void updateSwapUI(){ // needs to be called before each toggle true of swap menu.
        	
        	Player player = isP1Turn ? p1 : p2;
        	
        	int index = 0, aliveCount = 0;
        	// Setting swappable avenger buttons based on current party situation ( dead / staged)
        	while(index < player.party.size() &&
        			(player.party.get(index).isDead() || player.party.get(index) == player.getStagedAvenger())) {index++;}
        	if(index < player.party.size()) {
        		Avenger swappableAvenger = player.party.get(index);
        		Avenger1Btn.setText(swappableAvenger.name);
        		Avenger1Btn.setVisible(true);
        		Avenger1Btn.setDisable(false);
        		Avenger1Btn.setOnAction(e -> {
        			player.swapAvenger(swappableAvenger);
        			updateAbilityUI(); // update abilities with swapped avenger's abilities
        			toggleSwapMenu(false); // hide the swap UI because swap performed
        		});
        		index++;
        		aliveCount++;
        	}
        	while(index < player.party.size() &&
        			(player.party.get(index).isDead() || player.party.get(index) == player.getStagedAvenger())) {index++;}
        	if(index < player.party.size()) {
        		Avenger swappableAvenger = player.party.get(index);
        		Avenger2Btn.setText(swappableAvenger.name);
        		Avenger2Btn.setVisible(true);
        		Avenger2Btn.setDisable(false);
        		Avenger2Btn.setOnAction(e->{
        			player.swapAvenger(swappableAvenger);
        			updateAbilityUI(); // update abilities with swapped avenger's abilities
        			toggleSwapMenu(false);
        		});
        		aliveCount++;
        	}
        	
        	if(aliveCount == 0) {
        		Avenger1Btn.setVisible(false);
        		Avenger1Btn.setDisable(true);
        		Avenger2Btn.setVisible(false);
        		Avenger2Btn.setDisable(true);
        	}
        	if(aliveCount == 1) {
        		Avenger2Btn.setVisible(false);
        		Avenger2Btn.setDisable(true);
        	}
        	
        }
        
        public void updateAbilityUI() {
        	Player player = isP1Turn ? p1 : p2;
        	player.prepTurn(); // check if player's current avenger not dead to show abilities.
        	if(!player.canCancelSwap()) {
        		updateSwapUI();
        		toggleSwapMenu(true); // if dead, then show swap ui
        	}else {
        		Avenger stagedAvenger = player.getStagedAvenger();
            	abilityBtn1.setText(stagedAvenger.getAbility(1).getName());
            	abilityBtn2.setText(stagedAvenger.getAbility(2).getName());
            	abilityBtn1.setOnAction(e -> {
            		System.out.println("You clicked me");
            		// attack animation here
            		player.enemySlot.takeHit(stagedAvenger.getAbility(1));
            		if(isOver()) {
            			System.out.println("Route to end game win screen for player, p1 or p2 captured in player var");
            			try {
							switchToEndGameScreen(e);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
            		}
            		isP1Turn = !isP1Turn;
            		
            		updateAbilityUI();
            	});
            	
            	abilityBtn2.setOnAction(e -> {
            		// attack animation here
            		player.enemySlot.takeHit(stagedAvenger.getAbility(2));
            		if(isOver()) {
            			System.out.println("Route to end game win screen for player, p1 or p2 captured in player var");
            			try {
							switchToEndGameScreen(e);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
            		}
            		isP1Turn = !isP1Turn;
            		updateAbilityUI();
            	});
        	}

        }
        
        public void addEventHandlersToSwapBtns() {
        	Player player = isP1Turn? p1 : p2;
        	// on click of swap button
	        swapBtn.setOnAction(event -> {
	        	updateSwapUI();
	            toggleSwapMenu(true);
	        });
	        
	        // on click of cancel Swap button
	        cancelSwapBtn.setOnAction(event -> {
	        		player.prepTurn();
	        		if(player.canCancelSwap())
		                toggleSwapMenu(false);
		            else
		                System.out.println("You must swap");
	        }
	        );
        }
    }
        
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("Reached here");
		Avenger a1 = AvengerFactory.getIronMan();
        Avenger a2 = AvengerFactory.getThor();
        Avenger a3 = AvengerFactory.getBlackWidow();
        Avenger a4 = AvengerFactory.getSpiderman();
        Avenger a5 = AvengerFactory.getCaptainAmerica();
        Avenger a6 = AvengerFactory.getHulk();
        
        ArrayList<Avenger> p1Party = new ArrayList<>();
        ArrayList<Avenger> p2Party = new ArrayList<>();
        
        Avenger[] avengerPool = new Avenger[] {a1,a2,a3,a4,a5,a6};
        initializePlayersParty(p1Party, p2Party, avengerPool);
        p1 = new Player("Player 1", p1Party);
        p2 = new Player("Player 2", p2Party);
        setFxml(p1, p2);
	}
	
	private void initializePlayersParty(List<Avenger> p1Party, List<Avenger> p2Party, Avenger[] avengerPool) {
		HashSet<Integer> hs = new HashSet<>();
        int randomlySelectedIndex = -1;
        while(hs.size() < 3) {
        	randomlySelectedIndex = (int)(Math.random() * (avengerPool.length - 1));
        	if(!hs.contains(randomlySelectedIndex)) {
        		p1Party.add(avengerPool[randomlySelectedIndex]);
        		hs.add(randomlySelectedIndex);
        	}
        }
        for(int i = 0; i < avengerPool.length; i++) {
        	if(!hs.contains(i)) {
        		p2Party.add(avengerPool[i]);
        	}
        }
	}
	
	 private void setFxml(Player p1,Player p2){
		 	
		 	player1UI = new BattleUIHolder(player1AvengerLabel, player1HpBar, player1HpLabel,player1ImageView,true);
	        player2UI = new BattleUIHolder(player2AvengerLabel, player2HpBar, player2HpLabel,player2ImageView,false);
	
	        player1Slot = new BattleSlot(player1UI,player1SideAnimationView);
	        player2Slot = new BattleSlot(player2UI,player2SideAnimationView);
	        
	        p1.prepareForBattle(player1Slot, player2Slot);
	        p2.prepareForBattle(player2Slot, player1Slot);
	        
	        UI ui = new UI();
	        ui.updateAbilityUI(); //update ability btns with current avenger's abilities, and add event handlers to them
	        ui.addEventHandlersToSwapBtns();
//	        // on click of swap button
//	        swapBtn.setOnAction(event -> {
//	        	ui.updateSwapUI();
//	            toggleSwapMenu(true);
//	        });
//	        
//	        // on click of cancel Swap button
//	        cancelSwapBtn.setOnAction(event -> {
//	        	if(isP1Turn) {
//	        		p1.prepTurn();
//	        		if(p1.canCancelSwap())
//		                toggleSwapMenu(false);
//		            else
//		                System.out.println("You must swap");
//	        	}else {
//	        		p2.prepTurn();
//	        		 if(p2.canCancelSwap())
//	 	                toggleSwapMenu(false);
//	 	            else
//	 	                System.out.println("You must swap");
//	        	}
//	        }
//	        );
	        
	        
        }
	 
		public boolean isOver(){
		   return !p1.canFight() || !p2.canFight();
		}

		public void toggleSwapMenu(boolean isSwapEnabled){
	       if(isSwapEnabled){
	            PartySwapPane.setVisible(true);
	            PartySwapPane.setDisable(false);
	            cancelSwapBtn.setVisible(true);
	            cancelSwapBtn.setDisable(false);
	            swapBtn.setVisible(false);
	            swapBtn.setDisable(true);
	        }else{
	        	System.out.println("Entered here");
	        	PartySwapPane.setVisible(false);
	            PartySwapPane.setDisable(true);
	            cancelSwapBtn.setVisible(false);
	            cancelSwapBtn.setDisable(true);
	            swapBtn.setVisible(true);
	            swapBtn.setDisable(false);
	        }
		}
 }
	

