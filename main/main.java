package main;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import JGame.JGame;
import JGame.GameObject.EventDispatcher;
import JGame.Render.SwingStage;

public class main {

	public static void main(String[] args) throws IOException {
		JGame jGame=new JGame(new SwingStage(600,800),5);
		Aircraft object=new Aircraft();
		object.setImage(ImageIO.read(new File("IMG\\img.png")));
		jGame.addObject(object);
		
		
		
	}
}
