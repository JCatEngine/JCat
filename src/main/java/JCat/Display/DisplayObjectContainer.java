package JCat.Display;

import java.util.LinkedList;

import JCat.Display.Calculation.Bound;
import JCat.Event.AddedEvent;
import JCat.Event.RemovedEvent;
import JCat.Interaction.InteractiveObject;
import JCat.Math.Vector2;

abstract public class DisplayObjectContainer extends InteractiveObject{

	/**
	 * childs
	 */
	private LinkedList<DisplayObject> childs = new LinkedList<>();

	/**
	 * add child object
	 * @param displayObject
	 */
	public void addChild(DisplayObject displayObject) {

		addChildAt(displayObject, childs.size());
	}

	/**
	 * add child at index
	 * @param displayObject
	 * @param index
	 */
	public void addChildAt(DisplayObject displayObject, int index) {

		checkIndex(index,0,childs.size());

		 // if the child has a parent then lets remove it 
		if(displayObject.parent!=null)
		{
			displayObject.parent.removeChild(displayObject);

		}

		if(index==childs.size())
		{
			childs.add(displayObject);

		}
		else
		{
			childs.add(index, displayObject);
		}

		//dispatch added event
		dispatchEvent(new AddedEvent(displayObject));
		displayObject.parent=this;


		//set stage
		if(this.getStage()!=null)
		{
			displayObject.recursiveUpdateStage(this.getStage(),true);
		}


	}

	private void checkIndex(int index, int min, int max) {

		if(index<min||index>max)
		{
			throw new RuntimeException("out of range");
		}

	}
	
	/**
	 * add all childs
	 * @param arg
	 */
	public void addChildAll(DisplayObject ...arg) {
		for (DisplayObject displayObject : arg) {
			addChild(displayObject);
		}
		
	}

	
   
	/**
	 *Swaps the position of 2 Display Objects within this container.
	 * @param object1
	 * @param object2
	 */
    public void swapChildren(DisplayObject object1, DisplayObject object2)
    {
        if (object1 == object2)
        {
            return;
        }

        checkContains(object1);
        checkContains(object2);
        
        int index1=getChildIndex(object1);
        int index2=getChildIndex(object2);

        
        childs.set(index1, object2);
        childs.set(index2, object1);

       
    }
    
    /**
     * get child at target index
     * @param index
     * @return
     */
	public DisplayObject getChildAt(int index) {
		checkIndex(index, 0, childs.size()-1);
		return childs.get(index);
	}
    

	/**
	 * get the index of the child
	 * @param object1
	 * @return
	 */
	public int getChildIndex(DisplayObject object1) {
		
		return childs.indexOf(object1);
	}
	
	
	/**
	 * Changes the position of an existing child in the display object container
	 * @param object
	 * @param index
	 */
    public void setChildIndex(DisplayObject object, int index)
    {
        checkIndex(index, 0, childs.size()-1);
        checkContains(object);
        
        DisplayObject object2=getChildAt(index);

        swapChildren(object, object2);
    }
    
    
    /**
     * check contain
     * @param object
     * @return
     */
    public boolean hasChild(DisplayObject object)
    {
    	return this.childs.contains(object);
    }
    

	private void checkContains(DisplayObject object1) {
		if(!childs.contains(object1))
		{
			throw new RuntimeException("this container don't contain target child");
		}
		
	}

	/**
	 *
	 * @return
	 */
	public int getChildCount() {

		return childs.size();
	}

	/**
	 * remove child
	 * @return
	 */
	public DisplayObject removeChild(DisplayObject displayObject) {

		displayObject.parent=null;
		this.childs.remove(displayObject);
		displayObject.recursiveUpdateStage(null,false);
		dispatchEvent(new RemovedEvent(displayObject));
		return displayObject;

	}
	
	
	/**
	 * 
	 * @param index
	 */
	public DisplayObject removeChildAt(int index)
	{
		checkIndex(index, 0, childs.size()-1);
		return removeChild(getChildAt(index));
	}
	
	/**
	 * remove all child
	 * @param arg
	 */
	public void removeChildAll(DisplayObject ...arg)
	{
		for (DisplayObject displayObject : arg) {
			removeChild(displayObject);
		}
	}
	

	/**
	 * get all childs
	 * @return
	 */
	public LinkedList<DisplayObject> getChilds() {
		LinkedList<DisplayObject> linkedList=new LinkedList<>();
		childs.forEach(d->linkedList.add(d));
		return linkedList;
	}

	

	void updateBound() {
		Bound bound=new Bound();

		for (DisplayObject displayObject : childs) {

			if(displayObject.visible)
			{
				bound.addBound(displayObject.getBound(this));
			}
			

		}

		localBound=bound;
	}

	/**
	 * check hittest point
	 */
	@Override
	public Boolean hitTestPoint(Vector2 vector2) {

		//check whether one of childs has hittestd the point
		for (DisplayObject displayObject : childs) {
			if(displayObject.hitTestPoint(vector2)==true)
			{
				return true;
			}
		}

		return false;
	}


}
