package JCat.Display.Text;

import JCat.Canvas.Canvas;

//Because the width and height of text can't be calculate manually,it's width and height
//can only be know from native graphics.(maybe it's can be manually calculate such as pixi.js)
//(but i choose let native graphics do this work,the bad influence is in situation which has multiple rendersystem
//the width and height of text will not be correct because this is a instance class!
public class TextManager {

	private static TextManager instance;
	private Canvas canvas;

	public static TextManager getInstace() {
		if(instance==null)
		{
			instance=new TextManager();
		}
		return instance;
	}

	private TextManager() {
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
		// TODO Auto-generated method stub
		
	}

	public double getStringWidth(String text, double fontSize, FontStyle style, String fontName) {
		// TODO Auto-generated method stub
		return canvas.getStringWidth(text,fontSize,style,fontName);
	}

	public double getStringHeight(String text, double fontSize, FontStyle style, String fontName) {
		// TODO Auto-generated method stub
		return canvas.getStringHeight(text,fontSize,style,fontName);
	}
	

}
