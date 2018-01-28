package gameScene.routineEditor;

import display.Color;
import display.GridScrollView;
import display.Rectangle;
import display.ScrollView;

public class TestNode extends Node{

	public TestNode(Rectangle rect, GridScrollView gridScrollView) {
		super(rect, gridScrollView);
		// TODO Auto-generated constructor stub
	}
	Color color = new Color(255,255,255);
	@Override
	protected Color GetColor() {
		return color;
	}

	

}
