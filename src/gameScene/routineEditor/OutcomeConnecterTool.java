package gameScene.routineEditor;

import routines.StepOutcome;
import display.Rectangle;
import display.*;
public class OutcomeConnecterTool extends RoutineEditorTool{
	StepOutcome outcome;
	public OutcomeConnecterTool(RoutineEditorView parent,StepOutcome outcome){
		super(new Rectangle(parent.getMouseX(),parent.getMouseY(),1,1),parent);
		this.outcome=outcome;
	}

	@Override
	public void DrawGhost() {
		
	}

	@Override
	public boolean OnClick() {
		return false;
	}

	@Override
	protected Color GetColor() {
		return new Color(255,255,0);
	} 
}