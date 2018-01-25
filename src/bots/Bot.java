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
	/*
	 * 
	 * Create a bot at a certain position
	 * @param x the x coordinate of the bot
	 * @param y the y coordinate of the bot
	 * @param w the world in which the bot resides
	 */
	public Bot(long x, long y, World w) {
		super(x, y, w);
		
	}
	@Override
	public void SetView(UIView view) {
		super.SetView(view);
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
