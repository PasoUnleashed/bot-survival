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
	public RoutineEditorView(Rectangle rect,UIView parent,routines.RoutineBuilder r) {
		super(rect, parent);
		// TODO Auto-generated constructor stub
		builder = r;
		bar = new RoutineEditorToolbar(new Rectangle(rect.getX()-30,rect.getY(),30,rect.getHeight()),parent,null);
		parent.AddComponent(bar);
		((Button)bar.getComponents().get(0)).setHandler(new ButtonEventHandler(){
		
			@Override
			public void OnLeave() {
				
			}
		
			@Override
			public void OnEnter() {
				
			}
		
			@Override
			public void OnClick() {
				SwitchTool(TOOL.CURSOR);
			}
		});
	}
	@Override
	public void Frame() {
		super.Frame();
	}
	@Override
	public boolean MousePressed() {
		if(! super.MousePressed()){
			if(tool!=null){
				System.out.println("Adding");
				AddComponent(new StepNode(mouseX,mouseY,this,new MoveToStep(0)));
				SwitchTool(TOOL.NONE);
				return true;
			}
			return false;
		}else{
			return true;	
		}
		
	}
	public void SwitchTool(TOOL tool){
		this.RemoveComponent(this.tool);
		switch(tool){
			case CURSOR:
				this.tool = new CursorTool(this);
				this.AddComponent(this.tool);
				break;
			case NONE:
				RemoveComponent(this.tool);
				this.tool=null;
				break;
		}
	}
	public enum TOOL{
		CURSOR,NONE;
	}
	
}
