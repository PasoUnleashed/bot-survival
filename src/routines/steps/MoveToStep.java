package routines.steps;

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

public class MoveToStep extends Step{

	public MoveToStep(int id) {
		super(id, "Move To", new StepOutcome[0],new StepInput[] {new StepInput("Position",BOT_VAR_TYPE.LOCATION)});
		// TODO Auto-generated constructor stub
		StepOutcome rec = new StepOutcome("Step",null,new StepOutput[0],false);
		StepOutcome done = new StepOutcome("Done",null,new StepOutput[0],true);
		getOutcomes().add(rec);
		getOutcomes().add(done);
	}

	@Override
	public StepOutcome Execute(Bot bot, World world, Map map, RoutineMachine machine, RoutineMemory memory) {
		// TODO Auto-generated method stub
		PVector pos = new PVector(bot.getRect().getX(),bot.getRect().getY());
		PVector in =(PVector)getInputs().get(0).getVar().getData();
		PVector inn = new PVector(in.x,in.y);
		PVector direction = (inn).sub(pos).normalize().mult(2);
		pos=pos.add(direction);
		bot.getRect().setX((long) pos.x);
		bot.getRect().setY((long) pos.y);
		if(PVector.dist(pos,(PVector)getInputs().get(0).getVar().getData() )>10) {
			return getOutcomes().get(0);
		}else {
			System.out.println("Done!");
			return getOutcomes().get(1);
			
		}
	}

}
