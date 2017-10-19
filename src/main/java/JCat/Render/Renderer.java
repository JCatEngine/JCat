package JCat.Render;

import JCat.Canvas.Canvas;
import JCat.Display.AnchorAble;
import JCat.Display.Bitmap;
import JCat.Display.DisplayObject;
import JCat.Display.DisplayObjectContainer;
import JCat.Display.Stage;
import JCat.Display.Texture;
import JCat.Display.MovieClip.MovieClip;
import JCat.Display.Text.SimpleText;
import JCat.Event.EventManager;
import JCat.Event.PostRenderEvent;
import JCat.Event.PreRenderEvent;
import JCat.Graphics.Color;

public class Renderer {

	/**
	 * render object tree to canvas
	 * @param stage
	 * @param canvas
	 */
	public void render(Stage stage, Canvas canvas) {
		
		//dispatch event before render
		EventManager.boardCast(stage,new PreRenderEvent());
		
		//pre render state,canvas need to init sth
		canvas.preRender();
		
		//draw back ground color
		canvas.drawDefaultBackground(Color.ALICEBLUE);
		
		//start render object recursively
		renderObject(stage,canvas);
		
		//post render state,canvas need to clear sth
		canvas.postRender();
		
		//dispatch event after render
		EventManager.boardCast(stage, new PostRenderEvent());
		
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
		if(displayObject instanceof AnchorAble)
		{
			AnchorAble anchorAble=(AnchorAble) displayObject;
			anchorX=anchorAble.getAnchorX()*anchorAble.getRawWidth()*displayObject.getScaleX();
			anchorY=anchorAble.getAnchorY()*anchorAble.getRawHeight()*displayObject.getScaleY();
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
				
				ImageRenderData renderData=createRenderData(bitmap,bitmap.getTexture(),anchorX,anchorY);
				//render the texture to screen
				canvas.drawTexture(texture,renderData);
				
			}
			
		}
		//render text
		else if(displayObject instanceof SimpleText)
		{
			SimpleText simpleText=(SimpleText) displayObject;
			if(simpleText.visible)
			{
				String text=simpleText.getText();
				
				TextRenderData renderData=createRenderData(simpleText);
				//render the texture to screen
				canvas.drawText(text,renderData);
				
				simpleText.setWidth(canvas.getStringWidth(simpleText.getText()));
				simpleText.setHeight(canvas.getStringHeight(simpleText.getText()));
			}
			
			
			
		}
		
		//render the current frame of the movieclip
		else if(displayObject instanceof MovieClip)
		{
			MovieClip movieClip=(MovieClip) displayObject;
			
			if(movieClip.visible)
			{
				Texture texture=movieClip.getTexture();
				
				ImageRenderData renderData=createRenderData(movieClip,texture,anchorX,anchorY);
				//render the texture to screen
				canvas.drawTexture(texture,renderData);
			}
			
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


	private TextRenderData createRenderData(SimpleText simpleText) {
		TextRenderData renderData=new TextRenderData();
		renderData.alpha=simpleText.getWorldAlpha();
		renderData.color=simpleText.getColor();
		renderData.size=simpleText.getFontSize();
		renderData.style=simpleText.getStyle();
		
		return renderData;
	}


	private ImageRenderData createRenderData(DisplayObject displayObject, Texture texture, double anchorX, double anchorY) {
		
		ImageRenderData renderData=new ImageRenderData();
		renderData.alpha=displayObject.getWorldAlpha();
		//be notici there are not set the width of bitmap!
		//because rotation was be dealed before,so just return the width*scale will be fine
		renderData.width=texture.getImage().getWidth(null)*displayObject.getScaleX();
		renderData.height=texture.getImage().getHeight(null)*displayObject.getScaleY();
		renderData.x=-anchorX;
		renderData.y=-anchorY;
		
		return renderData;
	}
}
