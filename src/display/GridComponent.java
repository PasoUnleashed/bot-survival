package display;

public abstract class GridComponent extends ScrollComponent {
	GridScrollView parent;
	public GridComponent(Rectangle rect, GridScrollView parent) {
		super(rect, parent);
		this.parent=parent;
		// TODO Auto-generated constructor stub
	}
	@Override
	public Rectangle GetDrawRectangle() {
		Rectangle rect = parent.GetRectOnApplet(new Rectangle((getRect().getX()*parent.gridlength)-parent.getScrollx(),(getRect().getY()*parent.gridlength)-parent.getScrolly(),getRect().getWidth()*parent.gridlength,getRect().getHeight()*parent.gridlength));
		return rect;
	}

	

}
