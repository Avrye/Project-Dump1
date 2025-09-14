package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 * @contribute Avrye Tompkins
 *
 */
public class Team extends Entity {
	
	private static List<Player> players = new ArrayList<Player>();
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Player addPlayer(String name) {
		Player tempPlayer = null;
		
		
		//loop iteration
		for (Player currPlayer : players) {
			
			if (currPlayer.name.equalsIgnoreCase(name)) {
				
				return currPlayer;
			}
		}
		
		//if Player wasnt found make a new creation
		
		GameService tempService = GameService.getGameService();
		
		tempPlayer = new Player(tempService.getNextPlayerId(), name);
		
		//This will add the players onto the list
		
		players.add(tempPlayer);
		
		return tempPlayer;
	}


	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
