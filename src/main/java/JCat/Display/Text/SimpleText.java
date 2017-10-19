package JCat.Display.Text;

import JCat.Display.Calculation.Bound;
import JCat.Graphics.Color;
import JCat.Interaction.InteractiveObject;

/**
 * a simple text
 * @author Administrator
 *
 */
public class SimpleText extends InteractiveObject {

	private String text;
	private double fontSize=12;
	private Color color=Color.BLACK;
	private FontStyle style=FontStyle.PLAIN;

	public SimpleText(String text) {
		this.text = text;

	}
	
	
	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public double getFontSize() {
		return fontSize;
	}



	public void setFontSize(double fontSize) {
		this.fontSize = fontSize;
	}



	public Color getColor() {
		return color;
	}



	public void setColor(Color color) {
		this.color = color;
	}

	
	public FontStyle getStyle() {
		return style;
	}



	public void setStyle(FontStyle style) {
		this.style = style;
	}



	@Override
	protected void updateLocalBound() {
			//for displayobject,bound is base on origin width,height,and rotation,scale
			Bound bound=new Bound();
			
			//localbound x,y always is 0
			bound.minX=0;
			bound.minY=0;
			bound.maxX=width+bound.minX;
			bound.maxY=height+bound.minY;
			
			localBound=bound;
		
		
	}

}
