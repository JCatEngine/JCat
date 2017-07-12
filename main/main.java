package main;

import JGame.JGame;
import JGame.GameObject.EventDispatcher;
import JGame.Render.SwingStage;

public class main {

	public static void main(String[] args) {
		JGame jGame=new JGame(new SwingStage(600,800),5);
		new test(jGame);
		
	}
}
