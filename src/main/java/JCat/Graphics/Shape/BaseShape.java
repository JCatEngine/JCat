package JCat.Graphics.Shape;



import JCat.Graphics.Color;
import JCat.Graphics.Graphics;
import JCat.Interaction.InteractiveObject;
import JCat.Utils.MathTool;

public class BaseShape extends InteractiveObject {

	private Color color=Color.BISQUE;

	@Override
	protected void updateLocalBound() {
		// TODO Auto-generated method stub

	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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
		
		return width;
	}

	/**
	 * return the height before any rotate and scale
	 * @return
	 */
	public double getRawHeight() {

		return height;
	}
		

}
