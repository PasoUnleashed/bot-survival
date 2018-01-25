
package world;
import gameScene.MapView;
import display.RectView;
import display.Rectangle;
import display.ScrollComponent;
import display.ScrollView;
import display.UIComponent;
import processing.core.PVector;

public abstract class WorldObject extends ScrollComponent{
	public boolean isSelected() {
		return this==((MapView)this.getParent()).getSelected();
	}
	public WorldObject(long x,long y,World w) {
		super(new Rectangle(x,y,5,5), null);
		this.world=w;
		// TODO Auto-generated constructor stub
	}
	protected boolean isCollider;
	protected World world;
	public boolean MousePressed() {
		if(!super.MousePressed()) {
			((MapView)this.getParent()).setSelected(this);
			return true;
		}
		return false;
	}@Override
	public void Draw() {
		getApplet().noStroke();
		super.Draw();
		if(this.isSelected()) {
			
			PVector pos = GetDrawPosition();
			if(pos!=null) {
				getApplet().fill(0,0,0,0);
				getApplet().stroke(0,188,188);
				getApplet().strokeWeight(2);
				getApplet().rect(pos.x,pos.y, getRect().getWidth(),getRect().getHeight());
			}
		}
		
	}
	public boolean isCollider() {
		return isCollider;
	}
	public World getWorld() {
		return world;
	}
	
}
