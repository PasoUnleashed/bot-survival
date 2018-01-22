package gameScene;

import world.Map;

import display.RectView;
import display.Rectangle;
import display.UIComponent;
import processing.core.PApplet;

public class MapView extends UIComponent {
	long camx,camy;
	Map map;
	public MapView(Rectangle rect, RectView parent,Map map) {
		super(rect, parent);
		// TODO Auto-generated constructor stub
		camx=0;
		camy=0;
		this.map=map;
		
	}
	public void ScrollCamera(int x,int y) {
		camx+=x;
		camy+=y;
	}
	@Override
	public void Frame() {
		// TODO Auto-generated method stub
		int x=0;
		int y=0;
		int speed=10;
		if(keys['w']) {
			y-=speed;
		}
		if(keys['s']) {
			y+=speed;
		}
		if(keys['a']) {
			x-=speed;
		}
		if(keys['d']) {
			x+=speed;
		}
		ScrollCamera(x,y);
	}

	@Override
	public void DrawComponent() {
		// TODO Auto-generated method stub
		this.map.Draw(this,-camx+getRect().getWidth()/2,-camy+getRect().getHeight()/2);
	}
	

}
