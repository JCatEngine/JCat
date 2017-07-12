package JGame.Render;

import java.awt.DisplayMode;
import java.util.HashSet;
import java.util.Set;

import JGame.GameStage;
import JGame.GameObject.DisplayObject;
import JGame.GameObject.GameObject;
import JGame.Manager.BaseManager;

public class RenderManager extends BaseManager{

	
	//防止同一对象重复添加 所以用set 
	private Set<DisplayObject> displayObjects=new HashSet<>();
		
	/**
	 * 进行渲染
	 * @param gameStage
	 */
	public void render(GameStage gameStage) {
		
		gameStage.clear();
		for(DisplayObject displayObject:displayObjects)
		{
			gameStage.render(displayObject);
		}
		
	}

	
	/**
	 * 添加渲染对象
	 * @param DisplayObject
	 */
	public void addDisplayObject(DisplayObject displayObject)
	{
		displayObjects.add(displayObject);
	}
	
	/**
	 * 移除渲染对象
	 * @param DisplayObject
	 */
	public void removeDisplayObject(DisplayObject displayObject)
	{
		displayObjects.remove(displayObject);
	}
	
}

