package com.gamingroom;

//This superclass holds Game.java, Player.java, and Team.java entity
//@Avrye Tompkins
//07/20/25


public class Entity {
	
	//if we set these to protected, this means that the subclasses can inherit.
	protected long id;
	protected String name;
	
	//Set entity to protected so the subclass can call
	@SuppressWarnings("unused")
	protected Entity() {}
	
	public Entity(long id, String name) {
		
		this.id = id;
		this.name = name;
		
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
	}

}
