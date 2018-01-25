package display;

import processing.core.PApplet;
import processing.core.PVector;
/*
 * A UI Component is a RectView that can be drawn on a UIView 
 */
public abstract class UIComponent extends UIView{
	UIView parent;
	boolean hidden=false;
	public UIComponent(Rectangle rect,UIView parent) {
		super(rect, null);
		// TODO Auto-generated constructor stub
		this.parent=parent;
		if(parent!=null) {
			applet=parent.applet;
		}
	}
	/*
	 * (non-Javadoc)
	 * @see display.RectView#GetPosOnApplet(float, float)
	 * Since the UIComponent is a RectView within a RectView, The final location of the component is no longer relative to the applet
	 * but relative to it's parent's location on it's respective parent, be it the applet or another RectView,
	 * therefore the function is overridden for any RectView that can have a parent so that it recursively traverses a component's 
	 * parent tree to determine the final location of the component on the applet.
	 * 
	 */
	@Override
	public Rectangle GetRectOnApplet(Rectangle rect) {
		Rectangle pos =new Rectangle(this.rect.getX()+rect.x,this.rect.getY()+rect.y,rect.height,rect.width);
		return parent.GetRectOnApplet(pos);
	}
	public UIView getParent() {
		return parent;
	}
	public boolean isHidden() {
		return hidden;
	}
	@Override
	public void Frame() {
		super.Frame();
	}
	public void Show() {
		hidden=false;
	}
	public void Hide() {
		hidden=true;
	}
	public void SetView(UIView view) {
		this.parent=view;
		this.applet=view.applet;
	}
	public Rectangle GetDrawRectangle() {
		return parent.GetRectOnApplet(rect);
		
	}
	public abstract void DrawComponent();
}
