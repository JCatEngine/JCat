package JGame;

import javax.swing.JFrame;

import JGame.GameObject.DisplayObject;
import JGame.Manager.InputManager.InputManager;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

/**
 * 默认实现的舞台 使用swing框架进行渲染
 * @author Administrator
 *
 */
public class SwingStage extends JFrame implements GameStage{
	private JPanel panel;
	private int planeWidth;
	private int planeHeight;
	private InputManager manager;

	
	
	public SwingStage(int width, int height) {
		
		//设置主窗口大小
		planeWidth = width;
		planeHeight = height;
		setSize(width,height);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 160, 10);
		//设置大小
		panel.setSize(width,height);
		panel.setFocusable(true);
		//收集初始输入
		panel.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				//设置为弹起
				manager.RawInput(e.getKeyCode(), false);
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				//设置为按下
				manager.RawInput(e.getKeyCode(), true);
			}
		});
		
		
		getContentPane().add(panel);
		setVisible(true);
	}

	@Override
	public void render(DisplayObject d) {
		
		if(d.getImage()!=null)
		{
			panel.getGraphics().drawImage(d.getImage(), d.x, d.y, d.width,d.height, null);
			
		}
		
	}

	@Override
	public void clear() {
		panel.getGraphics().clearRect(0, 0, planeWidth, planeHeight);
	}

	@Override
	public void setInputManager(InputManager manager) {
		this.manager = manager;
		// TODO Auto-generated method stub
		
	}

	


}
