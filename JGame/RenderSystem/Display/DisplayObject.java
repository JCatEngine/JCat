package JGame.RenderSystem.Display;

import java.util.function.Function;

import JGame.GameCore.GameObject.Component.Anime.AnimeComponent;
import JGame.RenderSystem.Display.Calculation.Bound;
import JGame.RenderSystem.Display.Calculation.Transform;
import JGame.RenderSystem.Math.Matrix;
import JGame.RenderSystem.Math.Rect;
import JGame.RenderSystem.Math.Vector2;

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
	 * the origin width(before scale and rotate,be notice rotation also change the final width) 
	 */
	protected int width;
	/**
	 * the origin height(before scale and rotate,be notice rotation also change the final height) 
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
	/**
	 * localBound
	 */
	protected Bound localBound;
	
	

	public double getWidth() {
		
		return getBound(this).width;
	}


	public void setWidth(double width) {
		
		//if it's width==0,change it's width was useless
		if(getWidth()==0)
		{
			return;
		}
		else
		{
			scaleX=(width/getWidth());
		}
		
	}


	public double getHeight() {
		
		return getBound(this).height;
	}


	
	public void setHeight(double height) {
		
		//if it's height==0,change it's height was useless
		if(getHeight()==0)
		{
			return;
		}
		else
		{
			scaleY=(height/getHeight());
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
		
		updateTransform();
		

	}

	
	/**
	 * 
	 * @return
	 */
	public Transform getLocalTransform()
	{
		updateTransform();
		return localTransform;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Transform getWorldTransform()
	{
		//update transform to new and return
		//consider updateTransform is a complex calculation
		//This may not be a good solution because the transform may not change(same as last update)
		//An alternative method is use id
		//every time it's x,y and other field change,add the id
		//if the id don't equal old id,it means the transform exactly change,then update it
		//but for simplicity,i just update it every call;

		updateTransform();
		return worldTransform;
		
	}

	void updateAlpha()
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
		
		updateAlpha();
		return worldAlpha;
	}


	/**
	 * auto called before render
	 */
	void updateTransform() {
		
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
	
	
	
	void updateBound() {
	
		//for displayobject,bound is base on origin width,height,and rotation,scale
		Bound bound=new Bound();
		//localbound x,y always is 0
	
		
		
		Transform transform=this.localTransform;
		
		Vector2 vector1=new Vector2(0, 0);
		vector1=transform.apply(vector1);
		bound.addVector2(vector1);
		
		Vector2 vector2=new Vector2(width, 0);
		vector2=transform.apply(vector2);
		bound.addVector2(vector2);
		
		Vector2 vector3=new Vector2(0, height);
		vector3=transform.apply(vector3);
		bound.addVector2(vector3);
		
		Vector2 vector4=new Vector2(width, height);
		vector4=transform.apply(vector4);
		bound.addVector2(vector4);
				
		localBound=bound;
		
	}
	
	
	/**
	 * 
	 * @param displayObject 
	 * @return
	 */
	public Rect getBound(DisplayObject displayObject)
	{
		//update localBound
		updateBound();
		
		Bound bound=localBound;
		Rect rect=bound.toRect();
		//transform rect to target Coordinate
		
		
		return rect;
	}



	

	
}
