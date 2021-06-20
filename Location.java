package org.samti;

import java.util.Scanner;

public abstract class Location {
	
	private Player player;
	private String name;
	private int locationid;
	protected Scanner input = new Scanner(System.in);
	
	
	public Location(int locationid,Player player,String name) {
		
		this.player = player;
		this.name = name;
		this.locationid = locationid;
	}


	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	public int getLocationid() {
		return locationid;
	}


	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}


	public abstract boolean onLocation();
	
	
	

}
