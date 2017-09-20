package JGame.RenderSystem.Canvas;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import JGame.RenderSystem.Display.Calculation.Transform;
import JGame.RenderSystem.Render.RenderData;
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
	public void drawTexture(Texture texture, RenderData renderData) {
		
		
		Image image=texture.getImage();
		
		Transform transform=renderData.transform;
		
		int x=transform.x;
		int y=transform.y;
		
		double scaleX=transform.scaleX;
		double scaleY=transform.scaleY;
		
		float alpha=renderData.alpha;
		
		int width=(int) (image.getWidth(null)*scaleX);
		int height=(int) (image.getHeight(null)*scaleY);
		
		float radins=(float) (transform.rotation/180*Math.PI);
		
		Graphics2D graphics2d=cache.createGraphics();
		
		
		//set graphics to left-top corner of bitmap
		graphics2d.translate(x, y);
		graphics2d.rotate(radins);
		
		AlphaComposite alphaComposite=AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha);
		graphics2d.setComposite(alphaComposite);
		graphics2d.drawImage(image, 0, 0,width,height, null);
		
	
		
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
