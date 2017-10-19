package JCat.Render;

import JCat.Canvas.Canvas;
import JCat.Display.Text.SimpleText;
import JCat.Render.RenderData.TextRenderData;

public class TextRenderer extends BaseRenderer{

	public void render(SimpleText simpleText, double anchorX, double anchorY, Canvas canvas) {
		TextRenderData renderData = createRenderData(simpleText,anchorX,anchorY);
		// render the texture to screen
		canvas.drawText(simpleText.getText(), renderData);

		
	}
	
	
	private TextRenderData createRenderData(SimpleText simpleText, double anchorX, double anchorY) {
		TextRenderData renderData = new TextRenderData();
		renderData.alpha = simpleText.getWorldAlpha();
		renderData.color = simpleText.getColor();
		renderData.size = simpleText.getFontSize();
		renderData.style = simpleText.getStyle();
		renderData.fontName=simpleText.getFontName();
		renderData.x=-anchorX;
		renderData.y=-anchorY;
		renderData.width=simpleText.getRawWidth();
		renderData.height=simpleText.getRawHeight();
		return renderData;
	}

}
