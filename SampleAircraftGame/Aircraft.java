package SampleAircraftGame;

import JGame.JGame;
import JGame.GameCore.GameObject.GameObject;
import JGame.GameCore.GameObject.LoopObject;
import JGame.Manager.InputManager.InputManager;
import JGame.Manager.InputManager.KeyCode;

public class Aircraft extends GameObject{

	

	@Override
	protected void loop() {
		
		//System.out.println(getInput().isKeyDownIng(KeyCode.VK_W));
		if(getInput().isKeyDownIng(KeyCode.VK_W))
		{
			y-=5;
		}
		if(getInput().isKeyDownIng(KeyCode.VK_A))
		{
			x-=5;
		}
		if(getInput().isKeyDownIng(KeyCode.VK_D))
		{
			x+=5;
		}
		if(getInput().isKeyDownIng(KeyCode.VK_S))
		{
			y+=5;
		}
		
	}

	@Override
	protected void init() {
		
		
	}

}
