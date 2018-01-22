package display;
import processing.core.PApplet;
import processing.core.PVector;
/*
 * A RectView is a drawing surface that is bound by a rectangle, its use is to allow easy scene handling, 
 * UI implementation and clearer code overall.
 */
public abstract class RectView {
	Rectangle rect;
	boolean mouseOver=false;
	int mouseX=-1,mouseY=-1;
	PApplet applet;
	protected boolean[] keys = new boolean[255];
	public PApplet getApplet() {
		return applet;
	}
	/*
	 * @param rect The rectangle that bounds the view
	 * @param applet The applet the view is drawn on
	 */
	public RectView(Rectangle rect,PApplet applet) {
		this.rect=rect;
		this.applet=applet;
	}
	/*
	 * This abstract function is invoked once every frame, in it all the class calculations and handling
	 * should be implemented
	 */
	public abstract void Frame();
	/*
	 * This abstract function is invoked once every frame after the Frame() function and should handle drawing
	 * the view on the applet
	 */
	public abstract void Draw();
	/*
	 * This function occurs once every frame before either abstract functions. It updates the view's information about
	 * the current pressed keys, and it updates the view on the mouse's relative location
	 * within it's bounds
	 */
	public void SetKeys(boolean[] keys,int mouseX,int mouseY) {
		this.keys=keys;
		this.mouseX = (int) (mouseX-this.rect.getX());
		this.mouseY = (int) (mouseY-this.rect.getY());
		if(!rect.IsInBound(mouseX, mouseY)) {
			if(mouseOver) {
				MouseLeave();
			}
			this.mouseOver=false;
			
		}else {
			if(!mouseOver) {
				MouseEnter();
			}
			this.mouseOver=true;
		}
		
	}
	/*
	 * This function returns a position adjusted to be drawn on the applet. Example:
	 * let's consider a view that is bound by the rectangle (10,10,50,50) and an element inside the view located at (10,30)
	 * if the element is to be drawn on the applet it has to be drawn at the position (20,40)
	 * since the (0,0) position of the view lies at the position (10,10) in the applet
	 */
	public PVector GetPosOnApplet(float x,float y) {
		return new PVector(this.rect.getX()+x,this.rect.getY()+y);
	}
	public Rectangle getRect() {
		return rect;
	}
	public void setRect(Rectangle r) {
		rect=r;
	}
	
	public void MouseEnter() {
		this.mouseOver=true;
	}
	public void MouseLeave() {
		this.mouseOver=false;
	}
	/*
	 * These empty functions are invoked whenever their appropriate event occurs, 
	 * but are empty so that child classes can chose not to implement them.
	 */
	
	
	
	public void OnStart() {
		
	}
	public void OnOpen() {
		
	}
	public void OnClosing() {
		
	}
	public void OnClose() {
		
	}
	
	public void MouseClick() {
		
	}
	public void MouseStartDragging() {
		
	}
	public void MouseEndDragging() {
		
	}
	public void MouseCancelDragging() {
		
	}
	public void RightClick() {
		
	}
	public void MousePressed() {
		
	}
	public void MouseReleased() {
		
	}
	
	
}
