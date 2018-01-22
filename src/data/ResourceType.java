package data;

import display.Color;
import gameScene.MapView;
import world.World;

public class ResourceType{
	String name;
	public Items.ItemType getItem() {
		return item;
	}
	public void setItem(Items.ItemType item) {
		this.item = item;
	}
	public int getGiveout() {
		return giveout;
	}
	public void setGiveout(int giveout) {
		this.giveout = giveout;
	}
	public String getName() {
		return name;
	}
	public Color getColor() {
		return color;
	}
	public int getStartHealth() {
		return startHealth;
	}
	public int getHealthDelta() {
		return healthDelta;
	}
	public int getRespawnTime() {
		return respawnTime;
	}
	Color color;
	Items.ItemType item;
	int giveout,startHealth,healthDelta;
	int respawnTime;
	public ResourceType(String name, Color color, Items.ItemType type,int giveout,int starthealth,int healthdelta,int respawntime) {
		this.name=name;
		this.color=color;
		this.item=type;
		this.giveout=giveout;
		this.startHealth=starthealth;
		this.healthDelta=healthdelta;
		this.respawnTime = respawntime;
	}
	public world.WorldResource Create(long x,long y,World w){
		return new world.WorldResource(x, y,this,w);
	}
}