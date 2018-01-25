package gameScene.routineEditor;

import display.GridScrollView;
import display.Rectangle;
import display.ScrollView;

public class TestNode extends Node{

	public TestNode(Rectangle rect, GridScrollView gridScrollView) {
		super(rect, gridScrollView);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void DrawComponent() {
		Rectangle rect = GetDrawRectangle();
		getApplet().fill(255);
		getApplet().rect(rect.getX(),rect.getY(),rect.getWidth(),rect.getHeight());
		
	}

}
