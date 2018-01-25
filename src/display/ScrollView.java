package display;

import java.util.ArrayList;

import processing.core.PApplet;

public abstract class ScrollView extends UIComponent{
	int scrollx,scrolly;
	int rm_x,rm_y;
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
	@Override
	public void SetKeys(boolean[] keys,int x,int y) {
		super.SetKeys(keys, x+scrollx, y+scrolly);
		if(rect.IsInBound(x, y)) {
			mouseOver=true;
			
		}
		else {
			mouseOver=false;
		}
		ArrayList<UIComponent> components = new ArrayList<UIComponent>();
		components.addAll(this.components);
		for(UIComponent i : components) {
			if(ScrollComponent.class.isAssignableFrom(i.getClass())) {
				i.SetKeys(keys, mouseX, mouseY);
			}else {
				i.SetKeys(keys, getLmouseX(), getLmouseY());
			}
			
		}
		
	}
	public int getLmouseX() {
		return mouseX-scrollx;
	}
	public int getLmouseY() {
		return mouseY-scrolly;
	}


}
