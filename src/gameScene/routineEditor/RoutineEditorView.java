package gameScene.routineEditor;
import display.*;
import display.Rectangle;
import display.Toolbar;
import processing.core.PApplet;
import routines.RoutineBuilder;
public class RoutineEditorView extends display.UIView{
	RoutineBuilder builder;
	int gridlength=5;
	Toolbar bar;
	public RoutineEditorView(Rectangle rect, PApplet applet,routines.RoutineBuilder r) {
		super(rect, applet);
		// TODO Auto-generated constructor stub
		builder = r;
		bar = new RoutineEditorToolbar(new Rectangle(0,0,applet.width/12,applet.height),this,r);


		components.add(bar);
	}
	public void ZoomIn() {
		
	}
	public void ZoomOut() {
		
	}
	@Override
	public void DrawComponent() {
		// TODO Auto-generated method stub
		
	}
	

}
