package JGame.Manager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import JGame.GameObject.GameObject;

public class GameObjectManager extends BaseManager{

	//防止同一对象重复添加 所以用set 
	private Set<GameObject> gameObjects=new HashSet<>();
	
	public GameObjectManager() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 添加游戏对象
	 * @param gameObject
	 */
	public void addGameObject(GameObject gameObject)
	{
		gameObjects.add(gameObject);
	}
	
	/**
	 * 移除游戏对象
	 * @param gameObject
	 */
	public void removeGameObject(GameObject gameObject)
	{
		gameObjects.remove(gameObject);
	}
	
	
	/**
	 * 返回所有游戏对象
	 * @param gameObject
	 * @return 
	 */
	public Set<GameObject> getAllGameObject()
	{
		return gameObjects;
	}
}
