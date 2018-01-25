package world;

import display.Menu;
import display.Toolbar;
import display.UIView;

public abstract class Building extends WorldObject{
	Menu menu;
	public Building(long x, long y, World w) {
		super(x, y, w);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void SetView(UIView v) {
		super.SetView(v);
		menu = BuildMenu();
		this.getScrollView().getParent().getComponents().add(0,menu);
	}
	@Override
	public void Frame() {
		super.Frame();
		if(this.isSelected()) {
			menu.Show();
		}else {
			menu.Hide();
		}
	}

	public abstract Menu BuildMenu();
}
