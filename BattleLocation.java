package org.samti;

import java.util.Random;

public abstract class BattleLocation extends Location{
	private Enemy enemy;
	private String reward;
	private int maxEnemyNumber;

	public BattleLocation(int locationid, Player player, String name, Enemy enemy , String reward,int maxEnemyNumber) {
		super(locationid, player, name );
		this.enemy = enemy;
		this.reward = reward;
		this.maxEnemyNumber = maxEnemyNumber;
	}
	
	@Override
	public boolean onLocation() {
		int enemyNumber = this.randomEnemyNumber();
		System.out.println("Buralarda maksimum " + this.getMaxEnemyNumber() + " " + this.getEnemy().getName() + " olabiliyor. Baþarýrsan seni " + this.reward + " bekliyor olabilir." );
		System.out.println("<S>avaþ ya da <K>aç");
		String selectedWay = input.nextLine();
		
		if(selectedWay.toUpperCase().equals("S")) {
			if(combat(enemyNumber)) {
				System.out.println(this.getName() + " . You've cleared area.");
				return true;
			}
		}
		if(this.getPlayer().getHealth() <= 0) {
			System.out.println("You died !");
		}
		return true;
	}
	
	public boolean combat(int enemyNumber) {
		
		for(int i = 1 ; i < enemyNumber; i++)
		{
			this.getEnemy().setHealth(this.getEnemy().getDefHealth());
			playerstats();
			enemystats(i);
			
			while(this.getPlayer().getHealth()>0 && this.getEnemy().getHealth()>0) {
				if(randomHitChance() < 50) {
					System.out.println("Enemy Attack !!");
					int enemyAbsorb = this.getEnemy().getDamage() - this.getPlayer().getInventory().getArmor().getDefence();
					if(enemyAbsorb < 0) {
						enemyAbsorb = 0;
					}
					this.getPlayer().setHealth(this.getPlayer().getHealth()-enemyAbsorb);
					afterHit();
					
					
				}
			    
				System.out.print("<V>ur veya <K>aç");
				
				
				String selectCombat = input.nextLine();
				if(selectCombat.toUpperCase().equals("V")) {
					this.getEnemy().setHealth(this.getEnemy().getHealth()-this.getPlayer().getTotalDamage());
					afterHit();
					if(this.getEnemy().getHealth() > 0) {
						System.out.println("Enemy Attack !!");
						int enemyAbsorb = this.getEnemy().getDamage() - this.getPlayer().getInventory().getArmor().getDefence();
						if(enemyAbsorb < 0) {
							enemyAbsorb = 0;
						}
						this.getPlayer().setHealth(this.getPlayer().getHealth()-enemyAbsorb);
						afterHit();
					}
				}else {
					return false;
				}
			}
			
			if(this.getEnemy().getHealth() < this.getPlayer().getHealth()) {
				System.out.println("You won");
				System.out.println(this.getEnemy().getReward() + " coin earned.");
				this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getEnemy().getReward());
				System.out.println("Balance : " + this.getPlayer().getCoin());
			}else {
				return false;
		
			}
			
		}
		return true;
	}
	
	public void playerstats() {
		System.out.println("Player Stats");
		System.out.println("--------------------");
		System.out.println("Health : " + this.getPlayer().getHealth());
		System.out.println("Damage : " + this.getPlayer().getTotalDamage());
		System.out.println("Weapon : " + this.getPlayer().getInventory().getWeapon().getName());
		System.out.println("Armor : " + this.getPlayer().getInventory().getArmor().getName());
		System.out.println("Defence : " + this.getPlayer().getInventory().getArmor().getDefence());
		System.out.println("Money : " + this.getPlayer().getCoin());
		
	}
	
	public void afterHit() {
		System.out.println("Your Health : " + this.getPlayer().getHealth());
		System.out.println("Enemy Health : " + this.getEnemy().getHealth());
		System.out.println();
	}
	
	public void enemystats(int i) {
		System.out.println(i + ". " + this.getEnemy().getName() + " Stats");
		System.out.println("--------------------");
		System.out.println("Health : " + this.getEnemy().getHealth());
		System.out.println("Damage : " + this.getEnemy().getDamage());
		System.out.println("Reward : " + this.getEnemy().getReward());
		
	}
	
	public int randomEnemyNumber() {
		Random r = new Random();
		return r.nextInt(this.getMaxEnemyNumber())+1; 
	}
	
	public int randomHitChance() {
		Random h = new Random();
		return h.nextInt(100);
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}

	public int getMaxEnemyNumber() {
		return maxEnemyNumber;
	}

	public void setMaxEnemyNumber(int maxEnemyNumber) {
		this.maxEnemyNumber = maxEnemyNumber;
	}
	
	

}
