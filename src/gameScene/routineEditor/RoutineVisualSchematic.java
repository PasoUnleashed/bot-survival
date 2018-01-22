package gameScene.routineEditor;

import java.util.ArrayList;

import display.Rectangle;
import processing.core.PVector;
import routines.Step;
import routines.routineExecution.Variable;

public class RoutineVisualSchematic {
	ArrayList<Node> nodes;
	Rectangle size;
	public RoutineVisualSchematic(Rectangle startsize) {
		nodes= new ArrayList<>();
		size=startsize;
	}
	public void AddStepNode(Step step,PVector position) {
		
	}
	public void AddVariableNode(Variable var, PVector position) {
		
	}
	
	
}
