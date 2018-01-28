package gameScene.routineEditor;

import display.Color;
import display.Rectangle;
import routines.routineExecution.Variable;

public class ConnecterTool extends RoutineEditorTool{
	Variable var;
	public ConnecterTool(RoutineEditorView parent,Variable variable){
		super(new Rectangle(parent.getMouseX(),parent.getMouseY(),1,1),parent);
		this.var=variable;
	}

	@Override
	public void DrawGhost() {
		
	}

	@Override
	public void OnClick(Node n) {
		
	}

	@Override
	public void OnClick() {
		
	}

	@Override
	protected Color GetColor() {
		return new Color(255,255,0);
	} 

}