package JGame.RenderSystem.Display;

import java.util.LinkedList;

public class DisplayObjectContainer extends InteractiveObject{

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
	 * 在指定位置添加子级
	 * @param displayObject
	 * @param index
	 */
	public void addChildAt(DisplayObject displayObject, int index) {
		
		checkIndex(index,0,childs.size());
		
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
		
		displayObject.parent=this;
		
	}

	private void checkIndex(int index, int min, int max) {
		
		if(index<min||index>max)
		{
			throw new RuntimeException("out of range");
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
	public void removeChild(DisplayObject displayObject) {
		
		this.childs.remove(displayObject);
	}

	/**
	 * get all childs
	 * @return
	 */
	public LinkedList<DisplayObject> getChilds() {
		return childs;
	}

	
}
