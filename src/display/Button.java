package display;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;
/*
 * A button to be drawn on a UIView, it must be passed a handler to execute a task.
 * An example handler using the anonymous object syntax would be
 * 
	ButtonEventHandler h = new ButtonEventHandler(){

			@Override
			public void OnClick() {
				System.out.println("Hello World!");
			}

			@Override
			public void OnEnter() {
				//Do nothing
			}

			@Override
			public void OnLeave() {
				//Do nothing
			}
			
	}
 */

public class Button extends UIComponent{
	/*
	 * @param rect The rectangle the button should be drawn in
	 * @param parent The RectView which contains this component
	 * @param handler The button event handler
	 * @param text The button text
	 * @param color The color of the button (if no image is provided)
	 * @param image the image to be drawn with the button rectangle;
	 */
	// TODO Add Another constructor so that a button can either be initialized with an image
	// or a color set (default,hover,press) 
	public Button(Rectangle rect, RectView parent,ButtonEventHandler handler,String text, Color color, PImage image) {
		super(rect, parent);
		this.image=image;
		this.color=color;
		this.defaultColor=color;
		this.text=text;
		this.handler=handler;
		
	}
	PImage image;
	String text;
	Color color;
	Color defaultColor;
	Color hoverColor = new Color(0,0,255);
	Color pressColor = new Color(0,100,255);
	ButtonEventHandler handler;
	boolean isPressed=false;
	//Overriding the MousePressed() function of RectView, so that we can invoke behavior upon mouse events 
	@Override
	public void MousePressed() {
		isPressed=true;
	}
	//Overriding the MouseReleased() function of RectView, so that we can invoke behavior upon mouse events
	public void MouseReleased() {
		isPressed=false;
		if(handler!=null) {
			handler.OnClick();
		}
	}
	//Overriding the MouseLeave() function of RectView, so that we can invoke behavior upon mouse events
	@Override
	public void MouseLeave() {
		isPressed=false;
	}
	//Overriding the Frame() function so that we can change the currentColor depending on the state
	@Override
	public void Frame() {
		// TODO Auto-generated method stub
		super.Frame();
		if(isPressed) {
			color=pressColor;
		}else if(mouseOver) {
			color=hoverColor;
		}else {
			color=defaultColor;
		}
	}
	//Overriding the DrawComponent function is a must for any concrete UIComponent
	@Override
	public void DrawComponent() {
		PVector drawpos = parent.GetPosOnApplet(rect.x, rect.y);
		applet.fill(color.r,color.g,color.b);
		applet.rect(drawpos.x, drawpos.y, rect.width,rect.height);
	}
	
}
