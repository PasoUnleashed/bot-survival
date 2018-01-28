package routines;

import java.util.ArrayList;

import bots.Bot;
import routines.routineExecution.RoutineMachine;
import routines.routineExecution.RoutineMemory;
import routines.routineExecution.StepOutputVariable;
import routines.routineExecution.Variable;
import world.*;


public abstract class Step {
	ArrayList<StepOutcome> outcomes;
	ArrayList<StepInput> inputs;
	String name;
	int id;
	public Step(int id,String name,StepOutcome[] outcomes,StepInput[] inputs) {
		this.outcomes =new ArrayList<StepOutcome>();
		this.inputs=new ArrayList<>();
		this.name=name;
		this.id=id;
		for(StepOutcome i : outcomes) {
			this.outcomes.add(i);
		}
		for(StepInput i : inputs) {
			this.inputs.add(i);
		}
	}
	public Step(int id,String name) {
		this.outcomes =new ArrayList<StepOutcome>();
		this.inputs=new ArrayList<>();
		this.name=name;
		this.id=id;
	}
	public int GetTotalOutputCount(){
		int total=0;
		for(StepOutcome i : this.outcomes){
			total+=i.outputs.size();
		}
		return total;
	}
	public ArrayList<StepOutcome> getOutcomes() {
		return outcomes;
	}

	public ArrayList<StepInput> getInputs() {
		return inputs;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}
	public StepOutcome GetOutcome(int index) {
		if(index>=0&&index<outcomes.size()) {
			return outcomes.get(index);
		}else {
			return null;
		}
	}
	public void SetOutcomeNext(int index,Step next) {
		if(index>=0&&index<outcomes.size()) {
			outcomes.get(index).setNext(next);;
		}
	}
	public Object GetInputData(String name) {
		for(StepInput i : inputs) {
			if(i.getName().equals(name)) {
				return i.GetData();
			}
		}
		return null;
	}
	public Object GetInputData(int index) {
		if(index>=0&&index<inputs.size()) {
			return inputs.get(index).GetData();
		}
		return null;
	}
	public StepOutcome AddOutcome(String name,boolean isFinal) {
		StepOutcome m = new StepOutcome(name,isFinal);
		outcomes.add(m);
		return m;
	}
	public StepInput AddStepInput(String name, BOT_VAR_TYPE type) {
		StepInput t =new StepInput(name,type);
		inputs.add(t);
		return t;
	}
	public StepInput GetInput(int index) {
		if(index>=0&&index<inputs.size()) {
			return inputs.get(index);
		}
		return null;
	}
	public StepInput GetInput(String name) {
		for(StepInput i : inputs) {
			if(i.getName().equals(name)) {
				return i;
			}
		}
		return null;
	}
	public void RemoveStepOutcome(StepOutcome outcome) {
		outcomes.remove(outcome);
	}
	public void RemoveStepInput(StepInput input) {
		inputs.remove(input);
	}
	public void SetInputVariable(String name,Variable v) {
		for(StepInput i : getInputs()) {
			if(i.name.equals(name)) {
				i.setVar(v);
			}
		}
	}
	public void SetInputVariable(int index,Variable v) {
		if(index>=0&&index<inputs.size()) {
			inputs.get(index).setVar(v);
		}
	}
	public abstract StepOutcome Execute(Bot bot, World world, Map map, RoutineMachine machine, RoutineMemory memory);
}
