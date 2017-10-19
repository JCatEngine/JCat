package JCat.Render;

import JCat.Canvas.Canvas;
import JCat.Display.Text.SimpleText;
import JCat.Render.RenderData.TextRenderData;

public class TextRenderer extends BaseRenderer{

	public void render(SimpleText simpleText, Canvas canvas) {
		TextRenderData renderData = createRenderData(simpleText);
		// render the texture to screen
		canvas.drawText(simpleText.getText(), renderData);

		simpleText.setWidth(canvas.getStringWidth(simpleText.getText()));
		simpleText.setHeight(canvas.getStringHeight(simpleText.getText()));
		
	}
	
	
	private TextRenderData createRenderData(SimpleText simpleText) {
		TextRenderData renderData = new TextRenderData();
		renderData.alpha = simpleText.getWorldAlpha();
		renderData.color = simpleText.getColor();
		renderData.size = simpleText.getFontSize();
		renderData.style = simpleText.getStyle();

		return renderData;
	}

}
