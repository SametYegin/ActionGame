package org.samti;

public class SafeHouse extends NormalLocation{

	public SafeHouse(Player player) {
		super(1 ,player, "Safehouse");
		
	}
	
	@Override
	public boolean onLocation() {
		System.out.println("Burada durup dinlenebilirim...");
		this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
		System.out.println("Canýn yenilendi");
		return true;
	}

}
