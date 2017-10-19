package JCat.Render;

import JCat.Canvas.Canvas;
import JCat.Graphics.Shape.BaseShape;
import JCat.Graphics.Shape.Circle;
import JCat.Graphics.Shape.Line;
import JCat.Graphics.Shape.Rect;
import JCat.Render.RenderData.ShapeRenderData;


public class ShapeRenderer extends BaseRenderer{

	public void render(BaseShape baseShape, double anchorX, double anchorY, Canvas canvas) {
		
		ShapeRenderData renderData = createRenderData(baseShape,anchorX,anchorY);
		if(baseShape instanceof Line)
		{
			// render the texture to screen
			canvas.drawLine(renderData);
		}
		else if(baseShape instanceof Rect)
		{
			canvas.drawRect(renderData);
		}
		else if(baseShape instanceof Circle)
		{
			canvas.drawCircle(renderData);
		}
		
		
	}

	private ShapeRenderData createRenderData(BaseShape baseShape, double anchorX, double anchorY) {
		
		ShapeRenderData renderData = new ShapeRenderData();
		renderData.alpha = baseShape.getWorldAlpha();
		renderData.color = baseShape.getColor();
		renderData.offsetX=-anchorX;
		renderData.offsetY=-anchorY;
		//be notice there are not set the width of bitmap!
		//because rotation was be dealed before,so just return the width*scale will be fine
		renderData.width=baseShape.getRawWidth()*baseShape.getScaleX();
		renderData.height=baseShape.getRawHeight()*baseShape.getScaleY();
		
		return renderData;
	}

}
