package org.samti;

public class ToolStore extends NormalLocation{

	public ToolStore(Player player) {
		super(2 , player , "Shop");
		
	}
	
	@Override
	public boolean onLocation() {
		System.out.println("Burada neler varmýþ bakalým...");
		System.out.println("------------------------------");
		System.out.println("Hello I'm blacksmith of this town. What you need today ?");
		System.out.println("1 - Buy weapon");
		System.out.println("2 - Buy armor");
		System.out.println("3 - Exit");
		int selectCase = input.nextInt();
		while (selectCase < 1 || selectCase > 3) {
			System.out.println("I can't understand you.");
			selectCase = input.nextInt();
		}
		switch(selectCase) {
		case 1 : printWeapon();
		         buyWeapon();
		break;
		
		case 2 : printArmor();
		         buyArmor();
		break;
		
		case 3 : System.out.println("Be careful out there !!");
		
		return true;
		}
		return true;
	}

	public void printWeapon() {
		System.out.println("Weapons ---");
		for(Weapon weaponlist : Weapon.weapons()) {
			System.out.println(weaponlist.getId() + " - " + weaponlist.getName() + "-----> Price : " + weaponlist.getPrice() + " Hasar : " + weaponlist.getDamage() );
			
		}
		
		
	}
	
	public void buyWeapon(){
		System.out.println("Buy anything little boy .");
		int selectWeaponID = input.nextInt();
		while (selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length) {
			System.out.println("I don't have it");
			selectWeaponID = input.nextInt();
		}
			Weapon selectedWeapon = Weapon.buyWeaponByID(selectWeaponID);
			if(selectedWeapon != null) {
				if(selectedWeapon.getPrice() > this.getPlayer().getCoin()) {
					System.out.println("It's more from that boy");
				}else {
					System.out.println("Use that carefully. You bought " + selectedWeapon.getName() );
					int balance = this.getPlayer().getCoin()-selectedWeapon.getPrice();
					this.getPlayer().setCoin(balance);
					System.out.println("Your balance : " + this.getPlayer().getCoin());
					System.out.print(this.getPlayer().getInventory().getWeapon().getName());
					this.getPlayer().getInventory().setWeapon(selectedWeapon);
					System.out.print(" changed to " + this.getPlayer().getInventory().getWeapon().getName());
					System.out.println();
				}
			}
	}

	public void printArmor() {
		System.out.println("Armors ---");
		for(Armor armorlist : Armor.armors()) {
			System.out.println(armorlist.getId() + " - " + armorlist.getName() + " -----> Price : " + armorlist.getPrice() + " Defence : " + armorlist.getDefence());
			
		}
		
	}
	
	public void buyArmor(){
		System.out.println("Buy anything little boy .");
		int selectArmorID = input.nextInt();
		while (selectArmorID < 1 || selectArmorID > Armor.armors().length) {
			System.out.println("I don't have it");
			selectArmorID = input.nextInt();
		}
			Armor selectedArmor = Armor.buyArmorsByID(selectArmorID);
			if(selectedArmor != null) {
				if(selectedArmor.getPrice() > this.getPlayer().getCoin()) {
					System.out.println("It's more from that boy");
				}else {
					System.out.println("Use that carefully. You bought " + selectedArmor.getName() + "armor");
					int balance = this.getPlayer().getCoin()-selectedArmor.getPrice();
					this.getPlayer().setCoin(balance);
					System.out.println("Your balance : " + this.getPlayer().getCoin());
					System.out.print(this.getPlayer().getInventory().getArmor().getName());
					this.getPlayer().getInventory().setArmor(selectedArmor);
					System.out.print(" changed to " + this.getPlayer().getInventory().getArmor().getName());
					System.out.println();
				}
			}
	}
	
	

}
