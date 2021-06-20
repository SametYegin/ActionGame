package org.samti;

public class Armor {
	private String name;
	private int id;
	private int defence;
	private int price;
	
	public Armor(String name, int id, int defence, int price) {
		
		this.name = name;
		this.id = id;
		this.defence = defence;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public static Armor[] armors() {
		Armor[] armorList = {new Armor("Light" , 1 , 1 , 5),new Armor("Medium",2,3,25),new Armor("Heavy", 3, 5, 40)};
		return armorList;
	}
	
	public static Armor buyArmorsByID(int id) {
		for(Armor armor : Armor.armors()) {
			if (armor.getId() == id) {
				return armor ;
			}
		}
		return null;
	}
	
	
	

}
