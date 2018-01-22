package display;

import java.util.ArrayList;

import processing.core.PApplet;
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
			if(i.mouseOver) {
				i.MouseClick();
			}
		}
	}
	@Override
	public void MousePressed() {
		ArrayList<UIComponent> components = new ArrayList<UIComponent>();
		components.addAll(this.components);
		for(UIComponent i : components) {
			if(i.mouseOver)
				i.MousePressed();
		}
	}
	@Override
	public void MouseReleased() {
		ArrayList<UIComponent> components = new ArrayList<UIComponent>();
		components.addAll(this.components);
		for(UIComponent i : components) {
			if(i.mouseOver)
				i.MouseReleased();
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
	
	public void Draw() {
		ArrayList<UIComponent> components = new ArrayList<UIComponent>();
		components.addAll(this.components);
		DrawComponent();
		for(UIComponent i : components) {
			if(!i.isHidden()) {
				i.Draw();
			}
		}
	}
	public void setComponents(ArrayList<UIComponent> components) {
		this.components = components;
	}
	public void DrawComponent() {
		
	}

}
