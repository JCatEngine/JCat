package JCat.Canvas;

import JCat.Graphics.Color;
import JCat.Platform.Canvas.SwingCanvas;

public class CanvasFactory {

	/**
	 * create a canvas
	 * @param type
	 * @param width
	 * @param height
	 * @return
	 */
	public static Canvas getCanvas(CanvasType type, int width, int height) {
		
		Canvas canvas=null;
		if(type==CanvasType.swing)
		{
			 canvas = new SwingCanvas(width, height);
			
		}
		else if(type==CanvasType.javafx)
		{
			throw new RuntimeException("unsupport canvas currently");
		}
		else if(type==CanvasType.swt)
		{
			throw new RuntimeException("unsupport canvas currently");
		}
		else
		{
			throw new RuntimeException("unsupport canvas currently");
		}
		
		return canvas;
				
	}

}
