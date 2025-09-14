package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 * @Contributor Avrye Tompkins
 *
 */

public class Game extends Entity{
	
	private static List<Team> teams = new ArrayList<Team>();
	
	//According to the UML Game needs to be private
	
	@SuppressWarnings("unused")
	private Game() {
	}
	

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Team addTeam(String name) {
		
		Team tempTeam = null;
		
		//loop creation to search the list of any possible names
		for (Team currTeam : teams) {
			
			if (currTeam.name.equalsIgnoreCase(name)) {//this will check the name to see if already added, and if so it returns
				
				return currTeam;
			}
		}
		
		
		//if the player was not found, this allows for creation
		//Then we call the GameService created the new playerID
		
		GameService tempService = GameService.getGameService();
		
		tempTeam = new Team(tempService.getNextTeamId(), name);
		
		//then we add the player to the list
		teams.add(tempTeam);
		
		return tempTeam;
		
	}
	
	@Override 
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}
}
