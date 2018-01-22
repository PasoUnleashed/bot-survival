
package world;

import display.RectView;
import display.Rectangle;
import display.ScrollComponent;
import display.ScrollView;

public abstract class WorldObject extends ScrollComponent{
	public WorldObject(long x,long y,World w) {
		super(new Rectangle(x,y,5,5), null);
		this.world=w;
		// TODO Auto-generated constructor stub
	}
	protected boolean isCollider;
	protected World world;
	
	public boolean isCollider() {
		return isCollider;
	}
	public World getWorld() {
		return world;
	}
	
}
