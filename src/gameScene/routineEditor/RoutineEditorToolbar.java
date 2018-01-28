package gameScene.routineEditor;

import display.*;
import processing.core.PApplet;
import routines.RoutineBuilder;
import routines.steps.GenerateRandomPositionStep;
import routines.steps.MoveToStep;

public class RoutineEditorToolbar extends display.Toolbar {
	RoutineBuilder builder;
	RoutineEditorView view;
	public RoutineEditorToolbar(Rectangle rect, UIView parent,RoutineEditorView view,RoutineBuilder b) {
		super(rect, parent);
		// TODO Auto-generated constructor stub
		this.builder=b;
		this.view=view;
		AddButton(0,"Move Tool",new Color(0,140,255),new ButtonEventHandler(){
		
			@Override
			public void OnLeave() {
				
			}
		
			@Override
			public void OnEnter() {
				
			}
		
			@Override
			public void OnClick() {
				view.SwitchTool(new StepTool(new MoveToStep(view.stepid++),view));
			}
		});
		AddButton(0,"Random Pos",new Color(0,140,255),new ButtonEventHandler(){
		
			@Override
			public void OnLeave() {
				
			}
		
			@Override
			public void OnEnter() {
				
			}
		
			@Override
			public void OnClick() {
				view.SwitchTool(new StepTool(new GenerateRandomPositionStep(view.stepid++),view));
			}
		});
	}
	
}
