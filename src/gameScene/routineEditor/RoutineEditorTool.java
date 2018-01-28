package gameScene.routineEditor;

import display.Rectangle;
import routines.RoutineBuilder;

public abstract class RoutineEditorTool extends Node {
	public RoutineEditorTool(Rectangle rect,RoutineEditorView parent){
		super(rect,parent);
	}
	public abstract void DrawGhost();
	public abstract void OnClick(Node n);
	public abstract void OnClick();
	@Override
	public void DrawComponent(){
		DrawGhost();
	}
	
	
}
