package display;

import java.util.ArrayList;
import java.util.Collections;

import processing.core.PApplet;
import processing.core.PVector;
/*
 * The UI
 */
public class UIView extends RectView{
	protected ArrayList<UIComponent> components;
	public UIView(Rectangle rect, PApplet applet) {
		super(rect, applet);
		// TODO Auto-generated constructor stub
		components = new ArrayList<UIComponent>();
	}
	@Override
	public void SetKeys(boolean[] keys,int x,int y) {
		super.SetKeys(keys, x, y);
		if(rect.IsInBound(x, y)) {
			mouseOver=true;
			
		}
		else {
			mouseOver=false;
		}
		ArrayList<UIComponent> components = new ArrayList<UIComponent>();
		components.addAll(this.components);
		for(UIComponent i : components) {
			i.SetKeys(keys, mouseX, mouseY);
		}
		
	}
	public ArrayList<UIComponent> getComponents() {
		return components;
	}
	public void MouseClick() {
		ArrayList<UIComponent> components = new ArrayList<UIComponent>();
		components.addAll(this.components);
		for(UIComponent i : components) {
			if(i.mouseOver&&i.isHidden()) {
				i.MouseClick();
				break;
			}
		}
	}
	@Override
	public boolean MousePressed() {
		ArrayList<UIComponent> components = new ArrayList<UIComponent>();
		components.addAll(this.components);
		boolean ret = false;
		for(UIComponent i : components) {
			if(i.mouseOver&&!i.isHidden()) {
				ret = ret||i.MousePressed();
				break;
			}
		}
		return ret;
	}
	public void AddComponent(UIComponent e) {
		components.add(e);
	}
	public void RemoveComponent(UIComponent e) {
		components.remove(e);
	}
	
	@Override
	public void MouseReleased() {
		ArrayList<UIComponent> components = new ArrayList<UIComponent>();
		components.addAll(this.components);
		for(UIComponent i :components) {
			if(!i.isHidden()&&i.mouseOver) {
				i.MouseReleased();
			}
		}
	}
	public void Frame() {
		ArrayList<UIComponent> components = new ArrayList<UIComponent>();
		components.addAll(this.components);
		for(UIComponent i : components) {
			if(!i.isHidden()) {
				i.Frame();
			}
		}
		
	}
	public void KeyPressed(char key) {
		ArrayList<UIComponent> components = new ArrayList<UIComponent>();
		components.addAll(this.components);
		for(UIComponent i : components) {
			if(!i.isHidden()) {
				i.KeyPressed(key);
			}
		}
	}
	public void KeyReleased(char key) {
		ArrayList<UIComponent> components = new ArrayList<UIComponent>();
		components.addAll(this.components);
		for(UIComponent i : components) {
			if(!i.isHidden()) {
				i.KeyReleased(key);
			}
		}
	}
	public void Draw() {
		ArrayList<UIComponent> components = new ArrayList<UIComponent>();
		components.addAll(this.components);
		DrawComponent();
		for(int i=components.size()-1;i>=0;i--) {
			if(!components.get(i).isHidden()) {
				components.get(i).Draw();
			}
		}
	}
	public void setComponents(ArrayList<UIComponent> components) {
		this.components = components;
	}
	public void DrawComponent() {
		Rectangle drawrect = this.GetDrawRectangle();
		this.applet.fill(255);
		this.applet.rect(drawrect.x,drawrect.y,drawrect.width,drawrect.height);
		
		
	}

}
