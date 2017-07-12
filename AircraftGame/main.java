package AircraftGame;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import AircraftGame.Util.Util;
import JGame.JGame;
import JGame.SwingStage;
import JGame.GameObject.EventDispatcher;

public class main {

	public static void main(String[] args) throws IOException {
		JGame jGame=new JGame(600,800,30);
		Aircraft aircraft=new Aircraft();
		aircraft.x=300;
		aircraft.y=600;
		aircraft.width=50;
		aircraft.height=50;
		aircraft.setImage(Util.LoadImg("aircraft.png"));
		jGame.addObject(aircraft);
		
		
		
	}
}
