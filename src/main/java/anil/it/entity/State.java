package anil.it.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sid;
	
	private String stateName;
	
	private Integer cid;

	public State() {
		super();
		// TODO Auto-generated constructor stub
	}

	public State(Integer sid, String stateName, Integer cid) {
		super();
		this.sid = sid;
		this.stateName = stateName;
		this.cid = cid;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "State [sid=" + sid + ", stateName=" + stateName + ", cid=" + cid + "]";
	}
	
	

}
