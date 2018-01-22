package routines;

import routines.routineExecution.Variable;

public class StepInput {
	BOT_VAR_TYPE type;
	String name;
	Variable var;
	public StepInput(String name,BOT_VAR_TYPE type) {
		this.name=name;
		this.type=type;
	}
	public Variable getVar() {
		return var;
	}
	public Variable CreateVariable(int id) {
		var =new Variable(id,type);
		return var;
	}
	public void setVar(Variable var) {
		this.var = var;
	}
	public BOT_VAR_TYPE getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	public Object GetData() {
		return var.getData();
	}
}
