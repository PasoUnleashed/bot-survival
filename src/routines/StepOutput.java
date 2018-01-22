package routines;

import routines.routineExecution.Variable;

public class StepOutput {
	String name;
	BOT_VAR_TYPE type;
	Variable var;
	public StepOutput(String name,BOT_VAR_TYPE type) {
		this.name=name;
		this.type=type;
	}
	public void SetVar(Variable var) {
		this.var=var;
	}
	public void SetVarData(Object data) {
		if(var!=null) {
			var.setData(data);
		}
	}
	public String GetName() {
		return name;
	}
	public Variable GetVar() {
		return var;
	}
	public Object GetVarData() {
		return var.getData();
	}
	public Variable CreateVar(int id) {
		this.var=new Variable(id,this.type);
		return this.var;
	}
}
