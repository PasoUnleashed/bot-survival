package routines.routineExecution;

import java.util.Map;

public class ReadOnlyMemory extends RoutineMemory{
	public ReadOnlyMemory(Map<Integer, Variable> vars) {
		this.vars=vars;
	}
	@Override
	public void Put(Variable v) {
		try {
			throw new Exception("Attempted write to read-only memory");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
