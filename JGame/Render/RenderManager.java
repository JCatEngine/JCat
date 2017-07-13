package JGame.Render;

import java.awt.DisplayMode;
import java.awt.image.BufferedImage;
import java.util.HashSet;
import java.util.Set;

import JGame.GameStage;
import JGame.GameObject.DisplayObject;
import JGame.GameObject.GameObject;
import JGame.GameObject.Root;
import JGame.Manager.BaseManager;

public class RenderManager extends BaseManager{

	
	//防止同一对象重复添加 所以用set 
	private Set<DisplayObject> displayObjects=new HashSet<>();
		
	/**
	 * 进行渲染
	 * @param gameStage
	 * @param root 
	 */
	public void render(GameStage gameStage, Root root) {
		
		gameStage.clear();
		_render(gameStage,root);
		
	}

	
	
	private void _render(GameStage gameStage, DisplayObject parent) {
		//进行递归渲染对象
		if(parent.getImage()!=null)
		{
			BufferedImage image=parent.getImage();
			int width=parent.width;
			int height=parent.height;
			int x=parent.x;
			int y=parent.y;
			int angle=parent.angle;
			
			//再次递归算出绝对坐标
			DisplayObject cache=parent;
			while(cache.parent!=null)
			{
				cache=cache.parent;
				x+=cache.x;
				y+=cache.y;
				angle+=cache.angle;
			}
			
			
			
			gameStage.render(image,x,y,width,height,angle);
		}
		for(DisplayObject child:parent.getChilds())
		{
			_render(gameStage, child);
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

