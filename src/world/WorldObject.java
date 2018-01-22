
package world;

import display.RectView;
import display.Rectangle;

public abstract class WorldObject {
	protected Rectangle rect;
	protected boolean isCollider;
	protected World world;
	public WorldObject(long x,long y,World w) {
		world=w;
		rect = new Rectangle(x,y,5,5);
		
	}
	public Rectangle getRect() {
		return rect;
	}
	public boolean isCollider() {
		return isCollider;
	}
	public World getWorld() {
		return world;
	}
	public WorldObject() {
		
	}
	public void Update() {
		
	}
	public abstract void Draw(RectView v,int x,int y);
	public void Update(boolean[] keys) {
		// TODO Auto-generated method stub
		Update();
	}

}
