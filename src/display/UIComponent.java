package display;

import processing.core.PApplet;
import processing.core.PVector;
/*
 * A UI Component is a RectView that can be drawn on a UIView 
 */
public abstract class UIComponent extends UIView{
	RectView parent;
	boolean hidden;
	public UIComponent(Rectangle rect,RectView parent) {
		super(rect, parent.applet);
		// TODO Auto-generated constructor stub
		this.parent=parent;
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
	public PVector GetPosOnApplet(float x,float y) {
		PVector pos =new PVector(this.rect.getX()+x,this.rect.getY()+y);
		return parent.GetPosOnApplet(pos.x, pos.y);
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
	
	public abstract void DrawComponent();
}
