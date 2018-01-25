package gameScene.routineEditor;
import display.*;
import display.Rectangle;
import display.Toolbar;
import processing.core.PApplet;
import routines.RoutineBuilder;
public class RoutineEditorView extends GridScrollView{
	RoutineBuilder builder;
	Toolbar bar;
	public RoutineEditorView(Rectangle rect,UIView parent,routines.RoutineBuilder r) {
		super(rect, parent);
		// TODO Auto-generated constructor stub
		builder = r;
		bar = new RoutineEditorToolbar(new Rectangle(rect.getX()-30,rect.getY(),30,rect.getHeight()),parent,null);
		parent.AddComponent(bar);
		
	}
	@Override
	public boolean MousePressed() {
		if(! super.MousePressed()){
			AddComponent(new TestNode(new Rectangle(mouseX,mouseY,2,2),this));
			return true;
		}else{
			return true;	
		}
		
	}
	
}
