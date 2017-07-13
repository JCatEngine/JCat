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
		//为什么我这个引擎要显式添加对象而类似AS3的却不用呢,因为AS3估计默认了有些类是单例
		//因此他一个进程只能运行一个游戏，这个引擎虽然要显式添加 
		//不过却有一个进程同时运行多个游戏的能力
		JGame jGame=new JGame(600,800,30);
		Aircraft aircraft=new Aircraft();
		aircraft.x=300;
		aircraft.y=600;
		aircraft.width=50;
		aircraft.height=50;
		aircraft.setImage(Util.LoadImg("aircraft.png"));
		jGame.addObject(aircraft);
		
		//添加到顶层渲染中 这和上面的add不一样 上面的只是为了一种资源绑定关系
		//而也不是所有的对象都在顶层渲染中 
		jGame.addToRoot(aircraft);
		
		
		Aircraft aircraft2=new Aircraft();
		aircraft2.x=0;
		aircraft2.y=-50;
		aircraft2.width=50;
		aircraft2.height=50;
		aircraft2.setImage(Util.LoadImg("aircraft.png"));
		aircraft.addChild(aircraft2);
	}
}
