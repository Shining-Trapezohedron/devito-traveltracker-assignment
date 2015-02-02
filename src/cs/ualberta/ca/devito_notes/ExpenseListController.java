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

public class ExpenseListController {
	//lazy singleton
	//Inspired by the series of videos beginning with https://www.youtube.com/watch?v=5PPD0ncJU1g
	//by Abram Hindle
	//Posted on: Sep 11, 2014
	//Today : 2/2/2015
	private static ExpenseList claimList = null;
	static public ExpenseList getClaimList(){
		if (claimList == null){
			claimList = new ExpenseList();
		}
		return claimList;
	};
	public void addClaim(Expense claimToAdd){
		getClaimList().addClaim(claimToAdd);
	}
}
