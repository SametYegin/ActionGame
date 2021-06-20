package org.samti;

import java.util.Scanner;

public class Game {
	Scanner scan = new Scanner(System.in);

	
	
	public void start() {
		System.out.println("Karakter adýný gir : ");
		String playerName = scan.nextLine();
		Player player = new Player(playerName);
		System.out.println(playerName + " . Oyuna hoþgeldin. Hazýrla kendini.");
		player.selectChar();
		while(player.getHealth() > 0) {
		   player.showInfo();	
		   player.selectLocation();
		}
		
			
	}
		
		
	
		
}


