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
	public void removeClaim(Claim claimToRemove){
		MyClaims.remove(claimToRemove);
		this.size--;
	}
	public int size(){
		return this.size;
	}
}
