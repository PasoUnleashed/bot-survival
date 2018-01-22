package routines.routineExecution;

import java.util.HashMap;
import java.util.Map;

import routines.*;

public class RoutineMemory {
	Map<Integer,Variable> vars;
	Routine routine;
	public RoutineMemory(){
		vars=new HashMap<Integer,Variable>();
	}
	public <T> T Get(int id){
		try {
			return (T) vars.get(id).getData();
		}
		catch (Exception e) {
			return null;
		}
	}
	public <T> void Put(Variable v) {
		Variable x = Get(v.getId());
		if(x!=null) {
			x.setData(v.getData());
		}else {
			vars.put(v.getId(),v);
		}
	}
	public RoutineMemory Copy() {
		return null;
	}
}
