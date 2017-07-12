package JGame;

import JGame.GameObject.EventDispatcher;
import JGame.GameObject.Component.Event.UpdateEvent;
import JGame.Manager.EventManager;
import JGame.Manager.GameObjectManager;
import JGame.Manager.LoopManager;
import JGame.Manager.InputManager.InputManager;
import JGame.Manager.LoopManager.OnResponceListener;
import JGame.Render.RenderManager;

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
	private RenderManager renderManager;
	private InputManager inputManager;

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
		
		
		gameStage.setInputManager(inputManager);
		
	}

	
	public JGame(int width, int height, int frameRate) {
		
		//默认使用swing作为渲染
		this(new SwingStage(width, height), frameRate);
	}


	private void initManager() {
		
		
		loopManager=new LoopManager();
		eventManager=new EventManager();
		gameObjectManager=new GameObjectManager();
		renderManager=new RenderManager();
		inputManager=new InputManager();
	}


	/**
	 * 主循环
	 */
	protected void mainLoop() {	
		
		//锁定输入
		inputManager.lockInput();
		//广播更新事件
		eventManager.sendBroadCast(new UpdateEvent());
		//处理消息
		eventManager.dealMessage();
		//进行渲染
		renderManager.render(gameStage);
		//解锁输入
		inputManager.upLockInput();
		
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

	public RenderManager getRenderManager() {
		
		return renderManager;
	}

	public InputManager getInputManager() {
		
		return inputManager;
	}

	public void addObject(EventDispatcher eventDispatcher) {
		
		eventDispatcher.addToGame(this);
	}
}
