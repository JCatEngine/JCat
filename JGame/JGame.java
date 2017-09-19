package JGame;

import JGame.GameCore.GameObject.Component.Event.UpdateEvent;
import JGame.Manager.EventManager;
import JGame.Manager.GameObjectManager;
import JGame.Manager.LoopManager;
import JGame.Manager.InputManager.InputManager;
import JGame.Manager.LoopManager.OnResponceListener;
import JGame.Render.RenderManager;
import JGame.RenderSystem.Display.DisplayObject;
import JGame.RenderSystem.Display.EventDispatcher;

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
	
	/**
	 * 顶级对象 从该对象开始向下渲染 因此所有需要渲染的对象必须在该对象的子树下
	 */
	private Root root;

	public JGame(GameStage gameStage, int frameRate) {
		//init subSystem
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
		
		
		root=new Root();
		root.addToGame(this);
		
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
		renderManager.render(gameStage,root);
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


	public Root getRoot() {
		return root;
	}
	
	
	public void addToRoot(DisplayObject object) {
		
		root.addChild(object);
	}
}
