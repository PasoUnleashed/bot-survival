package world;

import display.Button;
import display.ButtonEventHandler;
import display.Color;
import display.Menu;
import display.Rectangle;

public class Circle extends Building{

	public Circle(long x,long y,World w){
		super(x,y,w);
		getRect().setWidth(20);
		getRect().setHeight(20);
	}

	@Override
	public Menu BuildMenu() {
		menu = new Menu(new Rectangle(800,800, 400,200),getScrollView().getParent());
		ButtonEventHandler handler = new ButtonEventHandler(){
		
			@Override
			public void OnLeave() {
				
			}
		
			@Override
			public void OnEnter() {
				
			}
		
			@Override
			public void OnClick() {
				System.out.println("Circle menu button has been pressed!!!");	
				world.AddObject(new world.Outpost(getRect().getX()+30, getRect().getY()+30,world));			
			}
		};
		menu.getComponents().add(new Button(new Rectangle(0,0,20,20),menu,handler,"",new Color(30,30,120),null));
		return menu;
	}
	@Override
	public boolean MousePressed(){
		super.MousePressed();
		System.out.println("Circle Building press");
		return true;
	}
	@Override
	public void DrawComponent() {
		Rectangle draw = GetDrawRectangle();
		getApplet().fill(255,0,0);
		getApplet().ellipse(draw.getX()+draw.getWidth()/2, draw.getY()+draw.getHeight()/2, draw.getWidth(),draw.getHeight());
		
	}

}