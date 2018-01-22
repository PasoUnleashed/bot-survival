package display;

import processing.core.PApplet;

public abstract class ScrollView extends UIComponent{
	int scrollx,scrolly;
	public ScrollView(Rectangle rect, UIView parent) {
		super(rect, parent);
		// TODO Auto-generated constructor stub
	}
	public void Frame() {
		super.Frame();
		int x=0;
		int y=0;
		int speed=3;
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
		scrollx+=x;
		scrolly+=y;
	}
	public int getScrollx() {
		return scrollx;
	}
	public int getScrolly() {
		return scrolly;
	}


}
