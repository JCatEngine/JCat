package main;

import JGame.JGame;
import JGame.GameObject.GameObject;
import JGame.GameObject.LoopObject;

public class Aircraft extends GameObject{

	

	@Override
	protected void loop() {
		System.out.println("666");
		x+=5;
	}

	@Override
	protected void init() {
		System.out.println("555");
		
	}

}
