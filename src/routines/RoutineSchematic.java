package routines;

import java.util.HashMap;

import gameScene.routineEditor.RoutineVisualSchematic;
import routines.routineExecution.ReadOnlyMemory;

public class RoutineSchematic {
	HashMap<Integer,Step> steps;
	Step start;
	ReadOnlyMemory memory;
	public RoutineSchematic(HashMap<Integer, Step> steps, Step first, ReadOnlyMemory memory) {
		super();
		this.steps = steps;
		this.start = start;
		this.memory = memory;
	}
	public HashMap<Integer, Step> getSteps() {
		return steps;
	}
	public Step getStart() {
		return start;
	}
	public ReadOnlyMemory getMemory() {
		return memory;
	}
	
}
