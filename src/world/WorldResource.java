package world;
import java.util.Random;

import data.ResourceType;
import display.RectView;
import display.Rectangle;
import display.ScrollView;
import processing.core.PVector;
public class WorldResource extends WorldObject {
	data.ResourceType type;
	int health,maxHealth;
	boolean isDead;
	int respawnTimer;
	public WorldResource(long x,long y,ResourceType type,World w) {
		super(x,y, w);
		this.type=type;
		Random r = new Random();
		maxHealth =( type.getStartHealth()-type.getHealthDelta())+(r.nextInt(type.getHealthDelta()*2));
		health = maxHealth;
		isDead = false;
	}
	@Override
	public void Frame() {
		super.Frame();
		if(isMouseOver()) {
			System.out.println("mouse");
		}
	}
	@Override
	public void Draw() {
		// TODO Auto-generated method stub
		super.Draw();
		
	}
	@Override
	public void DrawComponent() {
		// TODO Auto-generated method stub
		PVector pos = GetDrawPosition();
		getApplet().fill(type.getColor().getR(),type.getColor().getG(),type.getColor().getB());
		getApplet().rect(pos.x,pos.y,getRect().getWidth(), getRect().getHeight());
	}
	
}
