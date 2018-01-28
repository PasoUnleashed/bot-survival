package gameScene.routineEditor;
import display.*;
import display.Rectangle;
import display.Toolbar;
import processing.core.PApplet;
import routines.RoutineBuilder;
import routines.steps.MoveToStep;
public class RoutineEditorView extends GridScrollView{
	RoutineBuilder builder;
	Toolbar bar;
	RoutineEditorTool tool;
	int varid=0;
	int stepid=0;
	public RoutineEditorView(Rectangle rect,UIView parent,routines.RoutineBuilder r) {
		super(rect, parent);
		// TODO Auto-generated constructor stub
		builder = r;
		bar = new RoutineEditorToolbar(new Rectangle(rect.getX()-30,rect.getY(),30,rect.getHeight()),parent,this,null);
		parent.AddComponent(bar);
		
	}
	@Override
	public void Frame() {
		super.Frame();
	}
	
	@Override
	public boolean MousePressed() {
		if(tool!=null&&tool.MousePressed()){
			SwitchTool(TOOL.NONE);
			return true;
		}
		return super.MousePressed();
	}
	public void SwitchTool(TOOL tool){
		this.RemoveComponent(this.tool);
		switch(tool){
			case CURSOR:
				this.tool = new CursorTool(this);
				this.AddComponent(this.tool);
				break;
			case NONE:
				this.tool=null;
				break;
		}
	}
	public void SwitchTool(RoutineEditorTool tool){
		RemoveComponent(this.tool);
		this.tool=tool;
		AddComponent(tool);
	}
	public enum TOOL{
		CURSOR,NONE;
	}
	
}
