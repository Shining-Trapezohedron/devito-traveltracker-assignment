/*
   A simple Claim/Expense tracking program by James Devito

    Copyright (C) 2015  James Devito

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
    */

package cs.ualberta.ca.devito_traveltracker_assignment;

import java.util.ArrayList;

public class ClaimHolder {
	private ArrayList<ExpenseList> Everything = new ArrayList<ExpenseList>();
	private String name;
	private String startdate;
	private String enddate;
	public void add(ExpenseList claimlist){
		Everything.add(claimlist);
	}
	public ExpenseList get(int index){
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
		String rv = name+"-"+startdate+" to "+enddate;
		return rv;
	}
	
}
