package SampleAircraftGame.Util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import SampleAircraftGame.Config;

public class Util {

	public static BufferedImage LoadImg(String imgName) {
		// TODO Auto-generated method stub
		try {
			return 	ImageIO.read(new File(Config.IMG_FOLDER+"\\"+imgName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
