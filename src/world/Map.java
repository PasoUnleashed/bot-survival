package world;
import java.util.ArrayList;
import display.RectView;
import processing.core.PVector;
public class Map {
	ArrayList<WorldObject> objects;
	long max_x,min_x,max_y,min_y;
	World world;
	public Map(World w,int width,int height) {
		min_x=0;
		min_y=0;
		max_x=width;
		max_y=height;
		world=w;
		objects=new ArrayList<>();
	}
	public long getMax_x() {
		return max_x;
	}
	public long getMin_x() {
		return min_x;
	}
	public long getMax_y() {
		return max_y;
	}
	public long getMin_y() {
		return min_y;
	}
	public World getWorld() {
		return world;
	}
	public void Update() {
		for(WorldObject o : objects) {
			o.Update();
		}
		
	}
	public void Update(boolean[] keys) {
		for(WorldObject o : objects) {
			o.Update(keys);
		}
		
	}
	public void Draw(RectView v,long cameraX,long cameraY) {
		long xoffset = -cameraX-v.getRect().getWidth()/2;
		long yoffset = -cameraY-v.getRect().getHeight()/2;
		v.getApplet().fill(0);
		v.getApplet().rect(v.getRect().getX(), v.getRect().getY(),v.getRect().getWidth(),v.getRect().getHeight());
		for(WorldObject o : objects) {		
			
				PVector pos = v.GetPosOnApplet(o.rect.getX()-xoffset, o.rect.getY()-yoffset);
			if(v.getRect().IsInBound((int)pos.x,(int)pos.y)) {
				o.Draw(v,(int)pos.x,(int)pos.y);
			}
			
		}
	}
	public ArrayList<WorldObject> getObjects() {
		return objects;
	}
}
