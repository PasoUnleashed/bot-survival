package gameScene.routineEditor;

import display.Color;
import display.GridComponent;
import display.GridScrollView;
import display.RectView;
import display.Rectangle;
import display.ScrollComponent;
import display.ScrollView;
import display.UIComponent;
import display.UIView;
import processing.core.PApplet;

public abstract class Node extends GridComponent {
	RoutineEditorView parent;
	String text;
	public Node(Rectangle rect, GridScrollView parent) {
		super(rect, parent);
		this.parent=(RoutineEditorView)parent;
		text="";
		// TODO Auto-generated constructor stub
	}
	protected abstract Color GetColor();
	@Override
	public void DrawComponent(){
		Rectangle rect = GetDrawRectangle();
		System.out.println(rect.getWidth()+","+rect.getHeight());
		getApplet().fill(GetColor().getR(),GetColor().getG(),GetColor().getB());
		getApplet().rect(rect.getX(),rect.getY(),rect.getWidth(),rect.getHeight());
	}
}
