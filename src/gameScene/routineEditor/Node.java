package gameScene.routineEditor;

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
	public Node(Rectangle rect, GridScrollView parent) {
		super(rect, parent);
		this.parent=(RoutineEditorView)parent;
		// TODO Auto-generated constructor stub
	}
	
}
