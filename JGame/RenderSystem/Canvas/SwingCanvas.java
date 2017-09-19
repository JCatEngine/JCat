package JGame.RenderSystem.Canvas;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import JGame.RenderSystem.Display.Calculation.Transform;
import JGame.RenderSystem.Textures.Texture;

public class SwingCanvas extends JFrame  implements Canvas{

	private JPanel panel;
	private int width;
	private int height;
	
	/**
	 * cache image,the texture first draw on it,finally it's be draw to screen
	 */
	private BufferedImage cache;
	
	
	public SwingCanvas(int width, int height) {
	
		cache=new BufferedImage(width, height, 1);
		
		this.width = width;
		this.height = height;
		
		setSize(width,height);
				
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 160, 10);
		//set plane
		panel.setSize(width,height);
		panel.setFocusable(true);
		
		
		getContentPane().add(panel);
		setVisible(true);
	}

	@Override
	public void drawTexture(Texture texture, Transform transform) {
		
		Image image=texture.getImage();
		
		int x=transform.getX();
		int y=transform.getY();
		
		double scaleX=transform.getScaleX();
		double scaleY=transform.getScaleY();
		
		int width=(int) (image.getWidth(null)*scaleX);
		int height=(int) (image.getHeight(null)*scaleY);
		
	
		cache.getGraphics().drawImage(image, x, y,width,height, null);
		
	}

	@Override
	public void preRender() {
		
		cache.getGraphics().clearRect(0, 0, width, height);
		
	}

	@Override
	public void postRender() {

		panel.getGraphics().drawImage(cache, 0, 0, width,height, null);
		
	}

}
