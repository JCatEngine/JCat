package JCat.Display;

import JCat.Display.Calculation.Bound;
import JCat.Display.Calculation.Transform;
import JCat.Event.EventDispatcher;
import JCat.Math.Rect;
import JCat.Math.Vector2;
import JCat.Utils.MathTool;

/**
 * base object that can be render to screen
 * @author Administrator
 *
 */
public abstract class DisplayObject extends EventDispatcher{

	/**
	 * x position of object
	 */
	public double x;
	/**
	 * y position of object
	 */
	public double y;
	/**
	 * the origin width(before scale and rotate,be notice rotation also change the final width)
	 */
	protected double width;
	/**
	 * the origin height(before scale and rotate,be notice rotation also change the final height)
	 */
	protected double height;
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
	 * stage reference,if a object is in the root display tree this field will not be null
	 * but if a object is not in the root display tree such as just inited and be remove
	 * from parent,this field will be null
	 */
	Stage stage;
	/**
	 * localTransform
	 */
	private Transform localTransform;
	/**
	 * worldTransform
	 */
	private Transform worldTransform;
	/**
	 * parent
	 */
	DisplayObjectContainer parent;
	/**
	 * world alpha of the object
	 * it's will be auto updated before render
	 */
	private double worldAlpha=1;
	/**
	 * localBound
	 */
	protected Bound localBound;



	/**
	 * note the returned width is the width in the parent coordinate as same as other field like x,y
	 * the width fleid itself was the origin width have not be scaled,be rotated...
	 * @return
	 */
	public double getWidth() {
		
		return getBound(parent).width;
	}


	public void setWidth(double width) {


		//if it's width==0,change it's width was useless,because there are nothing!
		if(getWidth()==0)
		{
			return;
		}
		else
		{
			//because rotate will change width ,so we need call getWidth() instead of "scale=this.width/width"
			scaleX=(width/(getWidth()/scaleX));

		}

	}


	/**
	 * note the returned height is the height in the parent coordinate as same as other field like x,y
	 * the height fleid itself was the origin height have not be scaled,be rotated...
	 * @return
	 */
	public double getHeight() {

		return getBound(parent).height;
	}



	public void setHeight(double height) {

		//if it's height==0,change it's height was useless,,because there are nothing!
		if(getHeight()==0)
		{
			return;
		}
		else
		{
			//because rotate will change height ,so we need call getHeight() instead of "scale=this.height/height"
			scaleY=(height/(getHeight()/scaleY));
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



	public DisplayObject() {

		updateTransform();



	}


	/**
	 *
	 * @return
	 */
	public Transform getLocalTransform()
	{
		updateLocalTransform();
		return localTransform;

	}

	/**
	 * updateLocalTransform
	 */
	private void updateLocalTransform() {

		//update localTransform
		Transform transform=new Transform(x,y,rotation,scaleX,scaleY);
		this.localTransform=transform;

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
	 * update LocalTransform and world transform,because transform will change every moment,
	 * so every time you need a transform,the two transform will update
	 * (a better way is use valid flag to determine whether a new transform was needed
	 * but for simplicity,i just update it )
	 * 
	 */
	void updateTransform() {

		updateLocalTransform();


		//update worldTransform
		if(parent!=null)
		{

			Transform parentTransform=parent.getWorldTransform();

			//though these value can just decompose from matrix in the transform
			//but i konw little about matrix calculation,
			//so i just use this way to calculate;
			this.worldTransform=localTransform.clone();
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


	/**
	 * update local bound(the display object don't have width and height,so it's abstract)
	 * bitmap set it localbound to fix texture,displaycontainer set it's bound to fit all it's childs
	 */
	abstract protected void updateLocalBound();


	/**
	 *get the bound in the target Coordinate
	 * @param displayObject
	 * @return
	 */
	public Rect getBound(DisplayObject displayObject)
	{
				//update localBound
				updateLocalBound();
				
				Rect rect=localBound.toRect();

				Bound bound=new Bound();
				Transform transform;
				if(displayObject==null)
				{
					transform=Transform.staticTransform;
				}
				else
				{
					transform=displayObject.getWorldTransform();
				}
				
				Vector2 vector1=rect.getLeftTopPoint();
				vector1=localToGlobal(vector1);
				vector1=transform.applyInverse(vector1);
				bound.addVector2(vector1);

				Vector2 vector2=rect.getRightTopPoint();
				vector2=localToGlobal(vector2);
				vector2=transform.applyInverse(vector2);
				bound.addVector2(vector2);

				Vector2 vector3=rect.getLeftDownPoint();
				vector3=localToGlobal(vector3);
				vector3=transform.applyInverse(vector3);
				bound.addVector2(vector3);

				Vector2 vector4=rect.getRightDownPoint();
				vector4=localToGlobal(vector4);
				vector4=transform.applyInverse(vector4);
				bound.addVector2(vector4);



				return bound.toRect();
	}


	/**
	 *
	 * @param vector2 the point in world coordinate
	 * @return
	 */
	public Vector2 globalToLocal(Vector2 vector2)
	{
		return getWorldTransform().applyInverse(vector2);
	}

	/**
	 *
	 * @param displayObject
	 * @return
	 */
	public Boolean hitTestObject(DisplayObject displayObject)
	{
		updateLocalBound();
		
		Rect rect=this.getBound(this.stage);
		Rect rect2=displayObject.getBound(this.stage);
		
		
		return rect.hitTest(rect2);


	}

	/**
	 * check hitTest width Point
	 * @param vector2 in the world Coordinate
	 * @return
	 */
	public Boolean hitTestPoint(Vector2 vector2)
	{
		updateLocalBound();
		Vector2 local=getWorldTransform().applyInverse(vector2);
	
		//todo use the exist pixel to detect,because a image may contain transparent pixel
		return localBound.toRect().contains(local);


	}

	/**
	 *
	 * @param vector2
	 * @return
	 */
	public Vector2 localToGlobal(Vector2 vector2)
	{
		return getWorldTransform().apply(vector2);
	}


	/**
	 * Recursive set the stage field of the child object
	 * if a DisplayObjectContainer was removed from parent,
	 * the DisplayObjectContainer itself and all it's childs will
	 * be removed from stage|main display tree
	 * on the contrary,if a object was added to stage or a object in the main display tree
	 * all it childs will be add to main display tree
	 * @param stage
	 */
	void recursiveUpdateStage(Stage stage) {

		
		this.stage=stage;
		

		if(this instanceof DisplayObjectContainer)
		{
			DisplayObjectContainer container=(DisplayObjectContainer) this;
			for (DisplayObject displayObject : container.getChilds()) {

				displayObject.recursiveUpdateStage(stage);
			}
		}

	}


	public Stage getStage() {
		return stage;
	}


	public DisplayObjectContainer getParent() {
		return parent;
	}

	




}