package display;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PVector;
/*
 * The toolbar class represents a 2 dimensional array of buttons.
 * The buttons will be uniform in size
 */
public class Toolbar extends UIComponent {
	ArrayList<ArrayList<Button>> buttons;
	int padding = 10;
	boolean horizontal;
	int buttonLength=0;
	/*
	 * @param rect the rectangle that bounds the toolbar
	 * @param parent the RectView which this toolbar will be on
	 */
	public Toolbar(Rectangle rect,RectView parent) {
		super(rect,parent);
		buttons = new ArrayList<>();
		buttons.add(new ArrayList<Button>());
		buttonLength = rect.getWidth();
	}
	//TODO match the AddButton() functions to the new Button constructors
	//TODO make a resizable/dynamic toolbar class where the toolbar's size will be just right to fit the buttons, and the button size is pre-specified
	/*
	 * @param column The column to add the button to
	 * @param text The button's text
	 * @param color The button's color
	 * @param handler The button's event handler
	 */
	public void AddButton(int column,String text,Color color,ButtonEventHandler handler) {
		Button button =new Button(getButtonRect(column,buttons.get(column).size()),this,handler,text,color,null);
		buttons.get(column).add(button);
		components.add(button);
		
	}
	/*
	 * Gets the correct position and size of the button that is at a specific position
	 * @param row the button's row
	 * @param column the button's column
	 */
	Rectangle getButtonRect(int row,int column) {
		return new Rectangle(row*buttonLength,column*buttonLength,buttonLength,buttonLength);
	}
	/*
	 * Add a new column of buttons
	 */
	public void AddButtonColumn() {
		buttons.add(new ArrayList<Button>());
		buttonLength=rect.width/buttons.size();
		for(int i=0;i<buttons.size();i++) {
			for(int j=0;j<buttons.get(i).size();j++) {
				buttons.get(i).get(j).setRect(getButtonRect(i,j));
			}
		}
	}
	
	@Override
	public void Frame() {
		super.Frame();
	}
	@Override
	public void DrawComponent() {
		// TODO Auto-generated method stub
		applet.stroke(0);
		applet.fill(80);
		PVector pos = parent.GetPosOnApplet(rect.x, rect.y);
		applet.rect(pos.x, pos.y, rect.width, rect.height);
		for(int i=0;i<buttons.size();i++) {
			for(int j=0;j<buttons.get(i).size();j++) {
				Button button = buttons.get(i).get(j);
				button.Draw();
			}
		}
		applet.noStroke();
		
	}
	
}
