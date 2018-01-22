package gameScene;

import world.Map;
import world.WorldObject;
import display.RectView;
import display.Rectangle;
import display.ScrollView;
import display.UIComponent;
import display.UIView;
import processing.core.PApplet;
import processing.core.PVector;

public class MapView extends ScrollView {
	Map map;
	public MapView(Rectangle rect, UIView parent,Map map) {
		super(rect, parent);
		// TODO Auto-generated constructor stub
		this.map=map;
		map.getWorld().SetCurrentView(this);
	}
	@Override
	public boolean MousePressed() {
		if(!super.MousePressed()) {
			map.getWorld().AddObject(data.Resources.Food.Create(mouseX, mouseY,map.getWorld()));
		}	
		return true;
	}
	@Override
	public void DrawComponent() {
		this.getApplet().fill(0);
		PVector pos = GetPosOnApplet(0,0);
		getApplet().rect(pos.x,pos.y,getRect().getWidth(),getRect().getHeight());
	}
	
	

}
