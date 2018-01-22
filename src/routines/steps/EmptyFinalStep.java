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

public class EmptyFinalStep extends DirectStep{

	public EmptyFinalStep(int id) {
		super(id, "Empty", "Next");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Do(Bot bot, World world, Map map, RoutineMachine machine, RoutineMemory memory) {
		// TODO Auto-generated method stub
		//System.out.println("Empty");
	}

}
