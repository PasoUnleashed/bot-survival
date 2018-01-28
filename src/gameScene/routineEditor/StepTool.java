package gameScene.routineEditor;
import java.awt.Frame;

import display.Color;
import display.Rectangle;
import routines.*;

public class StepTool extends RoutineEditorTool{
	StepNode stepnode;
	public StepTool(Step step, RoutineEditorView parent){
		super(new Rectangle(parent.getMouseX(), parent.getMouseY(), 1,1),parent);
		stepnode=new StepNode(parent.getMouseX(),parent.getMouseY(), parent, step);
		
	}
	@Override
	public void Frame() {
		super.Frame();
		getRect().setX(parent.getMouseX());
		getRect().setY(parent.getMouseY());
		stepnode.getRect().setX(parent.getMouseX());
		stepnode.getRect().setY(parent.getMouseY());
		
	}
	@Override
	public void DrawGhost() {
		stepnode.Draw();
	}
	

	@Override
	public boolean OnClick() {
		parent.AddComponent(stepnode);
		return true;
	}

	@Override
	protected Color GetColor() {
		return null;
	}

}