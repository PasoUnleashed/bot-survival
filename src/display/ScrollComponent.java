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
	public boolean IsInView() {
		long drawx = this.rect.getX()-scrollView.getScrollx();
		long drawy = this.rect.getY()-scrollView.getScrolly();
		if(new Rectangle(0,0,parent.getRect().width,parent.getRect().height).Contains(new Rectangle(drawx,drawy,rect.width,rect.height))) {
			return true;
		}
		return false;
	}
	@Override 
	public PVector GetDrawPosition() {
		if(IsInView()) {
			long drawx = this.rect.getX()-scrollView.getScrollx();
			long drawy = this.rect.getY()-scrollView.getScrolly();
			return parent.GetPosOnApplet(drawx, drawy);
		}
		return null;
		
	}
	@Override 
	public void Draw() {
		
		PVector drawPos = GetDrawPosition();
		if(drawPos!=null) {
			super.Draw();	
		}else {
		}
	}
	

}
