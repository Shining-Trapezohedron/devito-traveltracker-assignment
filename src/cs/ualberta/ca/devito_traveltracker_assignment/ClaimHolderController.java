package cs.ualberta.ca.devito_traveltracker_assignment;

import java.util.ArrayList;

public class ClaimHolderController {
	//lazy singleton
	private static ArrayList<ClaimHolder> claimholderlist= null;
	static public ArrayList<ClaimHolder> getClaimHolderList(){
		if (claimholderlist == null){
			claimholderlist = new ArrayList<ClaimHolder>();
		}
		return claimholderlist;
	};
	public void addClaimHolder(ClaimHolder claimToAdd){
		getClaimHolderList().add(claimToAdd);
	}
}
