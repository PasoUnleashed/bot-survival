package bots;

import display.RectView;
import processing.core.PVector;
import routines.routineExecution.RoutineMachine;
import routines.routineExecution.RoutineMemory;
import routines.routineExecution.Variable;
import routines.*;
import routines.steps.*;

import world.World;
/*
 * Bot Class, Operates a bot object in a world running a specific routine
 * 
 */
public class Bot extends world.WorldObject {
	/*
	 * The routine machine that's running this bot's routine
	 */
	RoutineMachine machine;
	/*
	 * The bot's current memory
	 */
	RoutineMemory memory;
	/*
	 * Create a bot at a certain position
	 * @param x the x coordinate of the bot
	 * @param y the y coordinate of the bot
	 * @param w the world in which the bot resides
	 */
	public Bot(long x, long y, World w) {
		super(x, y, w);
		int ids=0,vids=0;
		RoutineMemory m = new RoutineMemory();
		StartStep start = new StartStep(ids++);
		GenerateRandomPositionStep random = new GenerateRandomPositionStep(ids++);
		DebugStep debug = new DebugStep(ids++);
		MoveToStep move = new MoveToStep(ids++);
		start.SetOutcomeNext(0,random);
		random.SetOutcomeNext(0,debug);
		debug.SetOutcomeNext(0, move);
		Variable a=random.GetOutcome(0).getOutputs().get(0).CreateVar(vids++);
		debug.SetInputVariable(0, a);
		move.SetInputVariable(0, a);
		move.SetOutcomeNext(0, new EmptyFinalStep(ids++));
		Routine routine = new Routine(3,start,"main",new StepOutcome[0],new StepInput[0]);
		machine= new RoutineMachine(routine,m);
		memory = m;
	}
	/*
	 * (non-Javadoc)
	 * @see world.WorldObject#Update()
	 */
	@Override
	public void Update() {
		machine.ExecuteStep(this,this.world);
	}
	/*
	 * (non-Javadoc)
	 * @see world.WorldObject#Draw(display.RectView, int, int)
	 */
	@Override
	public void Draw(RectView v, int x, int y) {
		// TODO Auto-generated method stub
		v.getApplet().fill(255,0,0);
		v.getApplet().rect(x, y, rect.getWidth(),rect.getHeight());
	}
	
}
