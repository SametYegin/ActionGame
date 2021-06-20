package org.samti;

public abstract class NormalLocation extends Location{



	public NormalLocation(int locationid , Player player, String name) {
		super(locationid ,player, name);
		
	}

	@Override
	public boolean onLocation() {
		return true;
	}
	
	

}
