package JGame.Render;

import javax.swing.JFrame;

import JGame.GameObject.DisplayObject;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class SwingStage extends JFrame implements GameStage{
	private JPanel panel;
	private int planeWidth;
	private int planeHeight;

	public SwingStage(int width, int height) {
		
		planeWidth = width;
		planeHeight = height;
		setSize(width,height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 160, 10);
		panel.setSize(width,height);
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

}
