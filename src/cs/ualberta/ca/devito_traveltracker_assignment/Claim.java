package cs.ualberta.ca.devito_traveltracker_assignment;

import java.util.ArrayList;
import java.util.Collection;


public class Claim{
	private String name;
	private String category;
	private String status;
	private String description;
	private ArrayList<Amount> myAmounts;
	private int MyAmountsSize = 0; 
	public String getName(){
		return name;
	}
	public String getCategory(){
		return category;
	}
	public String getStatus(){
		return status;
	}
	public Collection<Amount> getAmountsList(){
		return myAmounts;
	}
	public int getAmountsSize(){
		return MyAmountsSize;
	}
	public void setName(String newName){
		name = newName;
	}
	public void setCategory(String newType){
		category = newType;
	}
	public void setStatus(String newStatus){
		status = newStatus;
	}
	public void addAmount(Amount newAmount){
		myAmounts.add(newAmount);
		MyAmountsSize++;
	}
	//Will return a bool on Success/Failure
	public boolean removeAmount(Amount AmountToRemove){
		return myAmounts.remove(AmountToRemove);
	}
	public String toString(){
		String rString = getName() +" - " + getStatus();
		return rString;
	}
	public void setDescription(String Description){
		description = Description;
	}
	public String getDescription(){
		return description;
	}
}
