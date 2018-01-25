package display;

import gameScene.routineEditor.TestNode;

public class GridScrollView extends ScrollView {
	int gridlength=20;
	int gridoffsetx=0,gridoffsety=0;
	TestNode cursor = new TestNode(new Rectangle(0,0, 1, 1), this);
	public GridScrollView(Rectangle rect, UIView parent) {
		super(rect, parent);
		// TODO Auto-generated constructor stub
		
		AddComponent(cursor);
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
		//speed=gridlength;
		cursor.getRect().setX(mouseX);
		cursor.getRect().setY(mouseY);
		System.out.println(mouseX);
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
		getApplet().fill(255);
		
	}

}
