package JCat.Canvas;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import JCat.Display.Texture;
import JCat.Display.Text.FontStyle;
import JCat.Graphics.ColorTool;
import JCat.Interaction.CanvasKeyEvent;
import JCat.Interaction.CanvasKeyListener;
import JCat.Interaction.CanvasMouseEvent;
import JCat.Interaction.CanvasMouseListener;
import JCat.Render.RenderData.ShapeRenderData;
import JCat.Render.RenderData.TextRenderData;
import JCat.Render.RenderData.TextureRenderData;

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
	private Graphics2D graphics;
	
	
	public SwingCanvas(int width, int height) {
	
		cache=new BufferedImage(width, height, 1);
		graphics=cache.createGraphics();
		
		this.width = width;
		this.height = height;
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setPreferredSize(new Dimension(width, height));
		
		panel = new JPanel();
		//set plane
		panel.setSize(width,height);
		panel.setFocusable(true);
		
		getContentPane().add(panel);
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		
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
	public void drawTexture(Texture texture, TextureRenderData renderData) {


		
		Image image=texture.getImage();
		double alpha=renderData.alpha;
		int width=(int) renderData.width;
		int height=(int) renderData.height;
		int x=(int) renderData.x;
		int y=(int) renderData.y;
		
		
		
		AlphaComposite alphaComposite=AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float) alpha);
		graphics.setComposite(alphaComposite);
		graphics.drawImage(image, x, y,width,height, null);

		
		
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

	@Override
	public void drawDefaultBackground(JCat.Graphics.Color color) {
		
		graphics.setColor(ColorTool.toSwingColor(color));
		graphics.fillRect(0, 0, width, height);
		
	}

	@Override
	public void translate(double x, double y) {
		graphics.translate(x, y);
		
	}

	@Override
	public void rotate(double radian) {
		graphics.rotate(radian);
		
	}

	@Override
	public void drawText(String text, TextRenderData renderData) {
		
		
		double alpha=renderData.alpha;
		int style = convertFontStyle(renderData.style);
		double size=renderData.size;
		Color color=ColorTool.toSwingColor(renderData.color);
		int x=(int) renderData.x;
		int y=(int) renderData.y;
		
		//the stupid swint that will draw your String using y as the bottom line
		//to make it work right,you need to add height of text
		int realY=(int) (y+renderData.height);
		
		Font font=new Font(renderData.fontName, style, (int) size);
		graphics.setFont(font);
		graphics.setColor(color);

		
		AlphaComposite alphaComposite=AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float) alpha);
		graphics.setComposite(alphaComposite);
		graphics.drawString(text, x, realY);
		
		
		
	}

	

	@Override
	public double getStringWidth(String text, double fontSize, FontStyle style, String fontName) {
		
		//just for calculation of text width and height
		 applyTempFontSet(fontSize,style,fontName);
		 FontMetrics fontMetrics = graphics.getFontMetrics();

		 int width = fontMetrics.stringWidth(text);
		 
		
		 
		return width;
	}

	private int convertFontStyle(FontStyle style) {
		int result=0;
		
		switch (style) {
		case BOLD:
			result=Font.BOLD;
			break;
		case ITALIC:
			result=Font.ITALIC;
			break;
		case PLAIN:
			result=Font.PLAIN;
			break;
		default:
			throw new RuntimeException("unsupported text style:"+style);
		}
		
		return  result;
	}

	private void applyTempFontSet(double fontSize, FontStyle style, String fontName) {
		Font font=new Font(fontName, convertFontStyle(style), (int)fontSize);
		graphics.setFont(font);
		
	}

	@Override
	public double getStringHeight(String text, double fontSize, FontStyle style, String fontName) {
		applyTempFontSet(fontSize,style,fontName);
		FontMetrics fontMetrics = graphics.getFontMetrics();

		int height = fontMetrics.getAscent()-fontMetrics.getDescent();
		 
		return height;
	}

	@Override
	public void drawLine(ShapeRenderData renderData) {
		graphics.setColor(ColorTool.toSwingColor(renderData.color));
		int x1=(int) renderData.x1;
		int x2=(int) (x1+renderData.width);
		int y1=(int) renderData.y1;
		int y2=(int) (y1+renderData.height);
		
		graphics.drawLine(x1, y1, x2, y2);
	}

	@Override
	public void drawRect(ShapeRenderData renderData) {
		graphics.setColor(ColorTool.toSwingColor(renderData.color));
		
		int x=(int) renderData.x1;
		int y=(int) renderData.y1;
		int width=(int) renderData.width;
		int height=(int) renderData.height;
		
		graphics.drawRect(x, y, width, height);
		
	}

	@Override
	public void drawCircle(ShapeRenderData renderData) {
		graphics.setColor(ColorTool.toSwingColor(renderData.color));
		
		int x=(int) renderData.x1;
		int y=(int) renderData.y1;
		int width=(int) renderData.width;
		int height=(int) renderData.height;
		
		graphics.drawOval(x, y, width, height);
		
	}

}
