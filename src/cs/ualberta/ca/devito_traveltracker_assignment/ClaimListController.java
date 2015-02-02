package cs.ualberta.ca.devito_traveltracker_assignment;

public class ClaimListController {
	//lazy singleton
	private static ClaimList claimList = null;
	static public ClaimList getClaimList(){
		if (claimList == null){
			claimList = new ClaimList();
		}
		return claimList;
	};
	public void addClaim(Claim claimToAdd){
		getClaimList().addClaim(claimToAdd);
	}
}
