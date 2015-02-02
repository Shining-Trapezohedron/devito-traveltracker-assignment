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

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ViewAndEditExpenseActivity extends Activity {
	private TextView claimText;
	private Spinner catSpin;
	private Spinner statSpin;
	private TextView dateText;
	private TextView descText;
	private EditText ammountText;
	private Expense gotClaim;
	//private ArrayList<Amount> total = new ArrayList<Amount>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.claim_view);
		
		TextView claimview;
		Intent intent = getIntent();
		gotClaim = (Expense) intent.getSerializableExtra("passClaim");
		
		//Set all our text items in order they are shown on the screen
		claimText = (TextView) findViewById(R.id.editClaim);
		claimText.setText(gotClaim.getName());
		catSpin = (Spinner) findViewById(R.id.editcatpinner);
		catSpin.setSelection(getIndex(catSpin,gotClaim.getCategory()));
		statSpin = (Spinner) findViewById(R.id.editstatspinner);
		statSpin.setSelection(getIndex(statSpin,gotClaim.getStatus()));
		dateText = (TextView) findViewById(R.id.editdate);
		dateText.setText(gotClaim.getfromdate() + " to " +gotClaim.gettodate());
		descText = (TextView) findViewById(R.id.editdescriptiontext);
		descText.setText(gotClaim.getDescription());
		
		/*
		 * Scrapped for now will re attempt if enough time
		//Sum all of the currencies
		ArrayList<Amount> amountslist = gotClaim.getAmountsList();
		for(int i = 0;i<gotClaim.getAmountsSize();i++){
			int addflag = 0;
			if((total.size() == 0)){
				total.add(amountslist.get(i));
			} else{ 
				for(int n = 0;n<total.size();n++){
					if (total.get(n).getCurrency() == amountslist.get(i).getCurrency()){
						total.get(n).setAmount(total.get(n).getAmount() + amountslist.get(i).getAmount());
						addflag++;
						Toast.makeText(Viewclaimactivity.this, String.valueOf(total.get(n).getAmount()), Toast.LENGTH_SHORT).show();
						
						} 
					}

				}
			
			}	
		
		ListView totalView = (ListView) findViewById(R.id.edittotal);
		ArrayAdapter<Amount> totalAdapter = new ArrayAdapter<Amount>(this, android.R.layout.simple_list_item_1, amountslist);
		totalView.setAdapter(totalAdapter);
		*/
		
		ListView listView = (ListView) findViewById(R.id.amount_listview);
		//Claim claim = ClaimListController.getClaimList().getClaimList().get(pos);
		final ArrayList<Amount> list = gotClaim.getAmountsList();
		ArrayAdapter<Amount> amountAdapter = new ArrayAdapter<Amount>(this, android.R.layout.simple_list_item_1, list);
		listView.setAdapter(amountAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.viewclaimactivity, menu);
		return true;
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	//Got from
	//http://www.mysamplecode.com/2012/11/android-spinner-set-selected-item-by-value.html
	//2/2/2015
	//A helper function to get the index by value for our spinners
	private int getIndex(Spinner spinner, String myString){
		 
		  int index = 0;
		 
		  for (int i=0;i<spinner.getCount();i++){
		   if (spinner.getItemAtPosition(i).equals(myString)){
		    index = i;
		   }
		  }
		  return index;
		 }
	
	
	//Reuse code from Add Claim Activity
	public boolean isNotEmpty(String name) {
		//http://stackoverflow.com/questions/4531396/get-value-of-a-edit-text-field
		//2/1/2015
	    char[] chars = name.toCharArray();
        if(name.isEmpty()){
        	return false;
        }else return true;
	}
	
	public void editclaimaction(View v){		
		if(!gotClaim.getStatus().equals("In Progress")){
			Toast.makeText(ViewAndEditExpenseActivity.this, "Sorry can't edit this claim is : " + gotClaim.getStatus(), 
					Toast.LENGTH_SHORT).show();
			finish();
		}else{
			claimText = (EditText) findViewById(R.id.editClaim);
			descText = (EditText) findViewById(R.id.editdescriptiontext);
			String ClaimTextFromField = claimText.getText().toString();
			String descriptionText = descText.getText().toString();
			boolean flag = isNotEmpty(ClaimTextFromField);
			if(flag == true){
				Expense ourClaim = new Expense();
			
				Spinner categoryS = (Spinner)findViewById(R.id.editcatpinner);
				String categorySet = categoryS.getSelectedItem().toString();
			
				Spinner statusS = (Spinner) findViewById(R.id.editstatspinner);
				String statusSet = statusS.getSelectedItem().toString();
				Toast.makeText(this,"Thanks for the Claim", Toast.LENGTH_SHORT).show();
			
			
				ourClaim.setName(ClaimTextFromField);
				ourClaim.setCategory(categorySet);
				ourClaim.setStatus(statusSet);
				ourClaim.setDescription(descriptionText);
				ourClaim.setDate(gotClaim.getfromdate(), gotClaim.gettodate());
				for(int i = 0; i < gotClaim.getAmountsSize(); i++){
					ourClaim.addAmount(gotClaim.getAmountsList().get(i));
				}
				//ClaimListController cs = new ClaimListController();
				//cs.setClaim(ourClaim,gotClaim);
				ExpenseListController.getClaimList().removeClaim(gotClaim);
				ExpenseListController.getClaimList().addClaim(ourClaim);
			
				finish();
			}
		}
	}
	public void amountaddedit(View v){
		
		Toast.makeText(this, "Adding an amount", Toast.LENGTH_SHORT).show();
		Spinner curSpin = (Spinner)findViewById(R.id.curspinneredit);
		String cur= curSpin.getSelectedItem().toString();
		
		ammountText = (EditText) findViewById(R.id.amountfieldedit);
		int amountFound = Integer.parseInt((ammountText.getText().toString()));
		Amount amount = new Amount();
		amount.setAmount(amountFound);
		amount.setCurrency(cur);
		gotClaim.addAmount(amount);
		ListView amountView = (ListView) findViewById(R.id.amount_listview);
		ArrayAdapter<Amount> amountAdapter = new ArrayAdapter<Amount>(this, android.R.layout.simple_list_item_1, gotClaim.getAmountsList());
		amountView.setAdapter(amountAdapter);
			
			
		}
	public void emailaction(View v){
		//Taken from http://stackoverflow.com/a/8284804
		//2/2/2015
		Intent send = new Intent(Intent.ACTION_SENDTO);
		String uriText = "mailto:" + Uri.encode("email@gmail.com") + 
		          "?subject=" + Uri.encode("the subject") + 
		          "&body=" + Uri.encode("the body of the message");
		Uri uri = Uri.parse(uriText);

		send.setData(uri);
		startActivity(Intent.createChooser(send, "Send mail..."));
	}

}
