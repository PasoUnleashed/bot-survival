package gameScene;

import bots.Bot;
import display.RectView;
import display.Rectangle;
import display.UIView;
import gameScene.routineEditor.RoutineEditorView;
import processing.core.PApplet;
import world.Map;
import world.World;

public class GameScene extends PApplet{
	World w = new World();
	RectView currentView;
	int res_x=700, res_y=700;
	GameSceneMode mode = GameSceneMode.MAP_VIEW;
	UIView mainView = new UIView(new Rectangle(0,0,res_x,res_y),this);
	MapView mapview = new MapView(new Rectangle((res_x/2)-250,(res_y/2)-250,500,500),mainView,w.getMap());
	boolean[] keys= new boolean[255];
	public void settings() {
		size(res_x,res_y);
		mainView.getComponents().add(mapview);
		currentView=mainView;
		w.getMap().getObjects().add(new Bot(50,50,w));
		w.getMap().getObjects().add(data.Resources.Food.Create(60, 60,w));
		//SwitchView(GameSceneMode.MAP_VIEW);
	}
	public void keyPressed() {
		if(key<255) {
			if(Character.isAlphabetic(key)) {
				keys[Character.toLowerCase(key)]=true;
				keys[Character.toUpperCase(key)]=true;
			}
			keys[key]=true;
		}
	}
	public void keyReleased() {
		if(key<255) {
			if(Character.isAlphabetic(key)) {
				keys[Character.toLowerCase(key)]=false;
				keys[Character.toUpperCase(key)]=false;
			}
			keys[key]=false;
		}
	}
	public void draw() {
		currentView.SetKeys(keys,mouseX,mouseY);
		switch(mode) {
		case MAP_VIEW:
			w.Update(keys);
			break;
		case SPECIES_VIEW:
			break;
		case ROUTINES_VIEW:
			break;
		case ROUTINE_EDITOR_VIEW:
			break;
			
		}
		currentView.Frame();
		currentView.Draw();
	}
	public void mousePressed() {
		currentView.MousePressed();
	}
	public void mouseReleased() {
		currentView.MouseReleased();
	}
	void SwitchView(GameSceneMode mode) {
		this.mode = mode;
		switch(mode) {
		case MAP_VIEW:
			
			break;
		case SPECIES_VIEW:
			break;
		case ROUTINES_VIEW:
			break;
		case ROUTINE_EDITOR_VIEW:
			
			break;
			
		}
	}
}
