package JGame.RenderSystem.Display;

import java.util.function.Function;

import JGame.GameCore.GameObject.Component.Anime.AnimeComponent;
import JGame.RenderSystem.Display.Calculation.Transform;
import JGame.RenderSystem.Math.Matrix;

/**
 * baseobject that can be render to screen
 * @author Administrator
 *
 */
public abstract class DisplayObject extends EventDispatcher{

	/**
	 * x position of objecy
	 */
	public int x;
	/**
	 * y position of object
	 */
	public int y;
	/**
	 * width
	 */
	protected int width;
	/**
	 * height
	 */
	protected int height;
	/**
	 * The rotation value of the object, in angle
	 */
	public float rotation;
	/**
	 * scale x
	 */
	protected float scaleX=1;
	/**
	 * scale y
	 */
	protected float scaleY=1;
	/**
	 * alpha 0~1
	 */
	public float alpha=1;
	/**
	 * name of the object
	 */
	public String name;
	/**
	 * is this object visible?
	 */
	public boolean visible=true;
	/**
	 * stage reference
	 */
	protected Stage stage;
	/**
	 * localTransform,will be recalcued per frame
	 */
	private Transform localTransform;
	/**
	 * worldTransform,will be recalcued per frame
	 */
	private Transform worldTransform;
	/**
	 * parent
	 */
	public DisplayObjectContainer parent;
	
	

	public int getWidth() {
		return (int) (width*scaleX);
	}


	public void setWidth(int width) {
		
		//if it's width==0,change it's width was useless
		if(this.width==0)
		{
			return;
		}
		else
		{
			
			scaleX=((float)width/this.width);
			
		}
		
	}


	public int getHeight() {
		return (int) (height*scaleY);
	}


	public void setHeight(int height) {
		
		//if it's height==0,change it's width was useless
		if(this.height==0)
		{
			return;
		}
		else
		{
			scaleY=(height/this.height);
		}
	}


	public float getScaleX() {
		return scaleX;
	}


	public void setScaleX(float scaleX) {
		this.scaleX = scaleX;
	}


	public float getScaleY() {
		return scaleY;
	}


	public void setScaleY(float scaleY) {
		this.scaleY = scaleY;
	}


	public Stage getStage() {
		return stage;
	}


	public DisplayObject() {
		
		

	}

	
	/**
	 * 
	 * @return
	 */
	public Transform getLocalTransform()
	{
		return localTransform;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Transform getWorldTransform()
	{
		return worldTransform;
		
	}


	/**
	 * auto called before render
	 */
	public void updateTransform() {
		
		//update localTransform
		Transform transform=new Transform(x,y,rotation,scaleX,scaleY);
		this.localTransform=transform;
		
		
		//update worldTransform
		if(parent!=null)
		{
			
			Transform transform2=parent.getWorldTransform();
			this.worldTransform=transform.clone().append(transform2);
			this.worldTransform.updateFromMatrix();
			
		}
		else
		{
			this.worldTransform=this.localTransform.clone();
		}
		
	}
	
	
	
	



	

	
}
