package gameScene.routineEditor;

import display.Rectangle;
import routines.RoutineBuilder;

public abstract class RoutineEditorTool extends Node {
	public RoutineEditorTool(Rectangle rect,RoutineEditorView parent){
		super(rect,parent);
	}
	public abstract void DrawGhost();
	public abstract boolean OnClick();
	@Override
	public void DrawComponent(){
		DrawGhost();
	}
	@Override
	public boolean MousePressed() {
		return OnClick();
		
	}
	
	
}
