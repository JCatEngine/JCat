package JCat.Graphics;

import java.awt.Color;

public class ColorTool {

	public static Color toSwingColor(JCat.Graphics.Color color) {
		// TODO Auto-generated method stub
		return new Color(color.getRed(), color.getGreen(), color.getBlue());
	}

}
