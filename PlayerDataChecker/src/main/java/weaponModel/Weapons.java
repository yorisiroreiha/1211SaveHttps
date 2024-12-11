package weaponModel;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Weapons implements Serializable {
	private String id ;
	private Map<String,Integer> statusBuff = new  LinkedHashMap<>();
	
	public Weapons() {}
	public Weapons(String id,Map<String,Integer> statusBuff) {
		this.id = id;
		this.statusBuff = statusBuff ;
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Map<String, Integer> getStatusBuff() {
		return statusBuff;
	}
	public void setStatusBuff(Map<String, Integer> statusBuff) {
		this.statusBuff = statusBuff;
	}
	
	
}
