package world;

import display.Menu;
import display.Rectangle;
import display.Toolbar;
import display.ButtonEventHandler;
import display.Color;
import display.Button;
import processing.core.PVector;

public class Outpost extends Building{

	public Outpost(long x, long y, World w) {
		super(x, y, w);
		// TODO Auto-generated constructor stub
		getRect().setWidth(20);
		getRect().setHeight(20);
	}

	@Override
	public Menu BuildMenu() {
		Menu m = new Menu(new Rectangle(800,800, 400,200),getScrollView().getParent());
		Outpost p = this;
		m.getComponents().add(new Button(new Rectangle(20,20,20,20),m,new ButtonEventHandler() {

			@Override
			public void OnClick() {
				// TODO Auto-generated method stub
		
				getParent().getComponents().remove(p);
				getWorld().getMap().getObjects().remove(p);
				m.getParent().getComponents().remove(m);
			}

			@Override
			public void OnEnter() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void OnLeave() {
				// TODO Auto-generated method stub
				
			}
			
			
		},"Delete",new Color(255,0,0),null));
		return m;
	}

	@Override
	public void DrawComponent() {
		getApplet().fill(255);
		Rectangle drawrect = GetDrawRectangle();
		getApplet().rect(drawrect.getX(),drawrect.getY(),drawrect.getWidth(),drawrect.getHeight());
	}

	

}
