package gameScene.routineEditor;

import display.Color;
import display.Rectangle;

public class CursorTool extends RoutineEditorTool{
	public CursorTool(RoutineEditorView parent){
		super(new Rectangle(0, 0, 1,1),parent);
	}
	@Override
	public void DrawGhost() {
		Rectangle rect = GetDrawRectangle();
		getApplet().fill(255,255,255);
		getApplet().rect(rect.getX(),rect.getY(),rect.getHeight(),rect.getWidth());
	}
	@Override
	public void Frame(){
		super.Frame();
		this.getRect().setX(parent.getMouseX());
		this.getRect().setY(parent.getMouseY());
	}
	@Override
	public void OnClick(Node n) {

	}

	@Override
	public void OnClick() {
		
	}
	@Override
	protected Color GetColor() {
		return null;
	}

}