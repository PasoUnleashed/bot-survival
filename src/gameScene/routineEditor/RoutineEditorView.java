package gameScene.routineEditor;
import display.*;
import display.Rectangle;
import display.Toolbar;
import processing.core.PApplet;
import routines.RoutineBuilder;
public class RoutineEditorView extends display.ScrollView{
	RoutineBuilder builder;
	int gridlength=20;
	Toolbar bar;
	public RoutineEditorView(Rectangle rect,UIView parent,routines.RoutineBuilder r) {
		super(rect, parent);
		// TODO Auto-generated constructor stub
		builder = r;
		bar = new RoutineEditorToolbar(new Rectangle(rect.getX()-30,rect.getY(),30,rect.getHeight()),parent,null);
		parent.AddComponent(bar);
		
	}
	public void ZoomIn() {
		
	}
	public void ZoomOut() {
		
	}
	public void DrawGrid() {
		int start = -this.getScrollx()%gridlength;
		int ystart = -this.getScrolly()%gridlength;
		getApplet().stroke(0,200,0);
		getApplet().strokeWeight(1);
		getApplet().fill(255);
		for(int i=0;i<getRect().getWidth()/gridlength;i++) {
			Rectangle rect= this.GetRectOnApplet(new Rectangle(start+i*gridlength,0,0,0));
			getApplet().line(rect.getX(), rect.getY(), rect.getX(), rect.getY()+this.getRect().getHeight());
		}
		for(int i=0;i<getRect().getHeight()/gridlength;i++) {
			Rectangle rect= this.GetRectOnApplet(new Rectangle(0,ystart+i*gridlength,0,0));
			getApplet().line(rect.getX(), rect.getY(), rect.getX()+this.getRect().getWidth(), rect.getY());
		}
		getApplet().noStroke();
	}
	@Override
	public void DrawComponent() {
		// TODO Auto-generated method stub
		Background(0,0,0);
		DrawGrid();
	}
	

}
