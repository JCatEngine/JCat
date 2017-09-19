package JGame.RenderSystem.Display;

import java.util.LinkedList;

public class DisplayObjectContainer extends InteractiveObject{

	/**
	 * 子级(越后加入的层级越高)
	 */
	private LinkedList<DisplayObject> childs = new LinkedList<>();

	/**
	 * 添加子级
	 * @param displayObject
	 */
	public void addChild(DisplayObject displayObject) {
		
		childs.add(displayObject);
		displayObject.parent=this;
	}

	/**
	 * 在指定位置添加子级
	 * @param displayObject
	 * @param index
	 */
	public void addChildAt(DisplayObject displayObject, int index) {
		
		childs.add(index, displayObject);
	}

	/**
	 * 返回子级数量
	 * @return
	 */
	public int getChildCount() {
		
		return childs.size();
	}

	/**
	 * 移除子级
	 * @return
	 */
	public void removeChild(DisplayObject displayObject) {
		
		this.childs.remove(displayObject);
	}

	public LinkedList<DisplayObject> getChilds() {
		return childs;
	}

}
