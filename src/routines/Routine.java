package routines;

import bots.Bot;
import routines.routineExecution.RoutineMachine;
import routines.routineExecution.RoutineMemory;
import world.Map;
import world.World;

public class Routine extends Step{
	int cost;
	Step startStep;
	
	public int getCost() {
		return cost;
	}

	public Step getStartStep() {
		return startStep;
	}

	public Routine(int id,Step start,String name, StepOutcome[] outcomes, StepInput[] inputs) {
		super(id,name, outcomes, inputs);
		// TODO Auto-generated constructor stub
		startStep=start;
	}

	@Override
	public StepOutcome Execute(Bot bot, World world, Map map, RoutineMachine machine, RoutineMemory memory) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
