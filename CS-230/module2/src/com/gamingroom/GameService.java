package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 * @contriubutor Avrye Tompkins
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	
	//This is a project 1 addition
	// Extend the gameservice class for both players and teams
	
	private static long nextPlayerId = 1;
	private static long nextTeamId = 1;
	//This is the start of the singleton patter. This pattern is to ensure that only one instance of a class is allowed. This can be done by making the constructor set to private
	//The next step is to make it can only be created again when the class instance is set to null. It needs to be set to null before a new item can be created so there are no duplicate Id.

private static GameService service = null;
 
//Creating a private constructor to block the creation of a new class instance
private GameService() {
	
	//creates a private class which the singleton can refer to.
}

//creates a new single instance
public static GameService getGameService() {
	
	//calls only when instance is null
	
	if(service == null) {
		
		
			service = new GameService();
			//this runs the singleton tester which when the service is equal to none, 
			//meaning that the id is set to zero, this opens a new instance for another id to be set.
	}
	
	else {
		//debug for the singleton tester
		
		
	}
	
	return service;
	
}



	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		
		// if found, simply return the existing instance
		
		if(getGame(name) != null) {
			
			game = getGame(name);
		}
		
		else {
			
			game = new Game(nextGameId++, name);
			games.add(game);
		}
		
		//return the instance to the caller
		return game;
	}
	
	Game getGame(int index){
		return games.get(index);
	}
	
	public Game getGame(long id) {
		
		Game game = null;
		
		for (Game currGame:games) {
			
			if (currGame.getId()==id) {
				
				game = currGame;
				break;
			}
		}
		
		return game;
	}

	

	public Game getGame(String name) {

		// a local game instance
		Game game = null;
		
		
		for (Game currGame:games) {
			
			if(currGame.getName().equalsIgnoreCase(name)) {
				
				game = currGame;
				break;
			}
		}

		

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	//We now need to add a new method to help upport the previsouly establiched code
	public long getNextPlayerId() {
		
		return nextPlayerId++;
	}
	
	public long getNextTeamId() {
		
		return nextTeamId++;
	}
}
