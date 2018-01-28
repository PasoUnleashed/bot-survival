package display;

import processing.core.PVector;

public abstract class ScrollComponent extends UIComponent {
	ScrollView scrollView;
	
	public ScrollComponent(Rectangle rect, ScrollView parent) {
		super(rect, parent);
		scrollView=parent;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void SetView(UIView view) {
		this.parent=this.scrollView=(ScrollView)view;
		this.applet=view.applet;
	}
	public ScrollView getScrollView() {
		return scrollView;
	}
	public void setScrollView(ScrollView scrollView) {
		this.scrollView = scrollView;
	}
	public boolean IsInView() {
		return parent.GetDrawRectangle().Contains(GetDrawRectangle());
	}
	@Override 
	public Rectangle GetDrawRectangle() {
		long drawx = this.rect.getX()-scrollView.getScrollx();
		long drawy = this.rect.getY()-scrollView.getScrolly();
		return parent.GetRectOnApplet(new Rectangle(drawx,drawy,getRect().width,getRect().height));
		
	}
	@Override 
	public void Draw() {
		
		Rectangle drawrect = GetDrawRectangle();
		if(IsInView()) {
			super.Draw();	
		}else {
			
		}
	}

	

}
