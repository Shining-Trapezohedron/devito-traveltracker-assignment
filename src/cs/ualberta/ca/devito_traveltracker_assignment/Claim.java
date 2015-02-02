package cs.ualberta.ca.devito_traveltracker_assignment;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;


public class Claim implements Serializable{
	private String name;
	private String category;
	private String status;
	private String description;
	SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");
	private String todate;
	private String fromdate;
	private ArrayList<Amount> myAmounts = new ArrayList<Amount>();
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
	public ArrayList<Amount> getAmountsList(){
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
	public void removeAmount(Amount AmountToRemove){
		myAmounts.remove(AmountToRemove);
		MyAmountsSize--;
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

	public void setDate(String inToDate, String inFromToDate){
		/*try {
			Date todate = f.parse(inToDate);
			Date fromdate = f.parse(inFromToDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		todate = inToDate;
		fromdate = inFromToDate;
		
	}
	
	public String getfromdate(){
		return fromdate;
	}
	public String gettodate(){
		return todate;
	}
}
