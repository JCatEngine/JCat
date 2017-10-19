package JCat.Graphics;

import JCat.Canvas.Canvas;
import JCat.Display.Text.FontStyle;

public class Graphics {

	private static Graphics instance;
	private Canvas canvas;

	public static Graphics getInstace() {
		if(instance==null)
		{
			instance=new Graphics();
		}
		return instance;
	}

	private Graphics() {
		// TODO Auto-generated constructor stub
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
