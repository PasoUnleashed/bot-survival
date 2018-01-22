package routines;

import java.util.ArrayList;

import routines.routineExecution.Variable;

public class StepOutcome {
	String name;
	Step next;
	boolean isFinal;
	public boolean isFinal() {
		return isFinal;
	}
	ArrayList<StepOutput> outputs;
	public StepOutcome(String name,Step next,StepOutput[] outputs,boolean isFinal) {
		this.name=name;
		this.next=next;
		this.outputs=new ArrayList<StepOutput>();
		this.isFinal=isFinal;
		for(StepOutput i : outputs) {
			this.outputs.add(i);
		}
		
	}
	
	public StepOutcome(String name,boolean isFinal) {
		this.name=name;
		this.outputs=new ArrayList<StepOutput>();
		this.isFinal=isFinal;
	}
	
	public void setNext(Step next) {
		this.next = next;
	}

	public String getName() {
		return name;
	}
	public Step getNext() {
		return next;
	}
	public ArrayList<StepOutput> getOutputs() {
		return outputs;
	}
	public void SetOutput(int i, Object data) {
		if(i>=0&&i<outputs.size()) {
			outputs.get(i).SetVarData(data);
		}
	}
	public void SetOutput(String name,Object data) {
		for (int i=0;i<outputs.size();i++) {
			if(outputs.get(i).GetName().equals(name)) {
				outputs.get(i).SetVarData(data);
			}
		}
	}
	public Object GetData(int i) {
		if(i>=0&&i<outputs.size()) {
			return outputs.get(i).GetVarData();
		}else {
			return null;
		}
	}
	public ArrayList<Variable> CreateVars(int ids){
		ArrayList<Variable> ret = new ArrayList<>();
		for(StepOutput i : outputs) {
			ret.add(i.CreateVar(ids++));
		}
		return ret;
	}
	public StepOutput AddOutput(String name,BOT_VAR_TYPE type) {
		StepOutput ret = new StepOutput(name,type);
		this.outputs.add(ret);
		return ret;
	}
}
