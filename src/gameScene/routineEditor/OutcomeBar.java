package gameScene.routineEditor;

import display.Toolbar;
import routines.StepOutcome;
import display.*;

public class OutcomeBar extends Toolbar{
	public OutcomeBar(StepNode parent,StepOutcome outcome){
		super(new Rectangle(0,0,parent.parent.getGridLength(),parent.GetDrawRectangle().getHeight()),parent);
		for(StepOutcome i : parent.step.getOutcomes()){
		
		}
	}

}