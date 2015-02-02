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

package cs.ualberta.ca.devito_notes;

import java.io.Serializable;

public class Amount implements Serializable {
	//Initialize all to easily identified not set flags
	//If any not set don't let a claim type change
	private int amount = -1;
	private String currency = "NULL";
	
	protected int getAmount(){
		return amount;
	}
	protected String getCurrency(){
		return currency;
	}
	protected void setAmount(int newAmount){
		amount = newAmount;
	}
	protected void setCurrency(String newCurrency){
		currency = newCurrency;
	}
	public String toString(){
		return String.valueOf(getAmount()) + " " + getCurrency();
		
	}
}
