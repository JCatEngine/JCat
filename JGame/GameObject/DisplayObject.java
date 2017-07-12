package JGame.GameObject;

import java.awt.Image;
import java.awt.image.BufferedImage;

import JGame.JGame;

/**
 * 显示对象的基类(可能不是游戏对象 比如渲染到屏幕上的调试信息)
 * @author Administrator
 *
 */
public abstract class DisplayObject extends LoopObject{

	/**
	 * 显示数据
	 */
	public int x;
	public int y;
	public int width;
	public int height;
	//(角度)
	public int angle;
	
	private BufferedImage Image;

	
	
	@Override
	public void addToGame(JGame jGame) {
		super.addToGame(jGame);
		

		//将自己添加到渲染管理器中
		game.getRenderManager().addDisplayObject(this);
		
		
		displayInit();
	}
	
	
	@Override
	protected void objectLoop() {
		
		
		displayLoop();
	}

	
	@Override
	protected void objectInit() {
		
		
	}

	protected abstract void displayLoop();
	protected abstract void displayInit();


	public BufferedImage getImage() {
		return Image;
	}


	public void setImage(BufferedImage image) {
		Image = image;
		
		//初始化长宽为图片的长宽
		if(width==0&&height==0)
		{
			width=image.getWidth();
			height=image.getHeight();
		}
	}
	
	
	
}
