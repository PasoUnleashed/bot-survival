package display;

public class Rectangle {
	long x,y;
	int width,height;
	public Rectangle(long x, long y, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	public long getX() {
		return x;
	}
	public void setX(long x) {
		this.x = x;
	}
	public long getY() {
		return y;
	}
	public void setY(long y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public boolean IsInBound(long x,long y) {
		if(x>this.x && x<this.x+this.width&&y>this.y&&y<this.y+this.height) {
			return true;
		}else {
			return false;
		}
	}
	public boolean Contains(Rectangle other) {
		if(other.x>x && other.x+other.width<width+x&&other.y>y&&other.y+other.height<y+height) {
			return true;
		}
		return false;
	}
	
}
