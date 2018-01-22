package routines.routineExecution;

import routines.BOT_VAR_TYPE;

public class Variable {
	BOT_VAR_TYPE type;
	int id;
	Object data;
	boolean isDeletable=true;
	public Variable(BOT_VAR_TYPE type, int id, Object data) {
		super();
		this.type = type;
		this.id = id;
		this.data = data;
	}
	public Variable(int id,BOT_VAR_TYPE type) {
		this.id=id;
		this.type=type;
	}
	public BOT_VAR_TYPE getType() {
		return type;
	}
	public void setType(BOT_VAR_TYPE type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
