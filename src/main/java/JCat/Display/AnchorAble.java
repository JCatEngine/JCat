package JCat.Display;

public interface AnchorAble {
	
	public double getAnchorX();


	public void setAnchorX(double anchorX);


	public double getAnchorY();


	public void setAnchorY(double anchorY);
	
	
	/**
	 * return the width before any rotate and scale
	 * @return
	 */
	public double getRawWidth();

	/**
	 * return the height before any rotate and scale
	 * @return
	 */
	public double getRawHeight();
}
