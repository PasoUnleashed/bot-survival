package routines.steps;

import bots.Bot;
import routines.BOT_VAR_TYPE;
import routines.Step;
import routines.StepInput;
import routines.StepOutcome;
import routines.StepOutput;
import routines.routineExecution.RoutineMachine;
import routines.routineExecution.RoutineMemory;
import world.Map;
import world.World;

public class DebugStep extends DirectStep {

	public DebugStep(int id) {
		super(id,"Debug","Proceed");
		// TODO Auto-generated constructor stub
		AddStepInput("text",BOT_VAR_TYPE.TEXT);
	}

	@Override
	public void Do(Bot bot, World world, Map map, RoutineMachine machine, RoutineMemory memory) {
		// TODO Auto-generated method stub
		System.out.println(GetInputData(0));
	}

	

}
