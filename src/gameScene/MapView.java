package gameScene;

import world.Map;
import world.Outpost;
import world.WorldObject;
import display.RectView;
import display.Rectangle;
import display.ScrollView;
import display.UIComponent;
import display.UIView;
import processing.core.PApplet;
import processing.core.PVector;
import world.Circle;

public class MapView extends ScrollView {
	Map map;
	WorldObject selected;
	char modkey='-';
	public MapView(Rectangle rect, UIView parent,Map map) {
		super(rect, parent);
		// TODO Auto-generated constructor stub
		this.map=map;
		map.getWorld().SetCurrentView(this);
	}
	@Override
	public boolean MousePressed() {
		boolean child =super.MousePressed();
		if(!child) {
			if(modkey=='o') {
				map.getWorld().AddObject(new Outpost(mouseX,mouseY,map.getWorld()));
			}else if(modkey =='c'){
				map.getWorld().AddObject(new Circle(mouseX,mouseY,map.getWorld()));	
			}else {
				selected = null;
			}
			modkey='-';
		}
		
		return true;
	} 
	public WorldObject getSelected() {
		return selected;
	}
	public void setSelected(WorldObject object){
		selected=object;
	}
	
	@Override
	public void DrawComponent() {
		this.getApplet().fill(0);
		Rectangle drawrect = GetDrawRectangle();
		getApplet().rect(drawrect.getX(),drawrect.getY(),drawrect.getWidth(),drawrect.getHeight());
		getApplet().stroke(255);
	}
	@Override
	public void KeyPressed(char key) {
		modkey=key;
	}
	
	

}
