package routines.routineExecution;

import java.util.ArrayList;

import bots.Bot;
import routines.*;
import world.World;

public class RoutineMachine {
	RoutineMemory memory;
	Routine routine;
	Step currentStep;
	ArrayList<Step> stack=new ArrayList<>();
	public RoutineMachine(Routine routine,RoutineMemory memory) {
		this.routine=routine;
		this.currentStep=routine.getStartStep();
		this.memory=memory;
		this.stack.add(currentStep);
	}
	public void ExecuteStep(Bot bot,World world) {
		//System.out.println("Executing :"+currentStep.getName());
		StepOutcome outcome = currentStep.Execute(bot, world,world.getMap(), null, null);
		//System.out.println(currentStep.getName());
		if(outcome.getNext()!=null) {
			if(outcome.isFinal()) {
				currentStep = outcome.getNext();
			}else {
				stack.add(currentStep);
				currentStep = outcome.getNext();
			}
		}else {
			if(outcome.isFinal()) {
				currentStep=stack.get(stack.size()-1);
				stack.remove(stack.size()-1);
			}
		}
		
	}
	
}
