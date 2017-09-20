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
	public double rotation;
	/**
	 * scale x
	 */
	protected double scaleX=1;
	/**
	 * scale y
	 */
	protected double scaleY=1;
	/**
	 * alpha 0~1
	 */
	public double alpha=1;
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
	/**
	 * world alpha of the object
	 * it's will be auto updated before render
	 */
	private double worldAlpha=1;
	
	

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
			
			scaleX=((double)width/this.width);
			
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


	public double getScaleX() {
		return scaleX;
	}


	public void setScaleX(double scaleX) {
		this.scaleX = scaleX;
	}


	public double getScaleY() {
		return scaleY;
	}


	public void setScaleY(double scaleY) {
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

	public void updateAlpha()
	{
		
		if(parent!=null)
		{
			this.worldAlpha=parent.getWorldAlpha()*this.alpha;
		}
		else
		{
			this.worldAlpha=this.alpha;
		}
		
	}

	
	
	public double getWorldAlpha() {
		
		return worldAlpha;
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
			
			Transform parentTransform=parent.getWorldTransform();
			
			//though these value can just decompose from matrix in the transform
			//but i konw little about matrix calculation,
			//so i just use this way to calculate;
			this.worldTransform=transform.clone();
			this.worldTransform.x+=parentTransform.x;
			this.worldTransform.y+=parentTransform.y;
			this.worldTransform.rotation+=parentTransform.rotation;
			this.worldTransform.scaleX*=parentTransform.scaleX;
			this.worldTransform.scaleY*=parentTransform.scaleY;
			
			//also append the matrix to ensure data are consistent with
			//matrix 
			this.worldTransform.append(parentTransform);
			
		}
		else
		{
			this.worldTransform=this.localTransform.clone();
		}
		
	}
	
	
	
	



	

	
}
