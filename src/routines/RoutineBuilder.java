package routines;

import java.util.ArrayList;
import java.util.HashMap;

import routines.routineExecution.Variable;
import routines.steps.*;
public class RoutineBuilder {
	int sidi,vidi,cost;
	ArrayList<Variable> variables = new ArrayList<Variable>();
	HashMap<Integer,Step> steps = new HashMap<Integer,Step>();
	Step start;
	public RoutineBuilder(boolean isRecurrent) {
		if(isRecurrent) {
			//start=new StartStep(sidi++));
		}
	}
	
	public void AddStep(Step step) {
		
	}
	
	public void RemoveStep() {
		
	}
}
