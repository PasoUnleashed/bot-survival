package world;
import java.util.ArrayList;
import display.RectView;
import display.Rectangle;
import display.ScrollView;
import display.UIView;
import gameScene.MapView;
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
	public void Frame() {
		for(WorldObject o : objects) {
			o.Frame();
		}
		
	}
	
	public ArrayList<WorldObject> getObjects() {
		return objects;
	}
}
