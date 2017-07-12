package JGame.GameObject;

import JGame.JGame;

/**
 * 最基础的game组成元素
 * @author Administrator
 *
 */
public abstract class BaseObject {

	
	protected JGame game;
	
	abstract public void addToGame(JGame jGame);

	public JGame getGame() {
		return game;
	}


	
	
}
