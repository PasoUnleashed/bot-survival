package display;
/*
* A component of GridView, the difference is that the size and location of the component's rectangle are to be in "square" units. each unit spans one square of the grid.
*
*/
public abstract class GridComponent extends ScrollComponent {
	GridScrollView parent;
	public GridComponent(Rectangle rect, GridScrollView parent) {
		super(rect, parent);
		System.out.print(rect.width+" "+rect.height);
		this.parent=parent;
		// TODO Auto-generated constructor stub
	}
	/*
	* Adjusts from units to pixles
	*/
	@Override
	public Rectangle GetDrawRectangle() {
		Rectangle rect = parent.GetRectOnApplet(new Rectangle((getRect().getX()*parent.gridlength)-parent.getScrollx(),(getRect().getY()*parent.gridlength)-parent.getScrolly(),getRect().getWidth()*parent.gridlength,getRect().getHeight()*parent.gridlength));
		return rect;
	}
	@Override
	public Rectangle GetRectOnApplet(Rectangle rect){
		Rectangle mrect = GetDrawRectangle();
		return new Rectangle(mrect.x+rect.x, rect.y+mrect.y,rect.width,rect.height);
	}
	@Override
	public boolean IsInView() {
		return parent.GetDrawRectangle().Contains(GetDrawRectangle());
	}
	@Override
	public void SetKeys(boolean[] keys,int x,int y){
		super.SetKeys(keys, x, y);
		Rectangle drect = GetDrawRectangle();
		x=applet.mouseX-(int)drect.x;
		y=applet.mouseY-(int)drect.y;
		for(UIComponent i : this.components){
			i.SetKeys(keys, x, y);
		}
	}

}
