package cs.ualberta.ca.devito_traveltracker_assignment;

import java.util.ArrayList;

public class ClaimList {
	private int size = 0;
	private ArrayList<Claim> MyClaims = new ArrayList<Claim>();
	
	public ArrayList<Claim> getClaimList(){
		return MyClaims;
	}
	public void addClaim(Claim NewClaim){
		MyClaims.add(NewClaim);
		this.size++;
	}
	public boolean removeClaim(Claim claimToRemove){
		return MyClaims.remove(claimToRemove);
	}
	public int size(){
		return this.size;
	}
	
}
