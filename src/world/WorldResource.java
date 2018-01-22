package world;
import java.util.Random;

import display.RectView;
public class WorldResource extends WorldObject {
	data.ResourceType type;
	int health,maxHealth;
	boolean isDead;
	int respawnTimer;
	public WorldResource(long x,long y,World w,data.ResourceType type) {
		super(x,y,w);
		this.type=type;
		Random r = new Random();
		maxHealth =( type.getStartHealth()-type.getHealthDelta())+(r.nextInt(type.getHealthDelta()*2));
		health = maxHealth;
		isDead = false;
		
	}
	@Override
	public void Update() {
		
	}
	@Override
	public void Draw(RectView v,int x,int y) {
		// TODO Auto-generated method stub
		v.getApplet().fill(type.getColor().getR(),type.getColor().getG(),type.getColor().getB());
		v.getApplet().rect(x, y, rect.getWidth(), rect.getHeight());
	}
	
}
