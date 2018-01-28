package gameScene.routineEditor;

import display.*;
import routines.StepInput;

public class InputBar extends Toolbar {
	public InputBar(StepNode parent) {
		super(new Rectangle(0, 0, parent.parent.getGridLength(), parent.GetDrawRectangle().getHeight()), parent);
		for (StepInput i : parent.step.getInputs()) {
			AddButton(0, i.getName(), new Color(100, 100, 100), new ButtonEventHandler() {

				@Override
				public void OnLeave() {

				}

				@Override
				public void OnEnter() {

				}

				@Override
				public void OnClick() {
					System.out.println("Click!");
					if (parent.parent.tool != null) {
						if (ConnecterTool.class.isAssignableFrom(parent.parent.tool.getClass())) {
							parent.step.SetInputVariable(i.getName(), ((ConnecterTool) parent.parent.tool).var);
							System.out.println("Variable set");
						}
					}
				}
			});
		}
	}

}