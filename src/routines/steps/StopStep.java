package routines.steps;

import bots.Bot;
import routines.Step;
import routines.StepInput;
import routines.StepOutcome;
import routines.StepOutput;
import routines.routineExecution.RoutineMachine;
import routines.routineExecution.RoutineMemory;
import world.Map;
import world.World;

public class StopStep extends Step {

	public StopStep(int id) {
		super(id, "Stop",new StepOutcome[] {new StepOutcome("Done",new EmptyFinalStep(-1), new StepOutput[0],false)},new StepInput[0]);
		// TODO Auto-generated constructor stub
	}

	@Override
	public StepOutcome Execute(Bot bot, World world, Map map, RoutineMachine machine, RoutineMemory memory) {
		// TODO Auto-generated method stub
		return getOutcomes().get(0);
	}
	
}
