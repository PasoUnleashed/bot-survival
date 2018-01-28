package gameScene.routineEditor;

import routines.StepOutcome;
import routines.StepOutput;
import display.*;

public class OutcomeBar extends Toolbar {
	public OutcomeBar(StepNode parent, int index, int start) {
		super(new Rectangle(parent.parent.getGridLength()*3 + 1, start, parent.parent.getGridLength() * 2,
				Math.max(parent.parent.getGridLength(),parent.step.GetOutcome(index).getOutputs().size())), parent);
		AddButtonColumn();
		StepOutcome outcome = parent.step.getOutcomes().get(index);
		AddButton(1, outcome.getName(), outcome.isFinal() ? new Color(255, 0, 0) : new Color(0, 255, 0),
				new ButtonEventHandler() {

					@Override
					public void OnLeave() {

					}

					@Override
					public void OnEnter() {

					}

					@Override
					public void OnClick() {
						parent.parent.SwitchTool(new OutcomeConnecterTool(parent.parent,outcome));
					}
				});
		for (StepOutput i : outcome.getOutputs()) {
			AddButton(0, i.GetName(), new Color(100, 0, 100), new ButtonEventHandler() {

				@Override
				public void OnLeave() {

				}

				@Override
				public void OnEnter() {

				}

				@Override
				public void OnClick() {
					if(parent.parent.tool==null){
						parent.parent.SwitchTool(new ConnecterTool(parent.parent,i.GetVar()==null? i.CreateVar(parent.parent.varid++):i.GetVar()));
					}
				}
			});
		}
	}

}
