package display;

import processing.core.PVector;

public class Menu extends UIComponent{

	public Menu(Rectangle rect, UIView parent) {
		super(rect, parent);
		// TODO Auto-generated constructor stub
	}
	public void AddComponent(UIComponent component,int row,int column) {
		
	}
	@Override
	public void DrawComponent() {
		// TODO Auto-generated method stub
		getApplet().fill(188);
		Rectangle drawrect = GetDrawRectangle();
		getApplet().rect(drawrect.x,drawrect.y,drawrect.width,drawrect.height);
	}
	
	class MenuComponent{
		UIComponent component;
		int row,column;
		
	}
}
