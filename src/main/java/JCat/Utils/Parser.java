package JCat.Utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import Bean.AnimeClip;
import Bean.Frame;
import Bean.ResourceData;
import JCat.Display.Texture;
import JCat.Display.MovieClip.FrameAnimeClip;
import JCat.Display.Text.TextManager;
import JCat.Manager.TextureManager;
import Manager.ResourceType;
import Parser.SerializaParser;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class Parser {

	private Loader imageLoader;

	public Parser(Loader imageLoader) {
		this.imageLoader = imageLoader;
		// TODO Auto-generated constructor stub
	}

	public void parse(String path) {
		ArrayList<ResourceData> list = new SerializaParser(new File(path)).toList();
		for (ResourceData resourceData : list) {
			if(resourceData.type==ResourceType.TEXTURE)
			{
				Image image=(Image) resourceData.data;
				BufferedImage im=SwingFXUtils.fromFXImage(image, null);
				Texture texture=new Texture(im);
				TextureManager.getInstance().addToCache(texture, resourceData.name, false);
			}
			else if(resourceData.type==ResourceType.MOVIECLIP)
			{
				AnimeClip animeClip=(AnimeClip) resourceData.data;
				FrameAnimeClip frameAnimeClip=new FrameAnimeClip(animeClip.getName(),animeClip.getMaxFrame());
				for (Frame frame : animeClip.getFrames()) {
					Image image=(Image) frame.texture;
					BufferedImage im=SwingFXUtils.fromFXImage(image, null);
					Texture texture=new Texture(im);
					frameAnimeClip.insertFrame(frame.index, texture);
				}
				
				TextureManager.getInstance().addToCache(frameAnimeClip);
				
			}
		}
		
		
	}

}
