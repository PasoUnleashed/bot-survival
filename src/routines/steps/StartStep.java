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

public class StartStep extends Step{

	public StartStep(int id,String name,StepOutput[] outputs,Step next) {
		super(id,name, new StepOutcome[] {new StepOutcome("Begin",next,outputs,false)},new StepInput[0]);
		// TODO Auto-generated constructor stub
	}

	public StartStep(int id) {
		super(id, "Start");
		// TODO Auto-generated constructor stub
		AddOutcome("Begin",false);
	}

	@Override
	public StepOutcome Execute(Bot bot, World world, Map map,RoutineMachine machine, RoutineMemory memory) {
		return getOutcomes().get(0);
	}

}

