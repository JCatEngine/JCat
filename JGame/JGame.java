package JGame;

import JGame.GameObject.Component.Event.UpdateEvent;
import JGame.Manager.EventManager;
import JGame.Manager.GameObjectManager;
import JGame.Manager.LoopManager;
import JGame.Manager.LoopManager.OnResponceListener;
import JGame.Render.GameStage;
import JGame.Render.SwingStage;

public class JGame {

	/**
	 * 游戏舞台
	 */
	private GameStage gameStage;
	/**
	 * 管理器
	 */
	private LoopManager loopManager;
	private EventManager eventManager;
	private GameObjectManager gameObjectManager;
	

	public JGame(GameStage gameStage, int frameRate) {
		initManager();
		
		this.gameStage = gameStage;
	
		//开始主循环
		getLoopManager().startLoop(frameRate);
		getLoopManager().addOnResponceListener(new OnResponceListener() {

			@Override
			public void onResponce() {
				mainLoop();
			}
		});
		
		
	}

	
	private void initManager() {
		
		
		loopManager=new LoopManager();
		eventManager=new EventManager();
	}


	/**
	 * 主循环
	 */
	protected void mainLoop() {	
		//广播事件
		eventManager.sendBroadCast(new UpdateEvent());
		//处理消息
		eventManager.dealMessage();
	}


	public LoopManager getLoopManager() {
		
		return loopManager;
	}

	public EventManager getEventManager() {
		
		return eventManager;
	}

	public GameObjectManager getGameObjectManager() {
		
		return gameObjectManager;
	}

}
