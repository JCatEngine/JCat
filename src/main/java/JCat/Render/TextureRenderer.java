package JCat.Render;

import JCat.Canvas.Canvas;
import JCat.Display.DisplayObject;
import JCat.Display.Texture;
import JCat.Render.RenderData.TextureRenderData;

public class TextureRenderer extends BaseRenderer{

	public void render(DisplayObject textureContainer, Texture texture, double anchorX, double anchorY, Canvas canvas) {
	
		
		TextureRenderData renderData=createRenderData(textureContainer,texture,anchorX,anchorY);
		//render the texture to screen
		canvas.drawTexture(texture,renderData);
		
	}
	
	
	private TextureRenderData createRenderData(DisplayObject displayObject, Texture texture, double anchorX, double anchorY) {
		
		TextureRenderData renderData=new TextureRenderData();
		renderData.alpha=displayObject.getWorldAlpha();
		//be notice there are not set the width of bitmap!
		//because rotation was be dealed before,so just return the width*scale will be fine
		renderData.width=texture.getImage().getWidth(null)*displayObject.getScaleX();
		renderData.height=texture.getImage().getHeight(null)*displayObject.getScaleY();
		renderData.x=-anchorX;
		renderData.y=-anchorY;
		
		return renderData;
	}

}
