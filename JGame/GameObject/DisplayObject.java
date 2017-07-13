package JGame.GameObject;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import JGame.JGame;
import JGame.GameObject.Component.Anime.AnimeComponent;

/**
 * 显示对象的基类(可能不是游戏对象 比如渲染到屏幕上的调试信息)
 * @author Administrator
 *
 */
public abstract class DisplayObject extends LoopObject{

	/**
	 * 显示数据(xy为相对坐标)
	 */
	public int x;
	public int y;
	public int width;
	public int height;
	/**
	 * 相对角度(是角度不是弧度)
	 */
	public int angle;
	
	
	/**
	 * 子级(越后加入的层级越高)
	 */
	private LinkedList<DisplayObject> childs=new LinkedList<>();
	/**
	 * 父级
	 */
	public DisplayObject parent;
	/**
	 * 根对象
	 */
	public Root root;
	
	/**
	 * 动画组件
	 */
	private AnimeComponent com_anime;
	
	@Override
	public void addToGame(JGame jGame) {
		super.addToGame(jGame);
		

//		//将自己添加到渲染的根对象组中
//		game.getRenderManager().addDisplayObject(this);
		
		root=jGame.getRoot();
		
		com_anime=new AnimeComponent(this);
		
		displayInit();
	}
	
	
	@Override
	protected void objectLoop() {
		
		com_anime.loopAnime();
		
		displayLoop();
	}

	
	@Override
	protected void objectInit() {
		
		
	}

	protected abstract void displayLoop();
	protected abstract void displayInit();



	
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
	public void addChildAt(DisplayObject displayObject,int index) {
		
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


	public AnimeComponent getCom_anime() {
		return com_anime;
	}
	
	
}
