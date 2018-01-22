package gameScene.routineEditor;

import display.*;
import processing.core.PApplet;
import routines.RoutineBuilder;

public class RoutineEditorToolbar extends display.Toolbar {
	RoutineBuilder builder;
	public RoutineEditorToolbar(Rectangle rect, UIView parent,RoutineBuilder b) {
		super(rect, parent);
		// TODO Auto-generated constructor stub
		this.builder=b;
		AddButtonColumn();
		AddButtonColumn();
		AddButton(0,"Hello",new Color(0,140,255), null);
	}
	
}
