package cs.ualberta.ca.devito_traveltracker_assignment;

import java.util.ArrayList;

public class ClaimHolder {
	private ArrayList<ClaimList> Everything = new ArrayList<ClaimList>();
	private String name;
	private String startdate;
	private String enddate;
	public void add(ClaimList claimlist){
		Everything.add(claimlist);
	}
	public ClaimList get(int index){
		return Everything.get(index);
	}
	public String getName(){
		return name;
	}
	public void setName(String newname){
		name = newname;
	}
	public String getStart(){
		return startdate;
	}
	public void setStart(String newstart){
		startdate = newstart;
	}
	public String getEnd(){
		return enddate;
	}
	public void setEnd(String newend){
		enddate = newend;
	}
	public String toString(){
		String rv = name+"-"+startdate+"-"+enddate;
		return rv;
	}
	
}
