package gameScene.routineEditor;

import display.Color;
import routines.Step;
import display.*;
public class StepNode extends Node {
	Step step;
	InputBar ibar;
	public StepNode(long x,long y,RoutineEditorView parent,Step step){
		super(new Rectangle(x,y,3,Math.max(step.GetTotalOutputCount(),Math.max(step.getInputs().size(),step.getOutcomes().size()))),parent);
		this.step=step;
		ibar = new InputBar(this);
		AddComponent(ibar);
	}
	@Override
	protected Color GetColor() {
		return new Color(255,255,255);
	}
	




}
