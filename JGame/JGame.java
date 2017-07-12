package JGame;

import JGame.Manager.LoopManager;
import JGame.Manager.LoopManager.OnResponceListener;
import JGame.Manager.ManagerInstaceFactory;
import JGame.Render.GameStage;
import JGame.Render.SwingStage;

public class JGame {

	/**
	 * 游戏舞台
	 */
	private GameStage gameStage;
	

	public JGame(GameStage gameStage, int frameRate) {
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

	
	/**
	 * 主循环
	 */
	protected void mainLoop() {
		// TODO Auto-generated method stub
		
	}


	public LoopManager getLoopManager() {
		
		return ManagerInstaceFactory.getManagerInstance(LoopManager.class);
	}


	
}
