package org.samti;

import java.util.Scanner;




public class Player {
	Scanner scan = new Scanner(System.in);
	public Inventory inventory;
	public int damage;
	public int health;
	private int originalHealth;
	public int coin;
	public String name;
	public String characterName;
	
	
	
	public Player(String name) {
		this.name = name;
		this.inventory = new Inventory();
	}
	
	
	
	
	public Inventory getInventory() {
		return inventory;
	}




	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}



    public int getTotalDamage() {
    	return damage + this.getInventory().getWeapon().getDamage();
    }
    
	public int getDamage() {
		return damage;
	}




	public void setDamage(int damage) {
		this.damage = damage;
	}




	public int getHealth() {
		return health;
	}




	public void setHealth(int health) {
		this.health = health;
	}




	public int getCoin() {
		return coin;
	}




	public void setCoin(int coin) {
		this.coin = coin;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getCharacterName() {
		return characterName;
	}




	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}




	public int getOriginalHealth() {
		return originalHealth;
	}




	public void setOriginalHealth(int originalHealth) {
		this.originalHealth = originalHealth;
	}




	public void selectChar() {
		CharacterGame[] charList = {new Samurai(),new Archer(),new Knight()};
		System.out.println("******************");
		System.out.println("KARAKTERLER");
		for(CharacterGame charGame : charList) {
			System.out.println("-ID: " + "   " + charGame.getId() + "    " + charGame.getName() + "     Damage : " + charGame.getDamage() + "       Health : " + charGame.getHealth() + "         Base Coin : " + charGame.getCoin());
		}
		int selectChar = scan.nextInt();
		switch(selectChar) {
		case 1:
			init(new Samurai());
			break;
		case 2 :
			init(new Archer());
		    break;
		case 3 : 
			init(new Knight());
			break;
		default :
			System.out.println("Sýnýrýn dýþýnda bir sayýya bastýn ama ben sende samurai ýþýðý gördüm. O yüzden samurai oldun ");
			init(new Samurai());
			break;
		}
		System.out.println("Karakterin " + this.characterName + ". Oyuna baþlýyoruz !!!");
		
	}
	
	public void selectLocation() {
		
		Location[] location = {new SafeHouse(this),new ToolStore(this),new Cave(this),new Forest(this),new River(this),new Mine(this)};
		
		System.out.println("Nereye gitsem ?");
		for(Location locationChoose : location) {
			System.out.println(locationChoose.getLocationid() + " - " + locationChoose.getName());
		}
		
		
		int selectLocation = scan.nextInt();
		
		
		switch(selectLocation) {
		case 1 :
			location[0].onLocation();
			break;
		case 2 : 
			location[1].onLocation();
			break;
		case 3 :
			location[2].onLocation();
			break;
		case 4 :
			location[3].onLocation();
			break;
		case 5 :
			location[4].onLocation();
			break;
		case 6 :
			location[5].onLocation();
			break;	
		default : 
			location[0].onLocation();
			break;
		    
		}
		
		
		
	}
	
	
	public void init(CharacterGame charGame) {
		this.setCharacterName(charGame.getName());
		this.setDamage(charGame.getDamage());
		this.setHealth(charGame.getHealth());
		this.setOriginalHealth(charGame.getHealth());
		this.setCoin(charGame.getCoin());
		
	}
	
	public void showInfo() {
		System.out.println("Silahýnýz : " + this.getInventory().getWeapon().getName() + " , Zýrhýnýz :" + this.getInventory().getArmor().getName() + " , Defence : " + this.getInventory().getArmor().getDefence() + ", Hasarýnýz : " + this.getTotalDamage() + " , "
				 + "Saðlýk : " + this.getHealth() + " , " + " Paranýz : " + this.getCoin());
	}
	
	public Weapon getWeapon() {
		return this.getInventory().getWeapon();
	}

}
