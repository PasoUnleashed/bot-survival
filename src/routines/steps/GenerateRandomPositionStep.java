package routines.steps;

import java.util.Random;

import bots.Bot;
import processing.core.PVector;
import routines.BOT_VAR_TYPE;
import routines.Step;
import routines.StepInput;
import routines.StepOutcome;
import routines.StepOutput;
import routines.routineExecution.RoutineMachine;
import routines.routineExecution.RoutineMemory;
import world.Map;
import world.World;

public class GenerateRandomPositionStep extends Step{ 

	public GenerateRandomPositionStep(int id) {
		super(id, "Random Position",new StepOutcome[0],new StepInput[0]);
		AddOutcome("Done",true).AddOutput("pos", BOT_VAR_TYPE.LOCATION);
	}

	@Override
	public StepOutcome Execute(Bot bot, World world, Map map, RoutineMachine machine, RoutineMemory memory) {
		Random r = new Random();
		long x = map.getMin_x()+(r.nextInt((int) (map.getMax_x()-map.getMin_x())));
		long y = map.getMin_y()+(r.nextInt((int) (map.getMax_y()-map.getMin_y())));
		PVector rand = new PVector(x,y);
		
		StepOutcome outcome = getOutcomes().get(0);
		outcome.getOutputs().get(0).GetVar().setData(rand);
		return outcome;
	}
	
}
