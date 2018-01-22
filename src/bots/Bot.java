package bots;

import display.Rectangle;
import display.ScrollView;
import display.UIView;
import display.Button;
import display.ButtonEventHandler;
import display.Color;
import display.RectView;
import gameScene.MapView;
import processing.core.PApplet;
import processing.core.PImage;
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
	Button b;
	/*
	 * 
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
		Button b = new Button(new Rectangle(this.getRect().getX()+20,this.getRect().getY()+20,10,10),this.getParent(),new ButtonEventHandler() {

			@Override
			public void OnClick() {
				// TODO Auto-generated method stub
				world.AddObject(new Bot(getRect().getX(),getRect().getY(),world));
			}

			@Override
			public void OnEnter() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void OnLeave() {
				// TODO Auto-generated method stub
				
			}
			
		},"hello",new Color(255,0,0),null);
		b.Hide();
		this.b=b;
	}
	@Override
	public void SetView(UIView view) {
		super.SetView(view);
		view.getComponents().add(b);
		b.SetView(view);
	}
	/*
	 * (non-Javadoc)
	 * @see world.WorldObject#Update()
	 */
	@Override
	public void Frame() {
		machine.ExecuteStep(this,this.world);
		b.getRect().setX(this.getRect().getX()+20);
		b.getRect().setY(this.getRect().getY()-20);
		float distance =PApplet.dist(getParent().getMouseX(), getParent().getMouseY(), getRect().getX(),getRect().getY());
		System.out.println(distance);
		if(distance<60) {
			b.Show();
			
		}else {
			b.Hide();
		}
		super.Frame();
	}
	/*
	 * (non-Javadoc)
	 * @see world.WorldObject#Draw(display.RectView, int, int)
	 */
	@Override
	public void DrawComponent() {
		// TODO Auto-generated method stub
		PVector drawpos = GetDrawPosition();
		getApplet().fill(255,0,0);
		getApplet().rect(drawpos.x, drawpos.y, getRect().getWidth(),getRect().getHeight());
	}
	
}
