package JGame.GameCore.GameObject;

import JGame.JGame;
import JGame.GameCore.GameObject.Component.Event.AbstractEvent;
import JGame.GameCore.GameObject.Component.Event.EventRecall;
import JGame.GameCore.GameObject.Component.Event.EventType;
import JGame.GameCore.Manager.InputManager.InputManager;
import JGame.RenderSystem.Display.DisplayObject;
import JGame.RenderSystem.Display.MovieClip;

/**
 * 游戏对象
 * @author Administrator
 *
 */
public abstract class GameObject extends MovieClip{

//	@Override
//	public void addToGame(JGame jGame) {
//		// TODO Auto-generated method stub
//		super.addToGame(jGame);
//		
//		//将自己添加到游戏对象管理器中
//		game.getGameObjectManager().addGameObject(this);
//		
//		init();
//	}
//	
//	
//	@Override
//	protected void displayLoop() {
//		
//		loop();
//	}
//	
//	@Override
//	protected void displayInit() {
//		//空实现 因为自己也有init displayInit的顺序并不是最后执行的 可能会出现null错误
//	}
//	
//	protected abstract void loop();
//	protected abstract void init();
//	
//	
//	//获取输入管理器
//	public InputManager getInput()
//	{
//		return game.getInputManager();
//	}
//	

//	protected JGame game;
//	@Override
//	public void addToGame(JGame jGame) {
//		super.addToGame(jGame);
//
//		objectInit();
//		
//		
//		getCom_eventhandler().addEventListener(EventType.UPDATE, new EventRecall() {
//
//			@Override
//			public void dealEvent(AbstractEvent event) {
//				
//				_loop();
//			}
//		});
//	}
//	
//	
//	protected void _loop() {	
//		objectLoop();
//	}
//	
//	
//	abstract protected void objectLoop();
//	abstract protected void objectInit();
//
//
//	public void addToGame(JGame jGame) {
//		
//		this.game = jGame;
//		initComponent();
//		
//	}
//
//
//	public JGame getGame() {
//		return game;
//	}
//	
}
