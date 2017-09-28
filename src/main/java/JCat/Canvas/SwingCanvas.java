package JCat.Canvas;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import JCat.Display.Calculation.Transform;
import JCat.Interaction.CanvasKeyEvent;
import JCat.Interaction.CanvasKeyListener;
import JCat.Interaction.CanvasMouseEvent;
import JCat.Interaction.CanvasMouseListener;
import JCat.Render.RenderData;
import JCat.Textures.Texture;

public class SwingCanvas extends JFrame  implements Canvas{

	private JPanel panel;
	private int width;
	private int height;
	
	/**
	 * cache image,the texture first draw on it,finally it's be draw to screen
	 */
	private BufferedImage cache;
	private CanvasKeyListener canvaskeylistener;
	private CanvasMouseListener canvasmouselistener;
	
	
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
		
		addListeners();
	}

	/**
	 * 
	 */
	private void addListeners() {
		
		panel.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				canvaskeylistener.keyUp(createKeyEvent(e));
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
				canvaskeylistener.keyDown(createKeyEvent(e));
				
			}
		});
		
		
		panel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				canvasmouselistener.mouseUp(createMouseEvent(e));
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				canvasmouselistener.mouseDown(createMouseEvent(e));
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

	/**
	 * convert swing mouse event to Jcat mouse event
	 * @param e
	 * @return
	 */
	protected CanvasMouseEvent createMouseEvent(MouseEvent e) {
		
		CanvasMouseEvent canvasMouseEvent=new CanvasMouseEvent();
		canvasMouseEvent.x=e.getX();
		canvasMouseEvent.y=e.getY();
		
		
		return canvasMouseEvent;
	}

	
	/**
	 * convert swing key event to Jcat key event
	 * @param e
	 * @return
	 */
	protected CanvasKeyEvent createKeyEvent(KeyEvent e) {
		
		CanvasKeyEvent canvasKeyEvent=new CanvasKeyEvent();
		canvasKeyEvent.keycode=e.getKeyCode();

		return canvasKeyEvent;
	}

	@Override
	public void drawTexture(Texture texture, RenderData renderData) {
		
		
		Image image=texture.getImage();
		
		Transform transform=renderData.transform;
		
		int x=(int) transform.x;
		int y=(int) transform.y;
		
		double scaleX=transform.scaleX;
		double scaleY=transform.scaleY;
		
		double alpha=renderData.alpha;
		
		int width=(int) (image.getWidth(null)*scaleX);
		int height=(int) (image.getHeight(null)*scaleY);
		
		double radins= (transform.rotation/180*Math.PI);
		
		Graphics2D graphics2d=cache.createGraphics();
		
		
		//set graphics to left-top corner of bitmap
		graphics2d.translate(x, y);
		graphics2d.rotate(radins);
		graphics2d.translate(-x, -y);
		
		AlphaComposite alphaComposite=AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float) alpha);
		graphics2d.setComposite(alphaComposite);
		graphics2d.drawImage(image, x, y,width,height, null);
		
	
		
		
	}

	@Override
	public void preRender() {
		
		cache.getGraphics().clearRect(0, 0, width, height);
		
	}

	@Override
	public void postRender() {

		panel.getGraphics().drawImage(cache, 0, 0, width,height, null);
		
	}

	@Override
	public void addMouseListener(CanvasMouseListener listener) {
		
		this.canvasmouselistener=listener;
		
	}

	@Override
	public void addKeyListener(CanvasKeyListener listener) {
		
		this.canvaskeylistener=listener;
		
	}

}
