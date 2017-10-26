package JCat.Display.Text;

import JCat.Display.AnchorAble;
import JCat.Display.Calculation.Bound;
import JCat.Graphics.Color;
import JCat.Utils.MathTool;

/**
 * a simple text
 * @author Administrator
 *
 */
public class SimpleText extends BaseText implements AnchorAble{

	private String fontName="Arial";
	private String text="";
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

	

	public String getFontName() {
		return fontName;
	}


	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	
	@Override
	protected void updateLocalBound() {
			//for displayobject,bound is base on origin width,height,and rotation,scale
			Bound bound=new Bound();
			
		
			//localbound x,y always is 0
			bound.minX=0;
			bound.minY=0;
			bound.maxX=getRawWidth()+bound.minX;
			bound.maxY=getRawHeight()+bound.minY;
			
			localBound=bound;
		
		
	}
	
	/**
	 * text can't be scale
	 */
	@Override
	public double getScaleX() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	/**
	 * text can't be scale
	 */
	@Override
	public double getScaleY() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	
	/**
	 * anchor the rotate center
	 * 0,0 equal left-top corner of the object
	 * 1,1 equal right-down corner of the object
	 */
	protected double anchorX;
	protected double anchorY;


	public double getAnchorX() {
		return anchorX;
	}


	public void setAnchorX(double anchorX) {
		MathTool.checkRange(0, 1, anchorX);
		this.anchorX = anchorX;
	}


	public double getAnchorY() {
		return anchorY;
	}


	public void setAnchorY(double anchorY) {
		MathTool.checkRange(0, 1, anchorY);
		this.anchorY = anchorY;
	}
	
	
	/**
	 * return the width before any rotate and scale
	 * @return
	 */
	public double getRawWidth() {
		double width=TextManager.getInstace().getStringWidth(getText(),fontSize,style,fontName);
		return width;
	}

	/**
	 * return the height before any rotate and scale
	 * @return
	 */
	public double getRawHeight() {
		double height=TextManager.getInstace().getStringHeight(getText(),fontSize,style,fontName);
		return height;
	}

}
