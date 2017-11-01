package JCat.Display;

public interface Texture {

	/**
	 * get image
	 * @return
	 */
	Object getImage();

	/**
	 * get width
	 * @return
	 */
	int getWidth();

	/**
	 * get height
	 * @return
	 */
	int getHeight();

	/**
	 * get sub texture
	 * @param xPos
	 * @param yPos
	 * @param partWidth
	 * @param partHeight
	 * @return
	 */
	Texture subTexture(int xPos, int yPos, int partWidth, int partHeight);

}