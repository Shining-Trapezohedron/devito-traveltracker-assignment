package cs.ualberta.ca.devito_traveltracker_assignment;

public class Amount {
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
