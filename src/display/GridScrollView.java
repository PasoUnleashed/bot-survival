package display;

import java.util.ArrayList;

import gameScene.routineEditor.TestNode;
/*
* A grid scroll view stores components in "tiles" or "squares" and they can span multiple ones, as in (1,1,3,3) is a rectangle starting from tile 1,1 and ending in tiles 4,4
*
*/
public class GridScrollView extends ScrollView {
	int gridlength=20;
	int gridoffsetx=0,gridoffsety=0;
	
	public GridScrollView(Rectangle rect, UIView parent) {
		super(rect, parent);
		// TODO Auto-generated constructor stub
		
		
	}
	public void DrawGrid() {
		int start = -Math.floorMod(this.getScrollx(),gridlength);
		int ystart = -Math.floorMod(this.getScrolly(),gridlength);
		gridoffsetx=start;
		gridoffsety=ystart;
		getApplet().stroke(0,200,0);
		getApplet().strokeWeight(1);
		getApplet().fill(255);
		for(int i=0;i<=getRect().getWidth()/gridlength;i++) {
			Rectangle rect= this.GetRectOnApplet(new Rectangle(start+i*gridlength,0,0,0));
			getApplet().line(rect.getX(), rect.getY(), rect.getX(), rect.getY()+this.getRect().getHeight());
		}
		for(int i=1;i<=getRect().getHeight()/gridlength;i++) {
			Rectangle rect= this.GetRectOnApplet(new Rectangle(0,ystart+i*gridlength,0,0));
			getApplet().line(rect.getX(), rect.getY(), rect.getX()+this.getRect().getWidth(), rect.getY());
		}
		getApplet().noStroke();
	}
	@Override
	public void Frame() {
		super.Frame();
	
	}
	@Override
	public boolean MousePressed() {
		boolean ret= false;
		ArrayList<UIComponent> com = new ArrayList<>();
		for(UIComponent i : this.components){
			com.add(i);
		}
		for(UIComponent i: com){
			if(i.rect.Contains(new Rectangle(mouseX,mouseY, 0,0))){
				ret = ret||i.MousePressed();
			}
		}
		return ret;
	}
	@Override
	public void MouseClick() {
		ArrayList<UIComponent> com = new ArrayList<>();
		for(UIComponent i : this.components){
			com.add(i);
		}
		for(UIComponent i: com){
			if(i.rect.Contains(new Rectangle(mouseX,mouseY, 0,0))){
				i.MouseClick();
			}
		}
	}
	@Override
	public void MouseReleased() {
		ArrayList<UIComponent> com = new ArrayList<>();
		for(UIComponent i : this.components){
			com.add(i);
		}
		for(UIComponent i: com){
			if(i.rect.Contains(new Rectangle(mouseX,mouseY, 0,0))){
				i.MouseReleased();
			}
		}
		
	}
	public Rectangle GetBoundingRectangle(){
		return new Rectangle(scrollx/gridlength,scrolly/gridlength , rect.getWidth()/gridlength, rect.getHeight()/gridlength);
		
	}
	@Override
	public void SetKeys(boolean[] keys, int x, int y) {
		super.SetKeys(keys, x, y);

		mouseX=mouseX>0?mouseX/gridlength:Math.floorDiv(mouseX, gridlength);
		mouseY=mouseY>0?mouseY/gridlength:Math.floorDiv(mouseY, gridlength);
		
	}
	@Override
	public void DrawComponent() {
		// TODO Auto-generated method stub
		Background(0, 0, 0);
		DrawGrid();
	}
	public int getGridLength(){
		return gridlength;
	}

}
