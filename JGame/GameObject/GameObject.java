package JGame.GameObject;

import JGame.JGame;
import JGame.Manager.InputManager.InputManager;

/**
 * 游戏对象
 * @author Administrator
 *
 */
public abstract class GameObject extends DisplayObject{

	@Override
	public void addToGame(JGame jGame) {
		// TODO Auto-generated method stub
		super.addToGame(jGame);
		
		//将自己添加到游戏对象管理器中
		game.getGameObjectManager().addGameObject(this);
		
		init();
	}
	
	
	@Override
	protected void displayLoop() {
		
		loop();
	}
	
	@Override
	protected void displayInit() {
		//空实现 因为自己也有init displayInit的顺序并不是最后执行的 可能会出现空指针错误
	}
	
	protected abstract void loop();
	protected abstract void init();
	
	
	//获取输入管理器
	public InputManager getInput()
	{
		return game.getInputManager();
	}
	

}
