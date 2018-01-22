package world;

import java.util.ArrayList;

import bots.Bot;

public class World {
	ArrayList<Bot> bots;
	Map map;
	public Map getMap() {
		return map;
	}
	public World() {
		bots = new ArrayList<>();
		map = new Map(this,1000,1000);
	}
	public void Update(boolean[] keys) {
		map.Update(keys);
	}
	
	
}
