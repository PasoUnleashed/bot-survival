package gameScene.routineEditor;

import display.Color;
import java.util.ArrayList;
import routines.Step;
import routines.StepOutcome;
import display.*;
public class StepNode extends Node {
	Step step;
	InputBar ibar;
	ArrayList<OutcomeBar> obars= new ArrayList<>();
	public StepNode(long x,long y,RoutineEditorView parent,Step step){
		
		super(new Rectangle(x,y,5,Math.max(step.GetTotalOutputCount(),Math.max(step.getInputs().size(),step.getOutcomes().size()))),parent);
		this.step=step;
		ibar = new InputBar(this);
		int total =0;
		for(int i=0;i<step.getOutcomes().size();i++){
			OutcomeBar b = new OutcomeBar(this,i,total);
			total+=b.getRect().getHeight();
			obars.add(b);
			AddComponent(b);
		}
		AddComponent(ibar);
	}
	@Override
	public void Draw() {
		super.Draw();
	}
	@Override
	protected Color GetColor() {
		return new Color(255,255,255);
	}
	@Override
	public boolean MousePressed(){
		if(parent.tool!=null&&parent.tool.getClass().equals(OutcomeConnecterTool.class)){
			((OutcomeConnecterTool)parent.tool).outcome.setNext(step);
			System.out.println("Next step set:"+((OutcomeConnecterTool)parent.tool).outcome.getName()+" > "+step.getName());
			parent.SwitchTool(RoutineEditorView.TOOL.NONE);
			return true;
		}
		return super.MousePressed();
	}
	




}
