package JCat.Render;

import JCat.Canvas.Canvas;
import JCat.Display.Bitmap;
import JCat.Display.DisplayObject;
import JCat.Display.DisplayObjectContainer;
import JCat.Display.MovieClip;
import JCat.Display.Stage;
import JCat.Graphics.Color;
import JCat.Textures.Texture;

public class Renderer {

	public void render(DisplayObject displayObject, Canvas canvas) {
		
		//dispatch event before render
		
		canvas.preRender();
		
		canvas.drawDefaultBackground(Color.ALICEBLUE);
				
		renderObject(displayObject,canvas);
				
		canvas.postRender();
				
		//dispatch event after render
		
	}

	
	/**
	 * render a object and it's child
	 * @param displayObject
	 * @param canvas 
	 */
	private void renderObject(DisplayObject displayObject, Canvas canvas) 
	{
		//move to left-top corner(default zero point)
		canvas.translate(displayObject.x,displayObject.y);
		//move to anchor(only the bitmap support it..)
		double anchorX=0.0;
		double anchorY=0.0;
		if(displayObject instanceof Bitmap)
		{
			Bitmap bitmap=(Bitmap) displayObject;
			anchorX=bitmap.getAnchorX()*displayObject.getRawWidth()*displayObject.getScaleX();
			anchorY=bitmap.getAnchorY()*displayObject.getRawHeight()*displayObject.getScaleY();
		}
		
		canvas.translate(anchorX, anchorY);
		//rotate
		canvas.rotate(displayObject.rotation/180*Math.PI);
		
		//render bitmap
		if(displayObject instanceof Bitmap)
		{
			Bitmap bitmap=(Bitmap) displayObject;
			
			if(bitmap.visible)
			{
				Texture texture=bitmap.getTexture();
				
				RenderData renderData=createRenderData(bitmap,anchorX,anchorY);
				//render the texture to screen
				canvas.drawTexture(texture,renderData);
			}
			
		}
		
		//render the current frame of the movieclip
		else if(displayObject instanceof MovieClip)
		{
			
		}
		
		//if it's a container,render it's childs
		else if(displayObject instanceof DisplayObjectContainer)
		{
			DisplayObjectContainer displayObjectContainer=(DisplayObjectContainer) displayObject;
			for(DisplayObject child:displayObjectContainer.getChilds())
			{
				renderObject(child,canvas);
			}
		}
		
		canvas.rotate(-displayObject.rotation/180*Math.PI);
		canvas.translate(-anchorX, -anchorY);
		canvas.translate(-displayObject.x, -displayObject.y);
		
		
	
	}


	private RenderData createRenderData(Bitmap bitmap, double anchorX, double anchorY) {
		
		RenderData renderData=new RenderData();
		renderData.alpha=bitmap.getWorldAlpha();
		//be notici there are not set the width of bitmap!
		//because rotation was be dealed before,so just return the width*scale will be fine
		renderData.width=bitmap.getTexture().getImage().getWidth(null)*bitmap.getScaleX();
		renderData.height=bitmap.getTexture().getImage().getHeight(null)*bitmap.getScaleY();
		renderData.x=-anchorX;
		renderData.y=-anchorY;
		
		return renderData;
	}
}
