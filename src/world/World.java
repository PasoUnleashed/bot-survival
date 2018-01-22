package world;

import java.util.ArrayList;

import bots.Bot;
import display.Rectangle;
import display.UIView;
import gameScene.MapView;

public class World {
	ArrayList<Bot> bots;
	Map map;
	MapView currentMapView;
	public Map getMap() {
		return map;
	}
	public World() {
		bots = new ArrayList<>();
		map = new Map(this,1000,1000);
	}
	public void SetCurrentView(MapView v) {
		currentMapView =v;
		v.getComponents().clear();
		for(WorldObject i : map.getObjects()) {
			i.SetView(v);
			v.getComponents().add(i);
		}
		
	}
	public void AddObject(WorldObject o) {
		o.SetView(currentMapView);
		map.getObjects().add(o);
		if(currentMapView!=null) {
			currentMapView.getComponents().add(o);
		}
	}
	public void RemoveObject(WorldObject o) {
		map.getObjects().remove(o);
		if(currentMapView!=null) {
			currentMapView.getComponents().remove(o);
		}
	}
}
