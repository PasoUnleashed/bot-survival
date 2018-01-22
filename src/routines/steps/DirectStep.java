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

public abstract class DirectStep extends Step{
	String outcomename;




	public DirectStep(int id, String name,String outcomename, StepOutput[] outputs, StepInput[] inputs) {
		super(id, name);
		// TODO Auto-generated constructor stub
		for(StepInput i : inputs) {
			getInputs().add(i);
		}
		StepOutcome c = AddOutcome(outcomename,true);
		for(StepOutput i : outputs) {
			c.getOutputs().add(i);
		}
		
	}




	public DirectStep(int id, String name,String outcomename) {
		this(id,name,outcomename,new StepOutput[0],new StepInput[0]);
	}



	public abstract void Do(Bot bot,World world,Map map,RoutineMachine machine,RoutineMemory memory);
	@Override
	public StepOutcome Execute(Bot bot, World world, Map map, RoutineMachine machine, RoutineMemory memory) {
		Do(bot, world, map, machine, memory);
		return GetOutcome(0);
	}}
