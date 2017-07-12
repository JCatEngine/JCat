package main;

import JGame.JGame;
import JGame.GameObject.LoopObject;

public class test extends LoopObject{

	public test(JGame game) {
		super(game);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void loop() {
		System.out.println("666");
		
	}

	@Override
	protected void init() {
		System.out.println("555");
		
	}

}
